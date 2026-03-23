package day_260323;
import java.util.*;


public class Graph_BFS {
  public static void bfs(
    String node, Map<String, List<String>> mapped, Set<String> visited, List<String> result
  ) {
    Deque<String> q = new ArrayDeque<>();
    q.addLast(node);
    visited.add(node);
    result.add(node);

    while(!q.isEmpty()) {
      String popped = q.pollFirst();
      List<String> connected = mapped.getOrDefault(popped, new ArrayList<>());
      for (String nextNode : connected) {
        if (!visited.contains(nextNode)) {
          q.addLast(nextNode);
          visited.add(nextNode);
          result.add(nextNode);
        }
      }
    }
  }
  public static List<String> solutions(String[][] graph, String start) {
    Map<String, List<String>> mapped = new HashMap<>();
    for (String[] edges : graph) {
      String st = edges[0], en = edges[1];
      if (!mapped.containsKey(st)) mapped.put(st, new ArrayList<>());
      mapped.get(st).add(en);
    } 

    Set<String> visited = new HashSet<>();
    List<String> result = new ArrayList<>();

    bfs(start, mapped, visited, result);

    return result;
  }
  public static void main(String[] args) {
    String[][] graph1 = {{"A", "B"}, {"B", "C"}, {"C", "D"}, {"D", "E"}};
    String[][] graph2 = {{"A", "B"}, {"A", "C"}, {"B", "D"}, {"B", "E"}, {"C", "F"}, {"E", "F"}};

    System.out.println(solutions(graph1, "A"));
    System.out.println(solutions(graph2, "A"));
  }
}