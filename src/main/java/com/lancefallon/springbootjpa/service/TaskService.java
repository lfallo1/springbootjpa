package com.lancefallon.springbootjpa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lancefallon.springbootjpa.dao.TaskRepository;
import com.lancefallon.springbootjpa.model.Task;

@Service
@Transactional
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public TaskService(){ }
	
	public List<Task> findAll(){
		Iterable<Task> iterator = this.taskRepository.findAll();
		List<Task> tasks = new ArrayList<>();
		iterator.forEach(task->{
			tasks.add(task);
		});
		return tasks;
	}
	
	public Task save(Task task){
		task.setDateCreated(new Date());
		task.setFinished(false);
		return this.taskRepository.save(task);
	}
}
