package day_260325;
import java.util.PriorityQueue;
import java.util.Collections;

public class MaxHeap {
  public static void main(String[] args) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    int[] arr = {5,3,10,1};
    for (int i : arr) {
      maxHeap.offer(i);
    }
    System.out.println(maxHeap);
    System.out.println(maxHeap.poll());
    System.out.println(maxHeap);
    System.out.println(maxHeap.poll());
  }
}