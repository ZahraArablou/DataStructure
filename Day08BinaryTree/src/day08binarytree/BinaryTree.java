/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day08binarytree;

import java.util.Iterator;

/**
 *
 * @author Artem
 * @param <K>
 * @param <V>
 */
public class BinaryTree<K extends Comparable, V> implements Iterable<BinaryTree.Pair> {

    protected class Pair<K, V> {

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Pair() {
        }

        K key;
        V value;
    }

    protected class Node<K, V> {

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        K key;
        V value; // could also be key,value pair
        Node<K, V> left;
        Node<K, V> right;
    }

    Node<K, V> root;
    private int nodesCount;

    // throws exception if put attempts to insert value that already exists (a duplicate)
    void put(K key, V value) throws IllegalArgumentException {
        Node<K, V> newNode = new Node<K, V>(key, value, null, null);
        if (root == null) {
            root = newNode;
            nodesCount++;
            return;
        }
        Node current = root;
        while (true) {
            if (current.key == key) {
                throw new IllegalArgumentException("Duplicatea are not allowed");
            }
            if (key.compareTo(current.key) < 0) {
                if (current.left == null) {
                    current.left = newNode;
                    nodesCount++;
                    return;
                } else {
                    current = current.left;
                    continue;
                }
            }
            if (key.compareTo(current.key) > 0) {
                if (current.right == null) {
                    current.right = newNode;
                    nodesCount++;
                    return;
                } else {
                    current = current.right;
                    continue;
                }
            }
        }

    }
    // private helper recursive method to implement the above method

    private void collectKeysValues(Node node) {
        if (node == null) {
            return;
        }
        collectKeysValues(node.right);
        arrayOfPairs[resultIndex++] = new BinaryTree.Pair(node.key, node.value);
        collectKeysValues(node.left);

    }
    // data structures used to make collecting values in order easier
    BinaryTree.Pair[] arrayOfPairs;
    private int resultIndex;

    void printAllKeyValPairs() {
        resultIndex=0;
        arrayOfPairs = new BinaryTree.Pair[nodesCount];
        collectKeysValues(root);
        for (int i = 0; i < resultIndex; i++) {
            System.out.printf("Key: %s, Value: %d\n", arrayOfPairs[i].key, arrayOfPairs[i].value);
        }
    }

    public Iterator<BinaryTree.Pair> iterator() {
        return new SimpleBinaryTreeIterator();
    }

    private class SimpleBinaryTreeIterator implements Iterator<BinaryTree.Pair> {

        int i;

        public SimpleBinaryTreeIterator() {
            i = 0;
            resultIndex=0;
            arrayOfPairs = new BinaryTree.Pair[nodesCount];
            collectKeysValues(root);
        }

        public boolean hasNext() {
            return arrayOfPairs.length > i;
        }

        public BinaryTree.Pair next() {
            BinaryTree.Pair result = new BinaryTree.Pair();
            result = arrayOfPairs[i++];
            return result;
        }
    }
}
