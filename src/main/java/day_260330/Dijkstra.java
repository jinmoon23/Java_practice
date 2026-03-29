package day_260330;
import java.util.*;

public class Dijkstra {
  public static class Node {
    String name;
    int distance;

    Node(String name, int distance) {
      this.name = name;
      this.distance = distance;
    }
  }
  public static class Result {
    Map<String, Integer> distances;
    Map<String, List<String>> paths;

    Result(Map<String, Integer> distances, Map<String, List<String>> paths) {
      this.distances = distances;
      this.paths = paths;
    }
  }
  public static Result solutions(Map<String, Map<String, Integer>> graph, String start) {
    // 1. distances Map 초기화 
    Map<String, Integer> distances = new HashMap<>();
    for (String node : graph.keySet()) {
      distances.put(node, Integer.MAX_VALUE);
    }

    // 2. 시작노드의 거리 0으로 초기화
    distances.put(start, 0);

    // 3. paths Map 초기화
    Map<String, List<String>> paths = new HashMap<>();
    paths.put(start, new ArrayList<>());
    paths.get(start).add(start);

    // 4. 우선순위 큐 초기화
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.distance));
    pq.offer(new Node(start, distances.get(start)));

    while (!pq.isEmpty()) {
      Node poppedNode = pq.poll();
      String currNode = poppedNode.name;
      int currDist = poppedNode.distance;
      if (distances.get(currNode) < currDist) continue;

      Map<String, Integer> neighborMap = new HashMap<>(graph.get(currNode));
      for (String node : neighborMap.keySet()) {
        int weight = neighborMap.get(node);
        int distance = weight + currDist;

        if (distance < distances.get(node)) {
          distances.put(node, distance);
          pq.offer(new Node(node, distance));
          List<String> newPath = new ArrayList<>(paths.get(currNode));
          newPath.add(node);
          paths.put(node, newPath);
        }
      }
    }
    return new Result(distances, paths);
  }
  public static void main(String[] args) {
    Map<String, Map<String, Integer>> graph = new HashMap<>();
    graph.put("A", Map.of("B", 1, "C", 4));
    graph.put("B", Map.of("C", 2, "D", 5));
    graph.put("C", Map.of("D", 1));
    graph.put("D", Map.of());

    Result result = solutions(graph, "A");

    System.out.println(result.distances);
    System.out.println(result.paths);
  }
}