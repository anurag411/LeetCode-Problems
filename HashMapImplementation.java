class MyHashMap {
    class ListNode{
        int key;
        int val;
        ListNode next;
        public ListNode(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    ListNode[] lst;
    /** Initialize your data structure here. */
    public MyHashMap() {
        lst = new ListNode[10000];
    }
    
    public int getHash(int key,int len){
        return Integer.hashCode(key)%len;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = getHash(key,lst.length);
        if(lst[idx]==null) lst[idx] = new ListNode(-1,-1);
        ListNode pre = getPre(key,idx);
        if(pre.next==null) pre.next = new ListNode(key,value);
        else pre.next.val = value;
    }
    public ListNode getPre(int key,int idx){
        ListNode cur = lst[idx];
        ListNode pre = null;
        while(cur!=null&&cur.key!=key){
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = getHash(key,lst.length);
        if(lst[idx]==null) return -1;
        ListNode pre = getPre(key,idx);
        if(pre.next==null) return -1;
        return pre.next.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = getHash(key,lst.length);
        if(lst[idx]==null) return ;
        ListNode pre = getPre(key,idx);
        if(pre.next==null) return ;
        pre.next = pre.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
