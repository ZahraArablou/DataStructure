package quiz1rollingfifo;

class FIFOFullException extends Exception {
}

public class RollingPriorityFIFO {

    private class Item {
        // add constructor of your choice

        Item next;
        boolean priority = false;
        String value;
    }
    private Item tail;
    private Item head;
    int itemTotal;
    int itemCurrUsed = 0;

    public RollingPriorityFIFO(int no) {
        if (no < 5) {
            throw new IllegalArgumentException();
        }
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();
        Item item5 = new Item();

        item1.next = item2;
        item2.next = item3;
        item3.next = item4;
        item4.next = item5;
        item5.next = item1;
        head = item1;
        tail = item1;
        itemTotal = no;

    }

    public void enqueue(String value, boolean priority)throws FIFOFullException{
        if (itemCurrUsed == itemTotal) {
            throw new FIFOFullException();  
        }
        if (tail.value == null) {
            tail.value = value;
            tail.priority = priority;
            itemCurrUsed++;
            return;
        }
        tail = tail.next;
        tail.value = value;
        tail.priority = priority;
        itemCurrUsed++;

    }

    public String dequeue() {
        if (itemCurrUsed == 0) {
            return null;
        }

        if (head.priority == true) {//the first item has periority
            String str = head.value;
            head = head.next;
            itemCurrUsed--;
            return str;

        }
        Item prev = null;  //one of the middle items has periority
        Item current = head;
        for (int i = 0; i < itemCurrUsed; i++) {
            if (current.priority == true) {
                String str = current.value;
                prev.next = current.next;
                current.next = tail.next;
                tail.next = current;
                itemCurrUsed--;
                return str;
            }
            prev = current;
            current = current.next;
        }
        String str = head.value;//we dont have periority
        head = head.next;
        itemCurrUsed--;
        return str;

    }

    public int size() {
        return itemCurrUsed;
    } // current FIFO size

    public int sizeMax() {
        return itemTotal;
    } // maximum FIFO size

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Item current = head;
        result.append("[");
        for (int i = 0; i < itemCurrUsed; i++) {
            result.append(i == 0 ? "" : ",");
            if (current.priority == true) {
                result.append(current.value + "*");
            } else {
                result.append(current.value);
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }

    public String[] toArray() {
        String[] result = new String[itemCurrUsed];
        Item current = head;
        int j = 0;
        for (int i = 0; i < itemCurrUsed; i++) {
            result[i] = current.value;

            current = current.next;
        }
//          for (int i = 0; i < result.length; i++) {
//              System.out.println(result[i]);
//              
//          }
        return result;
    }

    public String[] toArrayOnlyPriority() {
        Item current = head;
        int j = 0;
        for (int i = 0; i < itemCurrUsed; i++) {
            if (current.priority == true) {
                j++;
            }
            current = current.next;
        }
        String[] result = new String[j];
        current = head;
        j = 0;
        for (int i = 0; i < itemCurrUsed; i++) {
            if (current.priority == true) {
                result[j] = current.value + "*";
                j++;
            }
            current = current.next;
        }
        return result;
    }
}
