/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    private ListNode reverse(ListNode root, int k){
        ListNode temp = root;
        int cnt = 0;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }

        if(cnt < k){
            return root;
        }
        cnt = k;
        ListNode prev = null;
        ListNode curr = root;
        while(cnt > 0){
            cnt--;
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        root.next = reverse(curr, k);
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverse(head, k);
    }
}
