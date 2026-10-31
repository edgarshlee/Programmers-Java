import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int s : scoville) {
            pq.add(s);
        }
        
        while(pq.peek() < K) {
            // 더 이상 섞을 음식이 없고 K보다 작은 경우 -1 리턴
            if (pq.size() < 2) {
                return -1;
            }           
            int first = pq.poll();
            int second = pq.poll();
            
            int newScoville = first + (second * 2);
            pq.add(newScoville);
            answer++;
        }
        
        return answer;
    }
}