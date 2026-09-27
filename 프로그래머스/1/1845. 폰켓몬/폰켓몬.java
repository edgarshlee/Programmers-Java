import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int maxCount = nums.length / 2 ;
        
        for (int num : nums) {
            if (set.size() < maxCount) {
                set.add(num);
            }    
        }
        // System.out.println(set.size());        
        answer = set.size();            
        return answer;
    }
}