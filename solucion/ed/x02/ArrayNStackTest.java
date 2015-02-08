package ed.x02;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArrayNStackTest {
    private ArrayNStack<String> S1;
    private ArrayNStack<String> S2;

    @Before
    public void setupFixture() {

            S1 = new ArrayNStack<String>(5);
            S1.push("A", "B", "C");

            S2 = new ArrayNStack<String>(10);
            S2.push("A", "B", "C");
    }

    @Test
    public void testClone(){
        NStack<String> copy=S1.clone();
        assertTrue(S1.isEqualTo(copy));
        copy.push("F");
        assertFalse(S1.isEqualTo(copy));
    }
    
    @Test
    public void testContains(){
        assertTrue(S1.contains("A"));
        assertFalse(S1.contains("G"));
    }
    
    @Test
    public void testDelete(){
        assertEquals(1, S1.delete("B"));
        S1.push("A", "A", "A");
        assertEquals(4, S1.delete("A"));
        assertEquals("C", S1.toString());
    }

    @Test
    public void testDrops() {

            ArrayNStack<String> S3 = new ArrayNStack<String>(5);
            S3.push("C", "D", "E", "F", "G");

            S1.push("D", "E", "F", "G");

            assertTrue(S3.isEqualTo(S1));

            assertTrue(S1.isFull());
    }

    @Test
    public void testEquality() {

            assertTrue(S1.isEqualTo(S2));
    }

    @Test
    public void testPop() {

            assertEquals("C", S1.pop());
            assertEquals("B", S1.pop());
            assertEquals("A", S1.pop());
            assertTrue(S1.isEmpty());
    }

    @Test(expected=EmptyCollectionException.class)
    public void testPopPastEmpty() {

            assertEquals("C", S1.pop());
            assertEquals("B", S1.pop());
            assertEquals("A", S1.pop());

            S1.pop();
    }
}
