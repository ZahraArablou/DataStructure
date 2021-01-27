package day03customhashmap;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

class KeyNotFoundException extends Exception {
}

public class CustomHashMapStringString {

    private class Container {

        Container next;
        String key;
        String value;
    }

    // size must be a prime number always
    private Container[] hashTable = new Container[5];

    private int totalItems = 0;

    private int computeHashValue(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash <<= 1;  // same as: hash *= 2
            char c = key.charAt(i);
            hash += c;
        }
        return hash;
    }

    int nextPrime(int number) {
        int i = 0;
        while (true) {
            number++;
            if (isPrimeNumber(number)) {
                return number;
            }
        }
    }

    public static boolean isPrimeNumber(int number) {
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    void growhashTable() {
        
        int newSize = nextPrime(hashTable.length*2);
        totalItems=0;
        Container[] tempHashTable = new Container[newSize];
         for (int i = 0; i < hashTable.length; i++) {

             tempHashTable[i]=hashTable[i];
    }
         hashTable=new Container[newSize];
         for(int i=0; i< newSize;i++){
             if(hashTable[i]!=null){
                 Container current=tempHashTable[i];
                 while(current!=null){
                 putValue(current.key,current.value);
                 current=current.next;
             }
             }
             
         }
    }
    String getValue(String key) throws KeyNotFoundException {
        int hash = computeHashValue(key);
        int index = hash % hashTable.length;
        for (Container current = hashTable[index]; current != null; current = current.next) {
            if (current.key.equals(key)) {
                return current.value;
            }
        }
        throw new KeyNotFoundException();
    }
   
    void putValue(String key, String value) {
        if (totalItems > 2 * hashTable.length) {
            growhashTable();
        }
        int index = computeHashValue(key) % hashTable.length;
        Container current = hashTable[index];
        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value;//Update an existing entry
                return;
            }
            current = current.next;//go to the next container
        }
        //we only reach this code if the key was not found
        Container newCon = new Container();
        newCon.key = key;
        newCon.value = value;
        //insert at the beginning of the hash table entry
        newCon.next = hashTable[index];
        hashTable[index] = newCon;
        totalItems++;
//        
//        if (hashTable[index] == null) {
//            hashTable[index] = newCon;
//            totalItems++;
//            return;
//        }
//       // Container current = hashTable[index];
//        if (current.next == null) {
//            if (current.key.equals(key)) {
//                current.value = value;
//                return;
//            }
//
//            current.next = newCon;
//            totalItems++;
//            return;
//
//        }
//        while (current.next != null) {
//            if (current.key.equals(key)) {
//                current.value = value;
//                return;
//            }
//            current = current.next;
//        }
//        current.next = newCon;
//        totalItems++;
    }

    // LATER: expand hashTable by about *2 when totalItems > 3*hashTable.length
    boolean hasKey(String key) {

        Container current;
        for (int i = 0; i < hashTable.length; i++) {
            current = hashTable[i];
            if (hashTable[i] != null) {
                while (current != null) {
                    if (current.key == key) {
                        return true;
                    }
                    current = current.next;
                }
            }

        }

        return false;
    }

    void deleteByKey(String key) throws KeyNotFoundException {
        int index = computeHashValue(key) % hashTable.length;
        //
        Container previous = null;
        Container current = hashTable[index];
        while (current != null) {
            if (current.key.equals(key)) {
                break;
            }
            previous = current;
        }
        if (current == null) {
            throw new KeyNotFoundException();
        }
        if (previous == null) {//removing the first item in that list
            hashTable[index] = current.next;

        } else {//removing one of the later items
            previous.next = current.next;
        }
        totalItems--;
//        
//        Container current;
//        for (int i = 0; i < hashTable.length; i++) {
//            current = hashTable[i];
//            if (hashTable[i] != null) {
//                while (current != null) {
//                    if(current.key.equals(key)){
//                        hashTable[i]=current.next;
//                        return true;
//                    }
//                      if((current.next.key).equals(key)) {
//                        current.next=current.next.next;
//                        return true;
//                    }
//                    current = current.next;
//                }
//            }
//
//        }
//
//        return false;
//    
    }

    public String[] getAllKeys() {
        String[] result = new String[totalItems];
        int nextResultIndex = 0;
        for (int i = 0; i < hashTable.length; i++) {
            for (Container current = hashTable[i]; current != null; current = current.next) {
                result[nextResultIndex] = current.key;
                nextResultIndex++;
            }
        }
        return result;
    }

    int getSize() {
        return totalItems;
    }

    public void printDebug() {

        for (int i = 0; i < hashTable.length; i++) {
            System.out.printf("Entry %d:\n", i);
            for (Container current = hashTable[i]; current != null; current = current.next) {
                System.err.printf("-key: %s,Value: %s\n", current.key, current.value);
            }

        }
    } // print hashTable content, see example below

    @Override
        public String toString() {
        String[] keysArray = getAllKeys();
        Arrays.sort(keysArray);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < keysArray.length; i++) {
            try {
                String key = keysArray[i];
                String val = getValue(key);
                sb.append(i == 0 ? "" : ",");
                sb.append(key).append("->").append(val);
            } catch (KeyNotFoundException ex) {
              
            }
        }
        sb.append("]");
        return sb.toString();
//        StringBuilder result = new StringBuilder();
//        Container current;
//        for (int i = 0; i < hashTable.length; i++) {
//            System.out.println("entry" + i);
//            current = hashTable[i];
//            if (hashTable[i] != null) {
//                while (current != null) {
//
//                    System.out.println(current.key + "   " + current.value);
//                    current = current.next;
//                }
//            }
//        }
//        System.out.println(totalItems);
//        return "";
    } // comma-separated values->key pair list
    // to be able to use this as validation in Unit tests keys must be sorted
    // e.g. [ Key1 => Val1, Key2 => Val2, ... ]

}
