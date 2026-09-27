import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxw = 0, maxh = 0;
        // 1.명함 재배치
        for (int[] a : sizes) {
            // 더 큰 값이 가로로 가도록.
            if (a[1] > a[0]) {
                int temp = a[0];
                a[0] = a[1];
                a[1] = temp;
            }
        }    
        
        // 2. Get 가로, 세로 Max
        for (int[] a : sizes) {
            // 가로
            maxw = Math.max(maxw, a[0]);
            // 세로 
            maxh = Math.max(maxh, a[1]);
        }
        // System.out.println("maxw:" + maxw + ", maxh:" + maxh);
        
        return maxw * maxh;
    }
}