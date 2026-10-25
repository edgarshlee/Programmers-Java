import java.util.*;

class Solution {
    public static class Process {
        int idx;
        int priority;
        
        // 생성자
        public Process (int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 대기 큐
        Queue<Process> queue = new LinkedList<>();
        // 가장 높은 우선순위를 뽑아보기 위한 큐(내림차순 정렬)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());        
        
        for (int i=0; i< priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
            pq.offer(priorities[i]);
        }
        
        while(!queue.isEmpty()) {
            Process current = queue.poll();
            
            if (current.priority == pq.peek()) {
                answer++; // 1증가
                pq.poll(); 
                if (current.idx == location) {
                    return answer;
                }                
            } else {
                // 다른 더 높은 우선순위 큐가 존재할 때
                // 실행하지 못하므로 queue의 마지막에 넣는다. 
                queue.offer(current);
            }
        }                
        
        return answer;
    }
}