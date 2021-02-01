/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaltreepatterns;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.Timeout;

/**
 *
 * @author heshmat
 */
public class TreeStringIntSetTest {

    public TreeStringIntSetTest() {
    }

    @Test //add test
    public void addTest() throws DuplicateValueException {
        TreeStringIntSet tree = new TreeStringIntSet();
        tree.add("Jerry", 12);
        tree.add("Ali", 20);
        tree.add("CCC", 30);
        tree.add("DDD", 40);
        assertEquals(true, tree.containsKey("Jerry"));
    }

    @Test
    public void getAllKeysTest() throws DuplicateValueException {
        TreeStringIntSet tree = new TreeStringIntSet();
        tree.add("Jerry", 12);
        tree.add("Ali", 20);
        assertEquals("Jerry,Ali", tree.toString());
        tree.add("Merry", 20);

        List<String> expectedValue = new ArrayList();
        expectedValue.add("Merry");
        expectedValue.add("Jerry");
        expectedValue.add("Ali");

        assertEquals(tree.getAllKeys(), expectedValue);

    }

    @Test
    public void getValuesByKeyTest() throws DuplicateValueException {
        TreeStringIntSet tree = new TreeStringIntSet();
        tree.add("Merry", 20);
        tree.add("Merry", 50);
        tree.add("ff", 40);
        tree.add("jj", 50);
        tree.add("ff", 50);
        assertEquals("jj,ff,Merry", tree.getKeysByValuetoString(50));
    }

}
