package day03linkedlistarray;

public class Day03LinkedListArray {

 
    public static void main(String[] args) {
        try {
            LinkedListArrayOfStrings linkedList1 = new LinkedListArrayOfStrings();
            linkedList1.add("aa");
            linkedList1.add("bb");
            linkedList1.add("dd");
              linkedList1.add("ac");
            System.out.println(linkedList1.toString());
//            System.out.println(linkedList1.get(2));
//            linkedList1.insertValueAtIndex(2, "cc");
//            System.out.println(linkedList1.toString());
//            linkedList1.deleteByIndex(3);
//            System.out.println(linkedList1.toString());
//            System.out.println(linkedList1.deleteByValue("ll"));//false expected
//            String[] array=new String[linkedList1.toArray().length];
//            linkedList1.add("test");
//              System.out.println(linkedList1.toString());
               linkedList1.deleteByIndex(2);
            System.out.println(linkedList1.toString());
            } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex);
        }

    }

}
