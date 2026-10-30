class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 컴퓨터를 방문했다면? -> 새로운 네크워크 발견
            if (!visited[i]) {
                answer++; // 새로운 무리. 개수 + 1
                dfs(i, computers, visited);
            }    
        }    
        
        return answer;
    }
    
    public void dfs(int current, int[][] computers, boolean[] visited) {
        // 현재 컴퓨터 방문 처리
        visited[current] = true;
        
        // 다른 모든 컴퓨터를 중 내 컴퓨터와 연결된 것을 찾는다. 
        for (int i = 0; i < computers.length; i++) {
            if (computers[current][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}