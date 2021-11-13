package com.ensolvers.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.ensolvers.app.entity.Folder;



public interface IFolder extends CrudRepository<Folder, Long> {

}
