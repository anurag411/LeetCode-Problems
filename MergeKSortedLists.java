class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
			return null;
        
        // creates priority queue of TempNode node  
		PriorityQueue<TempNode> queue = new PriorityQueue<TempNode>();
        int n = lists.length;

		// Add first nodes in the list of lists
		for (int i = 0; i < n; i++) {
			if(lists[i] != null) 
			queue.offer(new TempNode(lists[i]));
		}

		ListNode head = new ListNode();
		ListNode root = head;

		// iterate list till queue is empty
		while (!queue.isEmpty()) {
			TempNode temp = queue.poll();
			root.next = temp.node;
			root = root.next;

            // if list not empty then add next element in queue
			if (temp.node.next != null)
                queue.offer(new TempNode(temp.node.next));		
		}
		return head.next;
	}

}

class TempNode implements Comparable<TempNode> {

	ListNode node;

	public TempNode(ListNode node) {
		this.node = node;
	}

	@Override
	public int compareTo(TempNode o) {
		return this.node.val - o.node.val;
	}
}
