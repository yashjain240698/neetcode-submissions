/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Map<Node,Node> oldToNew = new HashMap<>();
        Node temp = head;
        Node dummyTemp = dummy;
        while(temp != null){
            Node newNode = new Node(temp.val);
            oldToNew.put(temp, newNode);
            dummyTemp.next = newNode;
            dummyTemp = dummyTemp.next;
            temp = temp.next;
        }

        dummyTemp = dummy;
        temp = head;
        while(temp != null){
            if(temp.random != null)
                dummyTemp.next.random = oldToNew.get(temp.random);
            dummyTemp = dummyTemp.next;
            temp = temp.next;
        }

        return dummy.next;
    }   
}
