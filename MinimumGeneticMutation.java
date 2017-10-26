class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        char[] wr = {'A','C','G','T'};
        int mutation = 0;
        Set<String> bankSet = new HashSet<String>();
        for(String b : bank){
            bankSet.add(b);
        }
        
        Set<String> visited = new HashSet<String>();
        visited.add(start);
        
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String word = q.poll();
                if(word.equals(end)){
                    return mutation;
                }
                char[] arr = word.toCharArray();
                for(int i =0; i< arr.length; i++){
                    char oldChar = arr[i];
                    for(char w : wr){
                        arr[i] = w;
                        String newWord = new String(arr);
                        if(!visited.contains(newWord) && bankSet.contains(newWord)){
                            visited.add(newWord);
                            q.add(newWord);
                        }
                    }
                    arr[i] = oldChar;
                }
            }
            mutation++;
        }
        return -1;
    }
}
