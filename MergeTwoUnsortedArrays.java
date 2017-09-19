 public void merge(int[] nums1, int m, int[] nums2, int n) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // Merge them 
        while(m>0 && n>0){
           if(nums1[m-1]>nums2[n-1]){
               nums1[m+n-1] = nums1[m-1];
               m--;
           } 
            else{
                nums1[m+n-1]= nums2[n-1];
                n--;
            }
        }
        
        //Rest of the element
        while(n>0){
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
        
    }
