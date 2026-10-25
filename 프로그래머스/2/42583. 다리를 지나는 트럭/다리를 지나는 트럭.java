import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        int sum = 0, idx = 0;
        
        for (int i=0; i<bridge_length; i++) {
            q.offer(0);
        }
        
        while (idx < truck_weights.length) {
            int current = q.poll();
            sum -= current;
            // 1. sum + 신규 truck < weight 작다면 truck이 다리 올라갈 수 있다.
            if (sum + truck_weights[idx] <= weight) {                
                q.offer(truck_weights[idx]);                
                sum += truck_weights[idx];
                idx++;
            } else {
                q.offer(0);
            }
            // 초 증가
            answer++;                        
        }
        
        return answer + bridge_length;
    }
}