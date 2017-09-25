public class CircularLinkedlistInsert {
    private Node first;
    public void insertNodeInCircularLL(int element) {
        Node node = new Node(element, null);
        if (first == null) {
            first = node;
            first.next = first;
        } else {
            Node current = first;
            do {
                if (((current.element <= element)  && (current.next.element >= element)) || current.next == first)  {
                    node.next = current.next;
                    current.next = node;
                    if (element < first.element) {
                        first = node;
                    }
                    return;
                }
                current = current.next;
            } while (current != first);
        }
    }
}
