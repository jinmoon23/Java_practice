package day_260324;
import java.util.PriorityQueue;

public class MinHeap {
  public static void main(String[] args) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    minHeap.offer(5);
    minHeap.offer(3);
    minHeap.offer(10);
    minHeap.offer(1);
    System.out.println(minHeap);
    // 맨 앞 값 꺼내기
    System.out.println(minHeap.poll());
    // 맨 앞 값 확인만 하기
    System.out.println(minHeap.peek());
  } 
}