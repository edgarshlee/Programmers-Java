import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i< n; i++) {
            // 주가가 떨어졌는지 확인한다.
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.push(i);
        }
        
        // 가격이 떨어지지 않은 주식들
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = n - 1 - index;
        }        
        
        return answer;
    }
}