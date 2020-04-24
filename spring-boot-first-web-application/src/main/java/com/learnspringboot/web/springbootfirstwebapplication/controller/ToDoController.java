package com.learnspringboot.web.springbootfirstwebapplication.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learnspringboot.web.springbootfirstwebapplication.service.TodoService;

@Controller
@SessionAttributes("name")
public class ToDoController {

	// DispatcherServelet is the front controller whatever request it comes to the Dispatcherservlet.
	//Model is used to pass data from controller to view (jsp)
	// spring-boot autoconfiguration
	
	@Autowired
	TodoService todoService;
	
	 @RequestMapping(value = "/list-todos")
	    public String showTodoList(ModelMap model) {
		 	String name = (String) model.get("name");
			model.put("todos", todoService.retrieveTodos(name));
	        return "list-todos";
	    }
	 
	 @RequestMapping(value="/add-todo", method = RequestMethod.GET)
		public String showAddTodoPage(ModelMap model){
			return "todo";
		}

		@RequestMapping(value="/add-todo", method = RequestMethod.POST)
		public String addTodo(ModelMap model, @RequestParam String desc){
			todoService.addTodo((String) model.get("name"), desc, new Date(), false);
			return "redirect:/list-todos";
		}

		@RequestMapping(value="/delete-todo", method = RequestMethod.GET)
		public String deleteTodo(@RequestParam int id){
			todoService.deleteTodo(id);
			return "redirect:/list-todos";
		}
}
