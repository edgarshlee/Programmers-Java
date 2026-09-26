import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] command = new int[3];
        for(int m=0; m < commands.length; m++) {
            command = commands[m];
            // init variable
            int i = command[0];
            int j = command[1];
            int k = command[2];
            
            // 1. 자르기
            int[] sub = new int[j-i+1];
            int idx =0;
            for (int l=i-1; l < j; l++) {
                // System.out.println("l:" + l + ",idx:" + idx);
                sub[idx++] = array[l];
            }
            // 2. sort
            Arrays.sort(sub);
            // System.out.println(Arrays.toString(sub));
            // 3. Select K
            // System.out.println("m:"+m + ",k:" + k);
            answer[m] = sub[k-1];
        }
        // System.out.println(sub);
        return answer;
    }
}