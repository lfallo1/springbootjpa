package com.lancefallon.springbootjpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.lancefallon.springbootjpa.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}
