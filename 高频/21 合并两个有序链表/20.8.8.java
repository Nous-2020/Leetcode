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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(0);
        ListNode ans = header;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                ans.next = l1;
                ans = ans.next;
                l1 = l1.next;
            }else{
                ans.next = l2;
                ans = ans.next;
                l2 = l2.next;
            }
        }
        ans.next = l1==null?l2:l1;
        return header.next;
    }
}
