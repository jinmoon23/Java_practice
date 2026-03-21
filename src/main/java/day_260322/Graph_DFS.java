package day_260322;
import java.util.*;

public class Graph_DFS {
  public static void dfs(
    String node, Map<String, List<String>> connections, Set<String> visited, List<String> result
  ) {
    visited.add(node); result.add(node);
    List<String> neighbors = connections.getOrDefault(node, new ArrayList<>());
    for (String neighbor : neighbors) {
      if (!visited.contains(neighbor)) {
        dfs(neighbor, connections, visited, result);
      }
    }
  }
  public static List<String> solutions(String[][] graph, String start) {
    // 1. HashMap으로 graph 표현
    Map<String, List<String>> connections = new HashMap<>();
    for (String[] edge : graph) {
      String curr = edge[0], next = edge[1];
      if (!connections.containsKey(curr)) connections.put(curr, new ArrayList<String>());
      connections.get(curr).add(next);
    }
    List<String> result = new ArrayList<>();
    Set<String> visited = new HashSet<>();

    dfs(start, connections, visited, result);

    return result;
  }
  public static void main(String[]args) {
    String[][] graph1 = {{"A", "B"}, {"B", "C"}, {"C", "D"}, {"D", "E"}};
    String[][] graph2 = {{"A", "B"}, {"A", "C"}, {"B", "D"}, {"B", "E"}, {"C", "F"}, {"E", "F"}};

    System.out.println(solutions(graph1, "A"));
    System.out.println(solutions(graph2, "A"));
  }
}