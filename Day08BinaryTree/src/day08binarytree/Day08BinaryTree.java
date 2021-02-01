/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day08binarytree;

/**
 *
 * @author Artem
 */
public class Day08BinaryTree {

    static void printArray(String[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%s%s", i == 0 ? "" : ", ", data[i]);
        }
    }

    public static void main(String[] args) {
        BinaryTree<String, Integer> bt = new BinaryTree<String, Integer>();
        bt.put("ddd", 4);
        bt.put("eee", 8);
        bt.put("aaa", 5);
        bt.put("bbb", 3);
        bt.put("ccc", 1);
        bt.printAllKeyValPairs();
        
         for (var n : bt) // foreach
        {
            System.out.printf("- Key %s, Value: %d\n", n.key, n.value);
        }

        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(8, "aaa"); // put a few pairs of key values
        tree.put(1, "ccc");
        tree.put(3, "bbb");
        tree.put(2, "ddd");
        tree.put(6, "eee");
        tree.put(84, "fff");

        for (BinaryTree.Pair pair : tree) { // only works if Iterable is implemented
            System.out.printf("%d => %s\n", pair.key, pair.value);
        }
    }
}
