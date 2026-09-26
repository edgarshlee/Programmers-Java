import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 1. participant의 개수를 넣는다.
        for (String p : participant) {
            map.put(p, map.getOrDefault(p,0)+1);
        }
        // 2. completion에 존재할 경우 value-1. 즉, 존재하면 값은 0임
        for (String c : completion) {
            map.put(c, map.get(c)-1);
        }
        // 3.value가 1인 값이 완주를 못한 선수
        for (String key : map.keySet()) {
            if(map.get(key) != 0) {
                return key;
            }
        }
        
        return answer;
    }
}