import java.util.*;

class Solution {
    
    public int solution(int[][] jobs) {
        int answer = 0;
        // 1.요청 시각 기준으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> (o1[0] - o2[0]));
        // 2.소요 시간 기준으로 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int completeCount = 0;
        int time = 0;
        int idx = 0;
        int len = jobs.length;
        
        while (completeCount < len) {
            // pq에 넣기
            // 현재 시간(time)보다 작업 작업들 모두 삽입
            while(idx < len && jobs[idx][0] <= time) {
                pq.add(jobs[idx]);
                idx++;
            }
            
            if (pq.isEmpty()) {
                // 그 다음에 들어올 작업의 요청시간으로 time(시간)점프
                time = jobs[idx][0];
            } else {
                int[] job = pq.poll();
                time += job[1];
                answer += time - job[0];
                completeCount++;
            }
        }
        
        
        return answer / len;
    }
}