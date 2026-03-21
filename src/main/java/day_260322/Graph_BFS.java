package day_260322;
import java.util.*;

public class Graph_BFS {
  public static void bfs(
    String node, Map<String, List<String>> connections, Set<String> visited, List<String> result
  ) {
    Deque<String> q = new ArrayDeque<>();
    q.addLast(node);
    visited.add(node);
    result.add(node);

    while(!q.isEmpty()) {
      String current = q.pollFirst();
      List<String> neighbors = connections.getOrDefault(current, new ArrayList<>());
      for (String neighbor : neighbors) {
        if (!visited.contains(neighbor)) {
          q.addLast(neighbor);
          visited.add(neighbor);
          result.add(neighbor);
        }
      }
    }
  }

  public static List<String> solutions(String[][] graph, String start) {
    Map<String, List<String>> connections = new HashMap<>();
    for (String[] edge : graph) {
      String curr = edge[0], next = edge[1];
      if (!connections.containsKey(curr)) connections.put(curr, new ArrayList<>());
      connections.get(curr).add(next);
    }

    List<String> result = new ArrayList<>();
    Set<String> visited = new HashSet<>();

    bfs(start, connections, visited, result);

    return result;
  }
  public static void main(String[] args) {
    String[][] graph1 = {{"A", "B"}, {"B", "C"}, {"C", "D"}, {"D", "E"}};
    String[][] graph2 = {{"A", "B"}, {"A", "C"}, {"B", "D"}, {"B", "E"}, {"C", "F"}, {"E", "F"}};

    System.out.println(solutions(graph1, "A"));
    System.out.println(solutions(graph2, "A"));
  }
}
