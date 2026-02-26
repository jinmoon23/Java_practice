package day_260226;

import java.util.ArrayList;
import java.util.List;

public class TreeLoop {
    enum Order {PRE, IN, POST};

    static List<Integer> loop(int[] nodes, Order order) {
        List<Integer> result = new ArrayList<>();
        switch(order) {
            case PRE -> preorder(nodes, 0, result);
            case IN -> inorder(nodes, 0, result);
            case POST -> postorder(nodes, 0, result);
        }
        return result;
    }
    static void preorder(int[] nodes, int idx, List<Integer> result) {
        if (idx >= nodes.length) return;

        result.add(nodes[idx]);
        preorder(nodes, idx * 2 + 1, result);
        preorder(nodes, idx * 2 + 2, result);
    }
    static void inorder(int[] nodes, int idx, List<Integer> result) {
        if (idx >= nodes.length) return;

        inorder(nodes, idx * 2 + 1, result);
        result.add(nodes[idx]);
        inorder(nodes, idx * 2 + 2, result);
    }

    static void postorder(int[] nodes, int idx, List<Integer> result) {
        if (idx >= nodes.length) return;

        postorder(nodes, idx * 2 + 1, result);
        postorder(nodes, idx * 2 + 2, result);
        result.add(nodes[idx]);
    }
    public static void main(String[] args) {
        int[] nodes = {1,2,3,4,5,6,7};
        System.out.println(loop(nodes, Order.PRE));
        System.out.println(loop(nodes, Order.IN));
        System.out.println(loop(nodes, Order.POST));
    }
}
