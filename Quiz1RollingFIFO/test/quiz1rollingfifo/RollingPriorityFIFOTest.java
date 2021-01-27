package quiz1rollingfifo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RollingPriorityFIFOTest {

    @Test
    public void equTest() throws FIFOFullException {
        RollingPriorityFIFO fifo = new RollingPriorityFIFO(5);
        fifo.enqueue("AAA", true);
        assertEquals("[AAA*]", fifo.toString());
        fifo.enqueue("BBB", false);
        assertEquals("[AAA*,BBB]", fifo.toString());
    }

    @Test
    public void deqTest() throws FIFOFullException {
        RollingPriorityFIFO fifo = new RollingPriorityFIFO(5);
        fifo.enqueue("AAA", true);
        assertEquals("[AAA*]", fifo.toString());
        fifo.enqueue("BBB", false);
        assertEquals("[AAA*,BBB]", fifo.toString());
        assertEquals("AAA", fifo.dequeue());//the first item has periority
        assertEquals("[BBB]", fifo.toString());
        fifo.enqueue("LLL", false);
        assertEquals("BBB", fifo.dequeue());//there is no periority in the list
         fifo.enqueue("JJJ",true);
        fifo.enqueue("NNN", false);
         assertEquals("JJJ", fifo.dequeue());//middle item has periority

    }

    @Test
    public void toStringTest() throws FIFOFullException {
        RollingPriorityFIFO fifo = new RollingPriorityFIFO(5);
        fifo.enqueue("AAA", true);
        fifo.enqueue("BBB", false);
        fifo.enqueue("CCC", true);
        fifo.enqueue("DDD", true);
        assertEquals("[AAA*,BBB,CCC*,DDD*]", fifo.toString());
    }

    @Test
    public void toArrayOnlyPeriorityTest() throws FIFOFullException {
        RollingPriorityFIFO fifo = new RollingPriorityFIFO(5);
        fifo.enqueue("AAA", true);
        assertEquals("[AAA*]", fifo.toString());
        fifo.enqueue("BBB", false);
        assertEquals("[AAA*,BBB]", fifo.toString());
        assertEquals("AAA", fifo.dequeue());
        assertEquals("[BBB]", fifo.toString());
        fifo.enqueue("CCC", true);
        fifo.enqueue("DDD", true);
        assertArrayEquals(new String[]{"CCC*", "DDD*"}, fifo.toArrayOnlyPriority());

    }

    @Test
    public void toArray() throws FIFOFullException {
        RollingPriorityFIFO fifo = new RollingPriorityFIFO(5);
        fifo.enqueue("AAA", true);
        fifo.enqueue("BBB", false);
        assertEquals("[AAA*,BBB]", fifo.toString());
        fifo.enqueue("CCC", true);
        fifo.enqueue("DDD", true);
        assertArrayEquals(new String[]{"AAA", "BBB", "CCC", "DDD"}, fifo.toArray());

    }
}
