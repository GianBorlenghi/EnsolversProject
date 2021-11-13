package com.ensolvers.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.ensolvers.app.entity.Task;

public interface ITask extends CrudRepository<Task, Long> {

}
