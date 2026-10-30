import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        for (int i=0; i < citations.length; i++) {
            if (citations[i] > 0) {
                int citCount = citations.length - i; // 인용횟수
                if (citations[i] >= citCount ) {
                    answer = citCount;
                    break;
                }
            }
        }
        
        return answer;
    }
}