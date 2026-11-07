import java.util.*;

class Solution {
    public int[] solution(int n) {        
        int[][] matrix = new int[n][n];                     
        
        int maxNumber = n * (n + 1) / 2;
        int[] answer = new int[maxNumber];
        int num = 1;
        int x = 0;
        int y = -1;
        // System.out.println("total:" + total);
        
        // i: 한번에 가는 방향
        for (int i=0; i < n; i++) {
            for (int j=i; j < n; j++) {                
                if (i % 3 == 0) {
                    // 아래
                    y++;
                } else if (i % 3 == 1) {
                    // 오른쪽
                    x++;
                } else if (i % 3 == 2) {
                    // 왼쪽 위
                    x--;
                    y--;
                }
                matrix[y][x] = num++;
            }    
        }
        
        
        // Print       
        int idx = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                // System.out.print(matrix[i][j]+" ");
                answer[idx++] = matrix[i][j];
            }
            // System.out.println();
        }        
        
        
        return answer;
    }
}