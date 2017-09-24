class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int len = prerequisites.length;
        //if there is no prerequisites, return a sequence of courses
        if(len == 0 || prerequisites == null){
         int[] res1 = new int[numCourses];
         for(int m=0; m<numCourses; m++){
            res1[m]=m;
        }
        return res1;
    }
        
        int[] preq = new int[numCourses];
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        for(int i=0;i<len;i++){
            preq[prerequisites[i][0]]++;
        }
        
        for(int i=0;i<numCourses;i++){
            if(preq[i]==0){
              queue.add(i); 
            }
        }
        
        int noPreReq = queue.size();
        int j =0;
        while(!queue.isEmpty()){
            int top = queue.remove();
            res[j++]=top;
            for(int i=0; i<len ; i++){
                if(prerequisites[i][1]==top){
                    preq[prerequisites[i][0]]--;
                    if(preq[prerequisites[i][0]]==0){
                        noPreReq++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        
       return (noPreReq == numCourses)? res: new int[0];
        
    }

}
