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
    
    public RandomList copyRandomListII(RandomList head) {
		if (head == null) {
			return null;
		}
		RandomList tmp = head;
		while (tmp != null) {
			RandomList copyNode = new RandomList(tmp.label);
			copyNode.next = tmp.next;
			tmp.next = copyNode;
			tmp = tmp.next.next;
		}

		tmp = head;
		while (tmp != null) {
			RandomList oldRandom = tmp.random;
			RandomList newNode = tmp.next;
			if (oldRandom != null) {
				newNode.random = oldRandom.next;
			}
			tmp = tmp.next.next;
		}
		tmp = head;
		RandomList firstCopyNode = tmp.next;
		while (tmp != null) {
			RandomList nextNode = tmp.next;
			if (tmp.next != null && tmp.next.next != null) {
				tmp.next = tmp.next.next;
			} else {
				tmp.next = null;
			}
			tmp = nextNode;
		}
		return firstCopyNode;
	}
}
