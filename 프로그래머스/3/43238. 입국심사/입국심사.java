import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        long max = (long) times[times.length-1] * n; // 최악의 시간
        long min = 1; 
        
        while(min <= max) {
            long mid = (max + min) / 2;
            
            long sum = 0; // 처리할 수 있는 사람 수 (long)
            // mid 값으로 times 배열의 시간 값을 가진 심사관들이 몇명 심사할 수 있는지
            for(int time : times) {
                sum += mid / time;
            }
            
            if(sum < n) {
                min = mid+1;
            } else {
                max = mid-1;
                answer = mid;
            }
        }
        
        return answer;
    }
}