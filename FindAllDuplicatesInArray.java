class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) {
       List<Integer> res = new ArrayList<Integer>();
        for(int i =0; i<nums.length;i++){
            int val = Math.abs(nums[i])-1;
           if(val>=0 && nums[val]>0){
               nums[val]= -nums[val];
           } 
            else{
                 System.out.println(val);
                 res.add(Math.abs(val)+1);
            }
        } 
        return res;
    }
}
