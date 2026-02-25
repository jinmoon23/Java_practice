package day_260225;

import java.util.ArrayList;
import java.util.List;

public class combinations {
    static List<List<String>> combination(String[] arr, int r) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        comb(arr, r, 0, path, result);

        return result;
    }
    static void comb(
            String[] arr, int r, int start, List<String> path, List<List<String>> result) {
        if (path.size() == r) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);
            comb(arr, r, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "e"};
        System.out.println(combination(arr, 2));
    }
}
