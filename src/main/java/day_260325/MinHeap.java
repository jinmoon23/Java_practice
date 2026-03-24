package day_260325;

import java.util.PriorityQueue;

public class MinHeap {
  public static void main(String[] args) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int[] arr = {5,3,10,1};
    for (int i : arr) {
      minHeap.offer(i);
    }
    System.out.println(minHeap.poll()); // pop과 동일하게 동작
    System.out.println(minHeap.peek()); // 값을 빼내지는 않고 조회만 함
  }
}