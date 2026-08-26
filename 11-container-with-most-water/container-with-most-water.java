class Solution {
    public int maxArea(int[] height) {
        int maxWat = 0;
        int lp = 0;
        int rp = height.length-1;

        while(lp < rp){
            int ht = Math.min(height[lp],height[rp]);
            int wd = rp - lp;
            int currwat = ht * wd;

            maxWat = Math.max(maxWat,currwat);

            if(height[lp] < height[rp]){
                lp++;
            } else {
                rp--;
            }
        }
        return maxWat;
    }
}