import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

    static class Pair { 
    Node first; 
    int second; 
    Pair(Node n,int a) { 
        first=n; 
        second=a; 
        } 
  }; 
	public static void topView(Node root) {
        if (root == null) { 
            return; 
        } 
        Node temp = null; 
        Queue<Pair > q =  new LinkedList<Pair>();
        Map<Integer, Integer> mp = new TreeMap<Integer, Integer>(); 
        q.add(new Pair( root, 0 )); 
        while (q.size()>0) { 
            temp = q.peek().first; 
            int d = q.peek().second; 
            q.remove(); 
            if (mp.get(d) == null) {
                mp.put(d, temp.data); 
            } 
            if (temp.left!=null) { 
                q.add(new Pair( temp.left, d - 1 )); 
            }
            if (temp.right!=null){ 
                q.add(new Pair( temp.right, d + 1 )); 
            } 
        } 
        for(Integer data:mp.values()){ 
            System.out.print( data + " ");
        } 
      
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
