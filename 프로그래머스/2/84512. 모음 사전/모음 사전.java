class Solution {
    private static final String[] VOWELS = {"A","E","I","O","U"};
    private int count = 0;
    private int answer = 0;
    private boolean isFound = false;
    
    public int solution(String word) {
        dfs("", word);        
        return answer;
    }
    
    private void dfs(String current, String target) {
        if (isFound || current.length() > 5) {
            return;
        }
        
        if (!current.isEmpty()) {
            count++;
            if (current.equals(target)) {
                answer = count;
                isFound = true;
                return;
            }
        }
        
        for (String vowel : VOWELS) {
            dfs(current + vowel , target);
        }
    }
}