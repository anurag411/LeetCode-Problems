// https://leetcode.com/problems/palindrome-linked-list/
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode fast = head.next;
        ListNode slow = head;
        
        // find out mid element of list
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        
        // Now reverse the fast list
        ListNode reverse = null;
        ListNode prev = null;
        while (fast != null) {
            prev = fast;
            fast = fast.next;
            prev.next = reverse;
            reverse = prev;     
        }
        
        //Now compare reverse list and head list
        while(head != null && reverse != null) {
            if(head.val != reverse.val){
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }
}
