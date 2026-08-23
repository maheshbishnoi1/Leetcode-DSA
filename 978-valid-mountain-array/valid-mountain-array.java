class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }
        int n = arr.length;
        int i = 0;
        int j = n-1;
        while(i < n-1 && arr[i] < arr[i+1]){
            i++;
        }

        while(j > 0 && arr[j] < arr[j-1]){
            j--;
        }

        return i == j && i != 0 && i != n-1;
    }
}