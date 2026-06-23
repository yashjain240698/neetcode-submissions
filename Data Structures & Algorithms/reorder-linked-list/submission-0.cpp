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
    ListNode* reverseList(ListNode* t){
        ListNode* prev = nullptr;
        ListNode* curr = t;
        ListNode* temp = nullptr;

        while(curr){
            temp = curr->next;
            curr->next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
    void reorderList(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head->next;

        while(fast && fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }

        ListNode* temp = reverseList(slow->next);
        slow->next = nullptr;
        ListNode* start = head;
        ListNode* dummy = new ListNode();
        ListNode* t = dummy;
        while(start){
            t->next = start;
            start = start->next;
            t = t->next;
            t->next = temp;
            if(temp){
                temp = temp->next;
                t = t->next;
                t->next = nullptr;
            }
        }
    }
};
