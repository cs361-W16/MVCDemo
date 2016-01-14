package controllers;

import models.ToDoList;
import ninja.Result;
import ninja.Results;

/**
 * Created by michaelhilton on 1/14/16.
 */
public class TodoController {

    public Result TodoMVC(){
        return Results.html().template("views/ToDoMVC/todoMVC.ftl.html");
    }

    public Result TodoMVCJsonList(){
        ToDoList tl = new ToDoList();

        return Results.json().render(tl);
    }
}
