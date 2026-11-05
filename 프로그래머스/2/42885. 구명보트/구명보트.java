import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int left = 0, right = people.length-1;
        // sort
        Arrays.sort(people);
        // System.out.println(Arrays.toString(people));
        while (left <= right) {
            if(people[left] + people[right] <= limit) {
                right--;
                left++;
                answer++;
            } else {
                right--;
                answer++;
            }
        }
        
        return answer;
    }
}