package com.ensolvers.app.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="folders")
public class Folder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFolder;
	
	@Basic
	private String folderName;
	
	@OneToMany(mappedBy="taskFolder", cascade = CascadeType.ALL)
	private List<Task> tasks;

	public Folder() {
		super();
	}

	public Folder(long idFolder, String folderName, List<Task> tasks) {
		super();
		this.idFolder = idFolder;
		this.folderName = folderName;
		this.tasks = tasks;
	}

	public long getIdFolder() {
		return idFolder;
	}

	public void setIdFolder(long idFolder) {
		this.idFolder = idFolder;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	

	
}
