class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        return makeBST(head,null);
    }
    
    public TreeNode makeBST(ListNode head, ListNode tail){
        ListNode start = head;
        ListNode delay = head;
        
        if(head == tail){
            return null;
        }
        while(start!=tail && start.next!=tail){
            start = start.next.next;
            delay = delay.next;
        }
        TreeNode newNode = new TreeNode(delay.val);
        newNode.right = makeBST(delay.next,tail);
        newNode.left = makeBST(head,delay);
        return newNode;
    }
}
