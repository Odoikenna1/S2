package listPackage;

import listProject.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    private MyArrayList container;

    @BeforeEach
    void setUp(){
        container = new MyArrayList();
    }

    @Test
    void test_that_list_is_empty(){
        container.isEmpty();
        assertTrue(container.isEmpty());
    }
    @Test
    void test_that_list_can_add_to_itself(){
        container.add("jane");
        assertEquals(1, container.size());
    }
    @Test
    void test_that_list_can_add_element_and_size_increases(){
        container.add("john");
        container.add("jane");
        assertEquals(2, container.size());
    }
    @Test
    void test_that_list_can_add_multiple_elements(){
        container.add("sam");
        container.add("juice");
        container.add("ice");
        assertEquals("juice", container.getIndexAt(1));
    }
    @Test
    void test_that_list_can_remove_elements_from_the_array(){
        container.add("sam");
        container.add("juice");
        container.add("ice");
        assertEquals("juice", container.getIndexAt(1));
        container.remove(1);
        System.out.println(Arrays.toString(container.getContainer()));
//        assertEquals(2, container.size());
        container.remove("juice");
        assertArrayEquals(new String[]{"sam", "ice", null}, container.getContainer());
    }

}