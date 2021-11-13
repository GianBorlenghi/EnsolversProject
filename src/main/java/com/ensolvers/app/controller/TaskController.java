package com.ensolvers.app.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ensolvers.app.entity.Folder;
import com.ensolvers.app.entity.Task;
import com.ensolvers.app.repository.IFolder;
import com.ensolvers.app.repository.ITask;
import com.ensolvers.app.service.IFolderService;
import com.ensolvers.app.service.ITaskService;

	@Controller
	public class TaskController {

	@Autowired
	private ITaskService taskRep;
	
	@Autowired
	private IFolderService folderRep;
	
	//Get all tasks.
	@RequestMapping("/index")
	public  String findTasks(Model model){
		List<Task> lista = taskRep.list();
		model.addAttribute("lista",lista);
		return "index";
		}

	@GetMapping("/add")
	public String showAddForm(@ModelAttribute("task") Task task,Model model) {
		List<Folder> listFolder = folderRep.listFolder();
		model.addAttribute("listFolder", listFolder);
		return "addTask";
	}
	
	@PostMapping("/saveTask")
	public String saveTask(@ModelAttribute("task") Task task) {
		taskRep.save(task);
		return "redirect:/index";
	}
	
	@GetMapping("/edit/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long idTask, Model model) {
		Task task = taskRep.listarId(idTask);
		model.addAttribute("task", task);
		return "editTask";
	}
	
	@PostMapping("/saveEditTask/{id}")
	public String saveEditTask(@PathVariable(value = "id") long idTask, Task task) {
		Task tazk = taskRep.listarId(idTask);
		String name = task.getName();
		tazk.setName(name);
		taskRep.save(tazk);
		return "redirect:/index";
	}

	@GetMapping("/delete/{id}")
	public String deleteTask(@PathVariable (value = "id") long idTask, Model model) {
		
		Task task = taskRep.listarId(idTask);
		taskRep.delete(task);
		return "redirect:/index";
	}
	}
	

