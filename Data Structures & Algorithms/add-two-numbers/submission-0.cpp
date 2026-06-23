/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode;
        ListNode* temp = dummy;
        ListNode* t1 = l1;
        ListNode* t2 = l2;
        int c = 0;
        while(t1 && t2){
            int sum = t1->val + t2->val + c;
            c = sum > 9 ? 1 : 0;
            temp->next = new ListNode(sum%10);
            temp = temp->next;
            t1 = t1->next;
            t2 = t2->next;
        }

        while(t1){
            int sum = t1->val + c;
            c = sum > 9 ? 1 : 0;
            temp->next = new ListNode(sum%10);
            temp = temp->next;
            t1 = t1->next;
        }

        while(t2){
            int sum = t2->val + c;
            c = sum > 9 ? 1 : 0;
            temp->next = new ListNode(sum%10);
            temp = temp->next;
            t2 = t2->next;
        }

        if(c){
            temp->next = new ListNode(1);
        }
        return dummy->next;
    }
};
