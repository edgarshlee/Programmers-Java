import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length; // 체육복 가진 학생 수를 answer에 더해준다.     
        
        // 1. 오름차순 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // case1. 여벌 옷을 가져온 학생이 도난당한 경우
        for (int i=0; i < lost.length; i++) {
            for (int j=0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break; // 추가 counting 방지
                }
            }    
        }
        // case2. 여벌 옷을 가져온 학생의 왼쪽, 오른쪽 학생이 도난당한 경우
        for (int i=0; i < lost.length; i++) {
            for (int j=0; j < reserve.length; j++) {
                if (lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break; // 추가 counting 방지
                }
            }    
        }
        
        return answer;
    }
}