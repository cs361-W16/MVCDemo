package models;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;

/**
 * Created by michaelhilton on 1/14/16.
 */
public class testTodoModel {

    @Test
    public void testModelExists(){
        ToDoList tl = new ToDoList();
        assertNotNull(tl);
    }

    @Test
    public void testModelAdd(){
        ToDoList tl = new ToDoList();
        tl.addTodoItem("Buy Milk");
        assertEquals(1,tl.numberOfItems());
        assertEquals("Buy Milk",tl.lastItemAdded());
    }

    @Test
    public void testModelAdd2(){
        ToDoList tl = new ToDoList();
        tl.addTodoItem("Buy Milk");
        tl.addTodoItem("Pick Up Dry Cleaning");
        tl.addTodoItem("Pay Bills");
        assertEquals(3,tl.numberOfItems());
        assertEquals("Pay Bills",tl.lastItemAdded());
    }
}
