class Solution {
    // Solution using merge Sort
    
    public ListNode sortList(ListNode head) {
        if(head == null)
            return head;
        int len = 0;
        ListNode temp = head;
        while(temp != null) {
            len++;
            temp= temp.next;
        }
        return divideList(head, len);
    }
    
    private ListNode divideList(ListNode head ,int len) {
        if(len <= 1) {
            return head;
        }
        int mid = len/2;
        ListNode list1 = head;
        ListNode list2 = head;
        for(int i=1;i<mid;i++) {
            list2 = list2.next;
        }
        ListNode temp = list2.next;
        list2.next = null;
        return mergeList(divideList(list1 ,mid) , divideList(temp, len-mid));
    }
    
    private ListNode mergeList(ListNode list1, ListNode list2) {
        if(list1 == null) 
            return list2;
        if(list2 == null) 
            return list1;
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while (list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                res.next = list2;
                res = res.next;
                list2 = list2.next;
            } else {
                res.next = list1;
                res = res.next;
                list1 = list1.next;
            }
        }
        if(list1 == null) {
            res.next = list2;
        } else {
            res.next = list1;
        }
        return head.next;    
    }
}
