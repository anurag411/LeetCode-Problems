class Solution {
    Map<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) 
            return node;
        Queue <Node> queue = new LinkedList<>();
        Node newNode = new Node(node.val);
        newNode.neighbors = new ArrayList<>();
        map.put(node.val, newNode);
        queue.add(node);
        while(!queue.isEmpty()) {
            Node temp = queue.poll();
            Node res = map.get(temp.val);
            for(Node n : temp.neighbors) {
                Node root = null;
                if (map.containsKey(n.val)) {
                    root = map.get(n.val);
                } else {
                    root = new Node(n.val);
                    root.neighbors = new ArrayList<>();
                    map.put(n.val, root);
                    queue.add(n);
                } 
                res.neighbors.add(root);
            }
        }
      return newNode;  
    }
}
