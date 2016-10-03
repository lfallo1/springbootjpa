package com.lancefallon.springbootjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lancefallon.springbootjpa.model.Task;
import com.lancefallon.springbootjpa.service.TaskService;

@RestController
@RequestMapping(value="/api/tasks")
public class TasksRestController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Task>> list(){
		return new ResponseEntity<>(this.taskService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Task> add(@RequestBody Task task){
		return new ResponseEntity<>(this.taskService.save(task), HttpStatus.OK);
	}
	
}
