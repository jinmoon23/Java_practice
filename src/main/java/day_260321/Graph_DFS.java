package day_260321;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
//import java.util.*;

public class Graph_DFS {
    public static List<String> solutions(String[][] graph, String start) {
        Map<String, List<String>> relations = new HashMap<>();
        for (String[] edge: graph) {
            String prev = edge[0], next = edge[1];
            if (!relations.containsKey(prev)) {
                relations.put(prev, new ArrayList<>());
            }
            relations.get(prev).add(next);
        }
        Set<String> visited = new HashSet<>();
        List<String> result = new ArrayList<>();

        dfs(start, relations, visited, result);

        return result;
    }
    public static void dfs(
            String node, Map<String, List<String>> relations, Set<String> visited, List<String> result
    ) {
        visited.add(node);
        result.add(node);
        List<String> neighbors = relations.getOrDefault(node, new ArrayList<>());
        for (String neighbor : neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, relations, visited, result);
            }
        }
    }
    public static void main(String[] args) {
        String[][] graph1 = {
                {"A", "B"},
                {"B", "C"},
                {"C", "D"},
                {"D", "E"}
        };
        String[][] graph2 = {
                {"A", "B"},
                {"A", "C"},
                {"B", "D"},
                {"B", "E"},
                {"C", "F"},
                {"E", "F"}
        };
        System.out.println(solutions(graph1, "A"));
        System.out.println(solutions(graph2, "A"));
    }
}
