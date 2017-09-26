/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1==null && t2 == null){
            return null;
        }
        int val1 = (t1!=null? t1.val:0);
        int val2 = (t2!=null?t2.val:0);
        int val = val1+val2;
        
        TreeNode mergedNode = new TreeNode(val);
        
        mergedNode.left = mergeTrees((t1!=null?t1.left:null),(t2!=null?t2.left:null));
            
        mergedNode.right = mergeTrees((t1!=null?t1.right:null),(t2!=null?t2.right:null));
            
        return mergedNode;    
    }
}
