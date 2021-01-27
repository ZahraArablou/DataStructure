/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03linkedlistarray;


import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.Timeout;


public class LinkedListArrayOfStringsTest {
    
  //maximum time given for any single to execute
    @Rule
    public Timeout globalTimeout=new Timeout(10*1000) ;//10s max fir abt single test

    @Test
    public void testAdd() {//5 seconds timeout for this particular test
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add("sss");
        assertArrayEquals(new String[]{"sss"},instance.toArray());
}
    @Test(timeout = 5000)
    public void testGet(){
        LinkedListArrayOfStrings instance=new LinkedListArrayOfStrings();
       // instance.get(0);
       instance.add("sss");
       instance.add("Ali");
        assertEquals("sss",instance.get(0));
        assertEquals("Ali",instance.get(1));
    }
    
    @Test(timeout = 5000)
    public void testDelete(){
        LinkedListArrayOfStrings instance=new LinkedListArrayOfStrings();
       // instance.get(0);
       instance.add("sss");
       instance.add("Ali");
        assertEquals("sss",instance.get(0));
        assertEquals("Ali",instance.get(1));
        instance.add("Mery");
          assertEquals("Mery",instance.get(2));
        instance.deleteByIndex(0);
        assertArrayEquals(new String[]{"Ali","Mery"},instance.toArray());
    }
     @Test(timeout = 5000)
    public void testInsert(){
        LinkedListArrayOfStrings instance=new LinkedListArrayOfStrings();
       // instance.get(0);
       instance.insertValueAtIndex(0,"Jerry");
       instance.add("sss");
       instance.add("Ali");
        assertEquals("sss",instance.get(1));
        assertEquals("Ali",instance.get(2));
        instance.add("Mery");
          assertEquals("Mery",instance.get(3));
        instance.deleteByIndex(2);
        assertArrayEquals(new String[]{"Jerry","sss","Mery"},instance.toArray());
    }
    
}
