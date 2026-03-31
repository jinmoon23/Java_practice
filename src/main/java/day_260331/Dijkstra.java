package day_260331;
import java.util.*;

public class Dijkstra {
  static class Node {
    String name;
    int distance;

    Node(String name, int distance) {
      this.name = name;
      this.distance = distance;
    }
  }
  static class Result {
    Map<String, Integer> distances;
    Map<String, List<String>> paths;

    Result(Map<String, Integer> distances, Map<String, List<String>> paths) {
      this.distances = distances;
      this.paths = paths;
    }
  }
  public static Result solutions(Map<String, Map<String, Integer>> graph, String start) {
    Map<String, Integer> distances = new HashMap<>();
    for (String node : graph.keySet()) {
      distances.put(node, Integer.MAX_VALUE);
    }

    distances.put(start, 0);

    Map<String, List<String>> paths = new HashMap<>();
    paths.put(start, new ArrayList<>());
    paths.get(start).add(start);

    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(n -> n.distance));
    pq.offer(new Node(start, distances.get(start)));

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      String currNode = node.name;
      int currDist = node.distance;
      if (distances.get(currNode) < currDist) continue;

      Map<String, Integer> neighborNodes = new HashMap<>(graph.get(currNode));
      for (String neigborNode : neighborNodes.keySet()) {
        int weight = neighborNodes.get(neigborNode);
        int distance = weight + currDist;

        if (distance < distances.get(neigborNode)) {
          distances.put(neigborNode, distance);
          pq.offer(new Node(neigborNode, distance));
          List<String> newPath = new ArrayList<>(paths.get(currNode));
          newPath.add(neigborNode);
          paths.put(neigborNode, newPath);
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
    System.out.println("distances: " + result.distances);
    System.out.println("paths: " + result.paths);
  }
}