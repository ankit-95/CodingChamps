package com.codingchamps.Tree;

import java.util.*;

public class VerticalTreeTraversal {

    Node root;
    Map<Integer, List<Integer>> map;
    public static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    VerticalTreeTraversal(){
        map = new TreeMap<>();
    }
    public static void main(String[] args) {

         /* Construct the following tree
                1
              /   \
             /     \
            2       3
                  /   \
                 /     \
                5       6
              /   \
             /     \
            7       8
                  /   \
                 /     \
                9      10
        */
        VerticalTreeTraversal tree = new VerticalTreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.right.left.left = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.left.right.left = new Node(9);
        tree.root.right.left.right.right = new Node(10);

        tree.verticalTraversalApp1(tree.root,0);
     //   tree.verticalTraversalApp2(tree.root);
        tree.map.values().stream().forEach(System.out::println);
    }

    private void verticalTraversalApp1(Node root,int level) {
        if(root == null)
            return;
        insertintoMap(root,level);
        verticalTraversalApp1(root.left, level - 1);
        verticalTraversalApp1(root.right, level + 1);
    }

    private void insertintoMap(Node root, int level) {
        map.putIfAbsent(level,new ArrayList<>());
        map.get(level).add(root.data);
    }

    public static class Pair<U,V>{
        public final U first;
        public final V second;

        // Constructs a new Pair with specified values
        private Pair(U first, V second)
        {
            this.first = first;
            this.second = second;
        }

        // Factory method for creating a Typed Pair immutable instance
        public static <U, V> Pair <U, V> of(U a, V b)
        {
            // calls private constructor
            return new Pair<>(a, b);
        }
    }

    public void verticalTraversalApp2(Node root)
    {
        // base case
        if (root == null) {
            return;
        }

        Queue<Pair<Node, Integer>> q = new ArrayDeque<>();
        q.add(Pair.of(root, 0));

        while (!q.isEmpty())
        {
            // dequeue front node
            Node node = q.peek().first;
            int dist = q.peek().second;
            q.poll();

            insertIntoMultiMap(map, dist, node.data);

            if (node.left != null) {
                q.add(Pair.of(node.left, dist - 1));
            }

            if (node.right != null) {
                q.add(Pair.of(node.right, dist + 1));
            }
        }
    }

    public static void insertIntoMultiMap(Map<Integer, List<Integer>> map,
                                          Integer key, Integer value) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(value);
    }
}
