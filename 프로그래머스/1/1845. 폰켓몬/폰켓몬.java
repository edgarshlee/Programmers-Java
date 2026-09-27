import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int maxCount = nums.length / 2 ;
        
        for (int num : nums) {
            set.add(num);   
        }
        
        return set.size() > maxCount ? maxCount : set.size();
    }
}