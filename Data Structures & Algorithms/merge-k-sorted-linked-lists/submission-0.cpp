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
    ListNode* mergeList(ListNode* l1, ListNode* l2){
        ListNode* dummy = new ListNode();
        ListNode* temp = dummy;
        ListNode* t1 = l1;
        ListNode* t2 = l2;
        while(t1 && t2){
            if(t1->val < t2->val){
                temp->next = t1;
                t1 = t1->next;
            } else if(t1->val > t2->val){
                temp->next = t2;
                t2 = t2->next;
            } else {
                temp->next = t1;
                t1 = t1->next;
                temp = temp->next;
                temp->next = t2;
                t2 = t2->next;
            }
            temp = temp->next;
        }
        if(t1)
            temp->next = t1;

        if(t2)
            temp->next = t2;

        return dummy->next;
    }
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int l = lists.size();
        ListNode* dummy = new ListNode();

        for(int i = 0 ; i < l ; i++){
            dummy->next = mergeList(dummy->next, lists[i]);
        }

        return dummy->next;
    }
};
