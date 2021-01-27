/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03linkedlistarray;

/**
 *
 * @author heshmat
 */
public class LinkedListArrayOfStrings {

    private class Container {

        Container next;
        String value;
    }
    private Container start = null;
    private Container end = null;
    private int size = 0;

    public void add(String value) {
        Container con = new Container();
        con.value = value;
        if (size == 0) {

            start = con;
            end = con;
            size = 1;
        } else {
            end.next = con;
            end = con;
            size++;
        }
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == size - 1) {// immediate access to the last item in the list
            return end.value;
        }
        Container current;
        current = start;
        int count = 0;
        while (current != null) {
            if (index == count) {
                return current.value;
            }
            current = current.next;
            count++;
        }
        //another approch instead of while loop
//         for(Container current=start;current!=null;current=current.next)
//         {
//             if(index==count)
//             {
//                 return current.value;
//             }
//         }

        //return str;//never happen-fatal exception
        throw new RuntimeException("internal error:invalid control flow");
    }

    public void insertValueAtIndex(int index, String value) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(size==0 || index==size){
            //add/insert at the start of an empty list
            //OR add at the end
            add(value);
            return;
        }
        if(index==0){//insert at the begining of a non-empty list
            Container con=new Container();
            con.value=value;
            con.next=start;
            start=con;
            size++;
            return;
        }
        //comon case
        //find the container just before the position at which we want to insert
        Container before=start;
        for (int i = 0; i < index-1; i++) {
            before=before.next;
        }
        Container con=new Container();
        con.value=value;
        con.next=before.next;
        before.next=con;
        size++;
        
        
        //different approach of insert
//        Container con = new Container();
//        con.value = value;
//        if (index == 0) {// insert at the begining of the lise
//            con.next = start;
//            start = con;
//            size++;
//            return;
//        }
//        if (index == size) {//insert as the last item
//            end.next = con;
//            con.next = null;
//            end = con;
//            size++;
//            return;
//        }
//        Container current;
//        Container before;
//        current = start;
//        before = start;
//        int count = 0;
//        do {
//            if (index == count) {
//                before.next = con;
//                con.next = current;
//                // current=con;
//                size++;
//
//            }
//            before = current;
//            current = current.next;
//
//            count++;
//
//        } while (current != null);

    }

    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0) {// delete the first item
            start = start.next; //go "OVER" the first item
            size--;
            return;
        }

        //find the container just before the one we want to delete
        Container before = start;
         for (int i = 0; i < index - 1; i++) {
            before = before.next;
        }
        
        if (index == size - 1) {// or if(before.next.next==null)
            end = before;
        }
        before.next = before.next.next;
        size--;
//        when removing the last item adjust end reference
         if (index == size - 1) {// or if(before.next.next==null)
            end = before;
        }
       // different approach for delete an item     
//       int count=0;
//       Container current=start;
//       Container before=start;
//        do {
//            if (index == count) {
//                before.next = current.next;
//                if (index == size - 1) {
//                    end = before;
//                }
//                size--;
//            }
//            before = current;
//            current = current.next;
//            count++;
//        } while (current != null);
    }

    public boolean deleteByValue(String value) {
        Container current;
        current = start;
        do {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        } while (current != null);
        return false;
    } // delete first value found

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        Container current = start;
        StringBuilder str = new StringBuilder();
        str.append("[");
        while (current != null) {
            str.append(current.value);
            current = current.next;
            str.append(current == null ? "" : ",");
        }
        str.append("]");
        return str.toString();

    } // comma-separated values list similar to: [5,8,11]

    public String[] toArray() {
        String[] result = new String[size];
        Container current = start;
        int position = 0;
        while (current != null) {
            result[position] = current.value;
            position++;
            current = current.next;
        }
        return result;
    }

    public String[] toArray2() {
        String[] result = new String[size];
        Container current = start;
        for (int i = 0; i < size; i++) {
            result[i] = current.value;
            current = current.next;
        }
        return result;
    }
}
