import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        // 출발지 -> 도착지 목록 . 우선순위 큐라서 poll()하면 알파벳이 가장 빠른 도착지가 나옴
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for (String[] t : tickets) {
            String from = t[0];
            String to = t[1];
            
            // 해당 출발지가 처음 나왔으면 빈 큐 만들기
            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<>());
            }
            
            graph.get(from).add(to);
        }
        
        LinkedList<String> route = new LinkedList<>();// 결과 (역순)
        Deque<String> stack = new ArrayDeque<>(); // 현재 따라가는 경로
        stack.push("ICN"); 
        
        while (!stack.isEmpty()) {
            String cur = stack.peek();
            PriorityQueue<String> next = graph.get(cur);
            
            if (next != null && !next.isEmpty()) {
                // 아직 쓸 티켓이 있으면 알파벳 순으로 가장 빠른 곳으로 이동
                stack.push(next.poll());
            } else {
                // 더 갈 곳이 없으면 경로의 "맨 뒤" 도시이므로 결과 앞쪽에 추가
                route.addFirst(stack.pop());
            }
        }
        
        return route.toArray(new String[0]);
    }
}