class Solution {
    public int[] solution(long n) {        
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        int[] answer = new int[chars.length];
        for (int i=chars.length-1; i >= 0; i--) {
            answer[chars.length -i-1] = Integer.parseInt(String.valueOf(chars[i]));
        }
        // System.out.println(chars);
            
        return answer;
    }
}