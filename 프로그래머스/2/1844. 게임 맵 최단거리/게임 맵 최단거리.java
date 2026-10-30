import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        // 상, 하, 좌, 우 이동을 위한 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            
            if(x == n-1 && y == m-1) {
                answer = maps[x][y]; // [수정] 현재 칸에 기록된 최단 거리를 정답에 대입
                break;
            }
            
            for (int i=0; i <4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 1단계: 맵의 경계를 벗어나는지 먼저 체크 (이게 먼저 와야 에러가 안 납니다)
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 2단계: 갈 수 있는 길(1)인지 체크
                    if (maps[nx][ny] == 1) {
                        maps[nx][ny] = maps[x][y] + 1; // 거리 갱신 및 방문 처리
                        q.add(new int[]{nx, ny});
                    }
                }
                
            }
        }        
        
        return answer;
    }        
}