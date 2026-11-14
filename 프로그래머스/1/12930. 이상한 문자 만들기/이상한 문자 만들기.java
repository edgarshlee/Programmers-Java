
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int idx = -1;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                idx = -1;
            } else {
                idx++;
            }              
            if (idx % 2 == 0) {
                // 짝수
                answer.append(Character.toUpperCase(c));
            } else {
                // 홀수
                answer.append(Character.toLowerCase(c));
            }
            // System.out.println(c);
        }
        
        return answer.toString();
    }
}