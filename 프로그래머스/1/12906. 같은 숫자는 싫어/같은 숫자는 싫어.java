import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        // 이전 값과 다를 때만 deque에 넣는다.
        for (int num : arr) {
            if (deque.isEmpty() || deque.peekLast() != num) {
                deque.addLast(num);
            }
        }
        // System.out.println(deque);
        
        // int배열로 변환
        int[] answer = new int[deque.size()];
        for (int i=0; i < answer.length; i++) {
            answer[i] = deque.poll();
        }
        
        return answer;
    }
}