class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character, Integer> map1 =  new HashMap<>();
       
        for(int i = 0; i < s.length(); i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            if(map1.get(ch) != null){
                if(map1.get(ch) == 1){
                    map1.remove(ch);
                } else {
                    map1.put(ch,map1.get(ch)-1);
                }
            } else {
                return false;
            }
        }
        return map1.isEmpty();
    }
}