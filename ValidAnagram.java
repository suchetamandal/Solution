class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for(int i =0 ; i<s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))){
                int idx = s.charAt(i) - 'a';
                count[idx]++;
            }
        }
      
        for(int i =0 ; i<t.length(); i++){
            if(Character.isAlphabetic(t.charAt(i))){
                int idx = t.charAt(i) - 'a';
                count[idx]--;
            }
        }
        
        for(int i =0 ; i<26; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
