import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i=0; i < operations.length; i++) {
            if (operations[i].equals("D 1")) {
                if (!maxPQ.isEmpty()) {
                    int maxVal = maxPQ.poll();    
                    minPQ.remove(maxVal);
                }
            } else if (operations[i].equals("D -1")) {
                if (!minPQ.isEmpty()) {
                    int minVal = minPQ.poll();    
                    maxPQ.remove(minVal);
                }                
            } else {
                String[] values = operations[i].split(" ");
                minPQ.add(Integer.parseInt(values[1]));
                maxPQ.add(Integer.parseInt(values[1]));
            }    
        }
            
        // System.out.println(minPQ);
        // System.out.println(maxPQ);
        answer[0] = (maxPQ.size() >0) ? maxPQ.peek() : 0;
        answer[1] = (minPQ.size() >0) ? minPQ.peek() : 0;
        
        return answer;
    }
}