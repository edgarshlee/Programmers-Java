class Solution {
    
    static int[] compress(int[][] arr, int x, int y, int size) {
        boolean allSame = true;
        int prev = arr[x][y];;
        for (int i=x; i < x+size; i++) {
            for (int j=y; j < y+size; j++) {
                if (prev == -1) {
                    prev = arr[i][j];
                    continue;
                } else {
                    if (prev != arr[i][j]) {
                        allSame = false;
                    }
                }                
            }    
        }
        // 1.모두 같을 때
        if (allSame) {
            if (prev ==0) {
                return new int[]{1,0};
            } else {
                return new int[]{0,1};
            }   
        } else {
            // 2.같지 않을 때는 분할 정복
            int[] rec1 = compress(arr,x,y,size/2);
            int[] rec2 = compress(arr,x+(size/2), y,size/2);
            int[] rec3 = compress(arr,x, y+(size/2),size/2);
            int[] rec4 = compress(arr,x+(size/2), y+(size/2), size/2);
            
            return new int [] {rec1[0]+rec2[0]+rec3[0]+rec4[0], rec1[1]+rec2[1]+rec3[1]+rec4[1]};
        }
    }
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int x =0;
        int y =0;
        answer = compress(arr,0,0,arr.length);
        
        return answer;
    }
}