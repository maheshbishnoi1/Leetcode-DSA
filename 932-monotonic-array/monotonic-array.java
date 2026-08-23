class Solution {
    public boolean isMonotonic(int[] nums) {
        int i = 0;
        int j = nums.length-1;

        if(nums.length == 0 || nums.length == 1){
            return true;
        }

        if(nums[i] == nums[j]){
            i++;
        }

        if(nums[i] > nums[j]){
            while( i < nums.length-1){
                if(nums[i] < nums[i+1]){
                    return false;
                }
                i++;
            }
        }
        if(nums[i] < nums[j]){
            while( i < nums.length-1){
                if(nums[i] > nums[i+1]){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}