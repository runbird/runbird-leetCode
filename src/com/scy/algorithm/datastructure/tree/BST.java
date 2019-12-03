package com.scy.algorithm.datastructure.tree;

/**
 * 类名： BST <br>
 * 描述：TODO <br>
 * 创建日期： 2019/11/14 <br>
 *
 * @author suocaiyuan
 * @version V1.0
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private int size;
    private Node root;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //增加节点
//    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(e, root);
//        }
//    }

    //以Node为根的BST插入E
//    private void add(E e, Node node) {
//        if (e.equals(node.e)) return;
//        if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        }
//
//        //
//        if (e.compareTo(node.e) > 0) {
//            //TODO
//            add(e, node.right);
//        } else {
//            add(e, node.left);
//        }
//    }

    public void add(E e) {
        add(e, root);
    }

    //以Node为根节点插入E，并且返回根节点
    private Node add(E e, Node node) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add(e, node.right);
        } else {
            node.left = add(e, node.left);
        }
        return node;
    }
}


