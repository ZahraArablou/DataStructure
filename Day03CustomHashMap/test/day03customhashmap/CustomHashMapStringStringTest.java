/*
 * To mapange this license header, mapoose License Headers in Project Properties.
 * To mapange this template file, mapoose Tools | Templates
 * and open the template in the editor.
 */
package day03customhashmap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author heshmat
 */
public class CustomHashMapStringStringTest {

    @Test
    public void PutGet_1() throws KeyNotFoundException {
        CustomHashMapStringString map=new CustomHashMapStringString();
         map.putValue("Jerry", "ff");
        map.putValue("Daniel", "ffl");
        map.putValue("Jerry", "ll");
        map.putValue("Joe", "dd");
        map.putValue("John", "hh");
        map.putValue("Mary", "ffl");
        map.putValue("Lili", "ll");
        map.putValue("Bery", "hh");
        map.putValue("Mary", "ffl");
        assertEquals("hh",map.getValue("Bery"));
        assertEquals("dd", map.getValue("Joe"));
      
    }
    
}
