package day_260329;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

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
    // 1. 각 노드 이름에 따라 최대값 초기화
    Map<String, Integer> distances = new HashMap<>();
    for (String node : graph.keySet()) {
      distances.put(node, Integer.MAX_VALUE);
    }
    // 2. 시작노드 거리 0으로 초기화
    distances.put(start, 0);
    
    // 3. paths 시작노드 초기화
    Map<String, List<String>> paths = new HashMap<>();
    paths.put(start, new ArrayList<>());
    paths.get(start).add(start);
    
    // 4. 우선순위 큐 초기화
    // Node 클래스 선언하고 Node 인스턴스의 속성인 instance에 따라 우선순위를 가지는 pq 선언
    PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
    
    // 5. pq 초기화
    pq.offer(new Node(start, distances.get(start)));

    while(!pq.isEmpty()) {
      Node node = pq.poll();
      String currentNode = node.name;
      int currentDistance = node.distance;

      if (distances.get(currentNode) < currentDistance) continue;
      
      Map<String, Integer> neighborNodes = graph.get(currentNode);
      // 6. 인접 노드 순회
      for (String nodeName : neighborNodes.keySet()) {
        int weight = neighborNodes.get(nodeName);
        int distance = weight + currentDistance;
        // 7. 거리가 더 작으면 더 최단거리 이므로 교체
        if (distance < distances.get(nodeName)) {
          distances.put(nodeName, distance);
          pq.offer(new Node(nodeName, distance));
          List<String> newPath = new ArrayList<>(paths.get(currentNode));
          newPath.add(nodeName);
          paths.put(nodeName, newPath);
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