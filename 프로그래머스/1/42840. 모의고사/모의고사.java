import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int[] counts = new int[3];
        Arrays.fill(counts,0);
        
        for (int i=0; i < answers.length; i++) {
            // 1번
            if (answers[i] == one[i % one.length]) {
                counts[0]++;
            }
            // 2번
            if (answers[i] == two[i % two.length]) {
                counts[1]++;
            }
            // 3번
            if (answers[i] == three[i % three.length]) {
                counts[2]++;
            }
        }        
        // System.out.println("1:"+counts[0] + ", 2:"+counts[1] + ", 3:"+counts[2]);
        int max = -1;
        List<Integer> answer = new ArrayList<>();
        for (int c: counts) {
            max = Math.max(max, c);
        }
        for (int i=0; i< counts.length; i++) {
            if (counts[i] == max) answer.add(i+1);    
        }
        // System.out.println(answer);
            
        return answer.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
    }
}