class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int i =0;
        int j=numbers.length-1;
        int[] res = new int[2];
            while(i<numbers.length && j>0){
                int sum = numbers[i] + numbers[j];
                if(sum>target){
                     j--;    
                }
                else if(sum<target){
                    i++;
                }
                else if(sum == target){
                    res[0] = i+1;
                    res[1] = j+1;
                    return res;
                }    
            }
        return res;
    }
}
