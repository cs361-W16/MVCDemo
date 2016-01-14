package controllers;

import models.ToDoList;
import ninja.Context;
import ninja.Result;
import ninja.Results;

/**
 * Created by michaelhilton on 1/14/16.
 */
public class TodoController {

    public Result TodoMVC(){
        return Results.html().template("views/ToDoMVC/todoMVC.ftl.html");
    }

    public Result TodoMVCJsonListGet(){
        ToDoList tl = new ToDoList();

        return Results.json().render(tl);
    }

    public Result TodoMVCJsonListPost(Context context, ToDoList list) {
        if(list.action.contains("add")){
            list.addTodoItem(list.item);
        }
        return Results.json().render(list);
    }
}
