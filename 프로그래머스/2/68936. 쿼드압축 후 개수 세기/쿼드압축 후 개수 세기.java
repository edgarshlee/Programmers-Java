class Solution {    
    static int[] answer = new int[2]; 
    
    public int[] solution(int[][] arr) {        
        compress(arr,0,0,arr.length);
        
        return answer;
    }        
    
    private void compress(int[][] arr, int x, int y, int size) {        
        // 1.모두 같을 때
        if (isAllSame(arr, x, y, size)) {
            answer[arr[x][y]]++; 
            return;
        }
        
        // 2.같지 않을 때는 분할 정복
        int half = size/2;
        compress(arr, x, y, half); // 좌상단
        compress(arr, x+half, y, half); // 좌하단
        compress(arr, x, y+half, half); // 우상단
        compress(arr, x+half, y+half, half); // 우하단
    }
    
    private boolean isAllSame(int[][] arr, int x, int y, int size) { 
        int target = arr[x][y];
        for (int i=x; i < x+size; i++) {
            for (int j=y; j < y+size; j++) {
                if (target != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
        
}