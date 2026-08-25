class Solution {
    public boolean squareIsWhite(String coordinates) {
       int a = coordinates.charAt(0);
       int b = (int)coordinates.charAt(1);
       if((a+b)%2 == 0){
        return false;
       }
       return true;
    }
}