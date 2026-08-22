class Solution {
    class pair{
        int x;
        int y;
        pair(int x,int y){
            this.x = x;
            this.y = y;
         }
    }
int[][] dir = {
    {-1,  0}, // Up
    { 1,  0}, // Down
    { 0, -1}, // Left
    { 0,  1}, // Right
    {-1, -1}, // Top-Left
    {-1,  1}, // Top-Right
    { 1, -1}, // Bottom-Left
    { 1,  1}  // Bottom-Right
};

boolean isSafe(int x,int y,int m,int n){
    return x >= 0 && y >= 0 && x < m && y < n;
}
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m == 0 || n == 0 || grid[0][0] != 0){
            return -1;
        }

        Queue<pair> q = new LinkedList<>();

        q.add(new pair(0,0));
        grid[0][0] = 1;
        int count = 1;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                pair curr = q.peek();
                q.remove();
                int x = curr.x;
                int y = curr.y;
            
                if(x == m-1 && y == n-1){
                    return count;
                }

                for(int[] d : dir){
                    int newx = x + d[0];
                    int newy = y + d[1];

                    if(isSafe(newx,newy,m,n) && grid[newx][newy] == 0){
                    q.add(new pair(newx,newy));
                    grid[newx][newy] = 1;
                }
                }     

            }
            count++;
        }
        return -1;
    }
}