
package quiz1rollingfifo;

public class Quiz1RollingFIFO {

    
    public static void main(String[] args) throws FIFOFullException {
       RollingPriorityFIFO fifo=new RollingPriorityFIFO(5);
       fifo.enqueue("Ali", false);
       fifo.enqueue("Mery",false);
       fifo.enqueue("Jack", false);
        System.out.println( fifo.toString());
        System.out.println(fifo.dequeue());
         System.out.println( fifo.toString());
//         System.out.println("*********");
//          fifo.enqueue("aaay",true);
//           fifo.enqueue("Mefffry",true);
//          System.out.println( fifo.toArray());
    }
    
}
