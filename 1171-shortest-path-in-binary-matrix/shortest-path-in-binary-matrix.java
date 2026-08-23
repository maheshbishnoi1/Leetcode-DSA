class Solution {
    class Pair{
        int x;
        int y;
        int d;
        Pair(int x,int y,int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    int dir[][] = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0},
        {-1,-1},
        {-1,1},
        {1,1},
        {1,-1}
    };

    boolean isSafe(int x,int y,int m,int n){
        return x >= 0 && y >= 0 && x < m && y < n;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] != 0 || grid[m-1][n-1] != 0){
            return -1;
        }

        //dis array for ans count zeros
        int[][] dis = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.d - b.d);
        pq.add(new Pair(0,0,1));
        grid[0][0] = 1;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            int x = curr.x;
            int y = curr.y;
            int d = curr.d;

            //destination
            if(x == m-1 && y == n-1){
                return d;
            }

            for(int[] dr : dir){
                int newx = x + dr[0];
                int newy = y + dr[1];

                if(isSafe(newx,newy,m,n) && grid[newx][newy] == 0){
                    int newd = d + 1;
                    if(newd < dis[newx][newy]){
                        dis[newx][newy] = newd;
                        pq.add(new Pair(newx,newy,newd));
                        grid[newx][newy] = 1;
                    }
                }
            }
        }
        return -1;
    }
}