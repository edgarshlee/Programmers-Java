import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[0] * n; 
        long answer = right;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = 0;
            
            for (int time : times) {
                sum += mid / time;
                // 이미 n명 이상 처리 가능하다면 더 이상 계산하지 않고 종료
                if (sum >= n) {
                    break;
                }
            }
            
            if (sum < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
}