import java.util.*;

class Solution {    
    private static int MOD = 26;
    
    private StringBuilder move(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] oriArr = s.toCharArray();        
        
        for (int i=0; i < s.length(); i++) {  
            if ( oriArr[i] == ' ') {
                sb.append(oriArr[i]);
                continue;
            }    
            // 대소문자 start문자
            char firstChar = Character.isUpperCase(oriArr[i]) ? 'A' : 'a';
            char newChar = (char)((int)firstChar + (((int)oriArr[i] - (int)firstChar + n) % MOD));
            sb.append(String.valueOf(newChar));
        }
        return sb;
    }
    
    public String solution(String s, int n) {
        // String answer = "";
        StringBuilder answer = move(s, n);
//         StringBuilder sb = new StringBuilder();
        
//         for (int i=0; i < answer.length; i++) {
//             sb.append(String.valueOf(answer[i]));
//         }    
        
        return answer.toString();
    }
}