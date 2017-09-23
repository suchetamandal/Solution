class BinaryTreeAllPathSum {
    public List<List<Integer>>  pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        allPathSum(root,sum,path,res);
        return res;
    }
    
    public void allPathSum(TreeNode root, int sum,  List<Integer> path,  List<List<Integer>> res){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){ 
            if(root.val == sum){ 
                path.add(root.val);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);  
            }
            return;
        }
        path.add(root.val);
        allPathSum(root.left,sum-root.val,path,res);
        allPathSum(root.right, sum - root.val, path,res);
        path.remove(path.size()-1);
    }
}
