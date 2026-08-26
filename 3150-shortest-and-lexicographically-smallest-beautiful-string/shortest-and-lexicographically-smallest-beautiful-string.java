class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int count = 0;
        int l = 0; 
        for(int r = 0 ; r < s.length(); r++){
            if (s.charAt(r) == '1') {
                count++;
            }
            
            while(count > k){
                if(s.charAt(l) == '1'){
                    count--;
                }
                l++;
            }

            while(count == k){
                while(s.charAt(l) == '0'){
                l++;
                }

                String curr = s.substring(l,r+1);

                if(curr.length() < ans.length() || ans.equals("") || (curr.length() == ans.length() && curr.compareTo(ans) < 0)){
                    ans = curr;
                }
                if (s.charAt(l) == '1') {
        count--;
    }

    l++;
            }
            
        }
        return ans;
    }
}