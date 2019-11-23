import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class DoubleLinkedListTests {
    DoubleLinkedList dll = new DoubleLinkedList();

    @BeforeEach
    public void setup() {
        dll.chain(1);
        dll.chain(2);
        dll.chain(3);
        dll.chain(4);
        dll.chain(5);
    }

    @Test
    public void chainTest() {

        assertEquals(1, dll.getFirstValue(), "1 should be the first element");
        assertTrue(dll.toArray().contains(1));
        assertTrue(dll.toArray().contains(2));
        assertTrue(dll.toArray().contains(3));
        assertTrue(dll.toArray().contains(4));
        assertTrue(dll.toArray().contains(5));
    }

    @Test
    public void testDelete() {
        try {
            dll.removeElement(3);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertFalse(dll.toArray().contains(3));
    }

    @Test
    public void deleteFirst() {
        try {
            dll.removeElement(1);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertTrue(dll.toArray().contains(3));
    }

    @Test
    public void testPutBack() {
        try {
            dll.removeElement(3);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        dll.putBackLast();

        assertTrue(dll.toArray().contains(3));

    }

    @Test
    public void testPutBackFirst() {
        try {
            dll.removeElement(1);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        dll.putBackLast();
        assertEquals(1, dll.getFirstValue(), "1 should be the first element");
    }
    @Test
    public void testPutBackSecondRemovedFirst() {
        try {
            dll.removeElement(1);
            dll.removeElement(2);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        dll.putBackLast();
        assertEquals(2, dll.getFirstValue(), "2 should be the first element");
    }

    @Test
    public void removeAllPutBackAll(){

        try {
            dll.removeElement(1);
            dll.removeElement(2);
            dll.removeElement(3);
            dll.removeElement(4);
            dll.removeElement(5);
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertTrue(dll.isEmpty());

        dll.putBackAll();

        assertEquals(1, dll.getFirstValue(), "1 should be the first element");
        assertTrue(dll.toArray().contains(1));
        assertTrue(dll.toArray().contains(2));
        assertTrue(dll.toArray().contains(3));
        assertTrue(dll.toArray().contains(4));
        assertTrue(dll.toArray().contains(5));
    }

    @Test
    public void testIfThereAreSomeDeletedElements(){
        assertFalse(dll.areThereDeletedElements());

        try {
            dll.removeElement(1);
        } catch (Exception e) {
            fail(e.getMessage());
        }

        assertTrue(dll.areThereDeletedElements());
    }
}
