#include <iostream>
using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* l1Curr = l1;
        ListNode* l2Curr = l2;
        ListNode* result = new ListNode();
        ListNode* resultCurr = result;
        int reminder = 0;
        int l1Val, l2Val;

        while(l1Curr || l2Curr){
            l1Val = 0;
            l2Val = 0;

            if (l1Curr){
                l1Val = l1Curr->val;
                l1Curr = l1Curr->next;
            }
            if (l2Curr){
                l2Val = l2Curr->val;
                l2Curr = l2Curr->next;
            }

            int sum = l1Val + l2Val + reminder;

            resultCurr->val = sum % 10;
            reminder = (int) (sum / 10);


            if (l1Curr || l2Curr){
                resultCurr->next = new ListNode();
                resultCurr = resultCurr->next;
            }
        }

        if (reminder != 0){
            printf("here, reminder: %d\n", reminder);
            resultCurr->next = new ListNode(reminder);
        }

        return result;
    }
};

int main(int argc, char **argv){
    Solution s;

    ListNode* l1 = new ListNode(2);
    l1->next = new ListNode(4);
    l1->next->next = new ListNode(3);

    ListNode* l2 = new ListNode(5);
    l2->next = new ListNode(6);

    ListNode* result = s.addTwoNumbers(l1, l2);

    printf("RESULT: ");
    while (result){
        printf("%d", result->val);
        result = result->next;
    }
    printf("\n");
}