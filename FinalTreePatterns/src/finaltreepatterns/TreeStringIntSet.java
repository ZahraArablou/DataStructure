package finaltreepatterns;

import java.security.spec.KeySpec;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class DuplicateValueException extends Exception {
}

public class TreeStringIntSet implements Iterable<TreeStringIntSet.Pair> {
     protected class Pair<String,Integer> {

        public Pair(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Pair() {
        }

        String key;
       Integer value;
    }

   public class PatternTreeIterator implements Iterator<TreeStringIntSet.Pair>{
       List<String> list=new ArrayList<>();
        public PatternTreeIterator() {
            list=getAllKeys();
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Pair next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

      
       
   }
  //  @Override
    public Iterator<TreeStringIntSet.Pair> iterator() {
         return new PatternTreeIterator();
    }

    class Node {

        Node left, right;
        String key; // keys are unique
        // HashSet is like ArrayList except it does not hold duplicates
        HashSet<Integer> valuesSet = new HashSet<>(); // unique only
    }
    private Node root;
    private int nodesCount;
    private List<String> keys;

    // throws DuplicateValueException if this key already contains such value
    void add(String key, int value) throws DuplicateValueException {
        //Tree is empty
        if (root == null) {
            root = new Node();
            root.key = key;
            root.valuesSet.add(value);
            nodesCount++;
            return;
        }

        //find a parent for new node
        var current = root;
        while (true) {
            if (current.key.equals(key)) {
                for (int v : current.valuesSet) {
                    if (v == value) {
                        throw new DuplicateValueException();
                    } else {
                        current.valuesSet.add(value);
                        return;
                    }
                }

            }
            if (key.compareTo(current.key) < 0) { //go left
                if (current.left == null) {
                    current.left = new Node();
                    current.left.key = key;
                    current.left.valuesSet.add(value);
                    return;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = new Node();
                    current.right.key = key;
                    current.right.valuesSet.add(value);
                    nodesCount++;
                    return;
                } else {
                    current = current.right;

                }
            }
        }
    }

    boolean containsKey(String key) {
        var current = root;
        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            } else if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    List<Integer> getValuesByKey(String key) {
        List<Integer> values = new ArrayList<Integer>();
        var current = root;
        while (current != null) {
            if (key.compareTo(current.key) < 0) {
                current = current.left;
            } else if (key.compareTo(current.key) > 0) {
                current = current.right;
            } else {
                for (int v : current.valuesSet) {
                    values.add(v);
                }
                return values;
            }
        }
        return values;
    }

    public List<String> getKeysContainingValue(int value) {
        keys = new ArrayList<String>();
        getKey(root, value);
        return keys;
    }
    //  private helper recursive method to implement the above method

    private void getKey(Node node, int value) {

        if (node == null) {
            return;
        }
        getKey(node.left, value);
            getKey(node.right, value);
        for (int v : node.valuesSet) {
            if (v == value) {
                keys.add(node.key);
            }
          

        }

    }

    List<String> getAllKeys() {
        keys = new ArrayList<String>();
        KeysInOrder(root);
        return keys;
    }

    // private helper recursive method to implement the above method
    private void KeysInOrder(Node node) {
        if (node == null) {
            return;
        }

        KeysInOrder(node.right);
        keys.add(node.key);
        KeysInOrder(node.left);

    }
    // data structures used to make collecting values in order easier

    @Override
    public String toString() {
        List<String> allKeys = new ArrayList<String>();
        allKeys = getAllKeys();
        StringBuilder str = new StringBuilder();
        for (int i=0;i<allKeys.size();i++) {
            str.append(i==0?"":",");
            str.append(allKeys.get(i));
        }
        return str.toString();
    }
     public String getKeysByValuetoString(int value) {
        List<String> allKeys = new ArrayList<String>();
        allKeys = getKeysContainingValue(value);
        StringBuilder str = new StringBuilder();
        for (int i=0;i<allKeys.size();i++) {
            str.append(i==0?"":",");
            str.append(allKeys.get(i));
        }
        return str.toString();
    }

}
