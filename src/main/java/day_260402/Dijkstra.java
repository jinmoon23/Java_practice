package day_260402;
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
    Map<String, Integer> distances = new HashMap<>();
    for (String node : graph.keySet()) {
      distances.put(node, Integer.MAX_VALUE);
    }
    distances.put(start, 0);

    Map<String, List<String>> paths = new HashMap<>();
    paths.put(start, new ArrayList<>());
    paths.get(start).add(start);

    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(node -> node.distance));
    pq.offer(new Node(start, distances.get(start)));

    while (!pq.isEmpty()) {
      Node n = pq.poll();
      String currNode = n.name;
      int currDist = n.distance;
      if (distances.get(currNode) < currDist) continue;

      Map<String, Integer> neighborNodes = graph.get(currNode);
      for (String node : neighborNodes.keySet()) {
        int weight = neighborNodes.get(node);
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
    System.out.println("distances = " + result.distances);
    System.out.println("paths = " + result.paths);
  }
}