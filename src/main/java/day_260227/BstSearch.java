package day_260227;

import java.util.ArrayList;
import java.util.List;

public class BstSearch {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }
    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    static boolean search(Node root, int val) {
        if (root == null) return false;
        if (val == root.val) return true;

        if (val < root.val) return search(root.left, val);
        return search(root.right, val);
    }

    static List<Boolean> solutions(int[] lst, int[] searchList) {
        Node root = null;
        for (int val : lst) {
            root = insert(root, val);
        }
        List<Boolean> result = new ArrayList<Boolean>();
        for (int val : searchList) {
            result.add(search(root, val));
        }
        return result;
    }
    public static void main(String[] args) {
        int[] lst = {5,3,8,4,2,1,7,10};
        int[] searchList = {1,2,5,6};
        System.out.println(solutions(lst, searchList));
    }
}
