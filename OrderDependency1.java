class OrderDependency1 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null){
            return true;
        }
        if(numCourses == 0 || prerequisites.length ==0 ){
            return true;
        }
        
        // counter for number of prerequisites
        int[] pCounter = new int[numCourses];
        for(int i=0; i<prerequisites.length; i++){
            pCounter[prerequisites[i][0]]++;
        }
        
        //store courses that have no prerequisites
        LinkedList<Integer> sub = new LinkedList<Integer>();
        for(int i =0; i< numCourses;i++){
            if(pCounter[i]==0){
                sub.add(i);
            }
        }
        int noPreReqCourse = sub.size();
        
        while(!sub.isEmpty()){
            int head = sub.remove();
            for(int i=0; i<prerequisites.length;i++){
                if(prerequisites[i][1]== head){
                    pCounter[prerequisites[i][0]]--;
                    if(pCounter[prerequisites[i][0]] ==0){
                       noPreReqCourse ++;
                       sub.add(prerequisites[i][0]); 
                    }
                }
            }
        }
       return numCourses ==  noPreReqCourse;
    }
}
