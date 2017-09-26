class 3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result =0 ;
        int mindiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i< nums.length;i++){
               int low = i+1;
               int high = nums.length-1;
               while(low<high){
                   int sum = nums[i]+nums[low]+nums[high];
                   int diff = Math.abs(sum-target);
                   if(diff==0){
                       return sum;
                   }
                   if(diff<mindiff){
                       mindiff = diff;
                       result =sum;
                   }
                   if(sum<target){
                       low++;
                   }
                   else{
                       high--;
                   }
               }
        }
        return result;
    }
}
