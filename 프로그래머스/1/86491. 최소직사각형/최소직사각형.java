import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int length = 0, height = 0;   
        
        for (int[] card : sizes) {
            length = Math.max(length, Math.max(card[0], card[1]));
            height = Math.max(height, Math.min(card[0], card[1]));
        }
        answer = length * height;        
        return answer;
    }
}