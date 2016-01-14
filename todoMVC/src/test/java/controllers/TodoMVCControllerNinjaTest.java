package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.ToDoList;
import ninja.NinjaTest;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by michaelhilton on 1/14/16.
 */
public class TodoMVCControllerNinjaTest  extends NinjaTest {

    String URL_TODO_LIST_JSON = "/todoList.json";

    @Test
    public void testGetTodoListJson() {
        String s = ninjaTestBrowser.makeJsonRequest("http://localhost:8080" + URL_TODO_LIST_JSON);
        assertEquals("",s);
    }

    @Test
    public void testPOSTTodoListJson(){
        ToDoList tl = new ToDoList();
        tl.addTodoItem("Buy Milk");

        String response = ninjaTestBrowser.postJson("http://localhost:8080" + URL_TODO_LIST_JSON,tl);

        try {
            ToDoList resultTL = new ObjectMapper().readValue(response, ToDoList.class);
            assertEquals("Buy Milk",resultTL.lastItemAdded());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testPOSTaddItemTodoListJson(){
        ToDoList tl = new ToDoList();
        tl.item = "Buy Milk";
        tl.action = "add";

        String response = ninjaTestBrowser.postJson("http://localhost:8080" + URL_TODO_LIST_JSON,tl);

        try {
            ToDoList resultTL = new ObjectMapper().readValue(response, ToDoList.class);
            assertEquals("Buy Milk",resultTL.lastItemAdded());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
