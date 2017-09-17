public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        Set myOrderedSet = new LinkedHashSet(set);
        for(int n : nums){
            myOrderedSet.add(n);
            }
        Iterator<Integer> it = myOrderedSet.iterator();
        int i =0;
        while(it.hasNext()){
            nums[i]=it.next();
             System.out.println(nums[i]);
            i++;
        }
         System.out.println(myOrderedSet.size());
        return myOrderedSet.size();
    }
    
 public int removeDuplicates(int[] nums) {
       int res = 0;
        for(int i =0;i<nums.length;i++){
            if(nums[Math.abs(nums[i])] >= 0){
                nums[Math.abs(nums[i])] = - nums[Math.abs(nums[i])];
            }
            else{
                res++;
            }
        }
        return res;
    }    
    
    
