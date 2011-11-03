package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.Task;

public class TaskController extends Controller {
    public static void list() {
        List<Task> tasks = Task.findAll();  
		renderJSON(tasks);
    }
}