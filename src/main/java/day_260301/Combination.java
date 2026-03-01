package day_260301;
import java.util.List;
import java.util.ArrayList;

public class Combination {
    static List<List<String>> combination(String[] arr, int r) {
        List<List<String>> result = new ArrayList<>();
        List<String> picked = new ArrayList<>();

        backtrack(arr, r, result, picked,0);

        return result;
    }
    static void backtrack(String[] arr, int r, List<List<String>> result, List<String> picked, int start) {
        if (picked.size() == r) {
            result.add(new ArrayList<>(picked));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            picked.add(arr[i]);
            backtrack(arr, r, result, picked, i + 1);
            picked.remove(picked.size() - 1);
        }
    }
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "e"};
        System.out.println(combination(arr, 2));
    }
}
