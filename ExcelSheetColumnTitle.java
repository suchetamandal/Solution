class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int quo =0;
        while(n > 26){
            quo++;
            n = n - 26;
        }
        if(quo>0){
            if(quo<=26){
                char pre = (char)((int)'A' + (quo-1));
                sb.append(Character.toString(pre));
            }
            else{
                sb.append(convertToTitle(quo));
            }
        }
        char letter = (char)((int)'A' + (n-1));
        return sb.toString()+ Character.toString(letter);
    }
}
