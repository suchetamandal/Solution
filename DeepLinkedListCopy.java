/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class DeepLinkedListCopy {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null){
            return null;
        }
        Map<RandomListNode,RandomListNode> nodeMap = new HashMap<RandomListNode,RandomListNode>();
        
        RandomListNode headNode = head;
        while(headNode!=null){
            nodeMap.put(headNode,new RandomListNode(headNode.label));
            headNode = headNode.next;
        }
        
        headNode = head;
        while(headNode!=null){
            nodeMap.get(headNode).next = nodeMap.get(headNode.next);
            nodeMap.get(headNode).random = nodeMap.get(headNode.random);
            headNode = headNode.next;
        }
        return nodeMap.get(head); 
    }
}
