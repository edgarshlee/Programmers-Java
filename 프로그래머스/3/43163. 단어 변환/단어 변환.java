import java.util.*;

class Solution {
    
    public int diffCount(String word1, String word2) {
        int diffCnt = 0;
        
        for (int w=0; w < word1.length(); w++) {
            if (word1.charAt(w) != word2.charAt(w)) {
                diffCnt++;                            
            }
        }
        return diffCnt;
    }
    
    static class Node {
        String word;
        int count;
        
        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;        
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        Arrays.fill(visited, false);
                
        q.offer(new Node(begin,0));
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            // 목표 단어에 도달하면 횟수 return 
            if (curr.word.equals(target)) {
                return curr.count;
            }
            
            for (int i=0; i < words.length; i++) {
                // 미방문 + 다른 단어가 1개일 때
                if (visited[i] == false && diffCount(curr.word, words[i]) == 1) {
                    int newCount = curr.count+1;
                    System.out.println("Insert: " + words[i] + ",newCount:" + newCount);
                    q.offer(new Node(words[i], newCount));
                    visited[i] = true;
                }
            }
        }
        
        return answer;
    }
}