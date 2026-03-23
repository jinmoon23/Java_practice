package day_260323;
import java.util.*;

public class Graph_DFS {
  public static void dfs(
    String node, Map<String, List<String>> mapped, Set<String> visited, List<String> result
  ) {
    visited.add(node);
    result.add(node);

    List<String> connected = mapped.getOrDefault(node, new ArrayList<>());
    for (String nextNode : connected) {
      if (!visited.contains(nextNode)) {
        dfs(nextNode, mapped, visited, result);
      }
    }
  }
  public static List<String> solutions(String[][] graph, String start) {
    Map<String, List<String>> mapped = new HashMap<>();
    for (String[] edges : graph) {
      String s = edges[0], e = edges[1];
      if (!mapped.containsKey(s)) mapped.put(s, new ArrayList<>());
      mapped.get(s).add(e);
    }

    Set<String> visited = new HashSet<>();
    List<String> result = new ArrayList<>();

    dfs(start, mapped, visited, result);

    return result;
  }
  public static void main(String[] args) {
    String[][] graph1 = {{"A", "B"}, {"B", "C"}, {"C", "D"}, {"D", "E"}};
    String[][] graph2 = {{"A", "B"}, {"A", "C"}, {"B", "D"}, {"B", "E"}, {"C", "F"}, {"E", "F"}};

    System.out.println(solutions(graph1, "A"));
    System.out.println(solutions(graph2, "A"));
  }
}
