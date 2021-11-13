package com.ensolvers.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ensolvers.app.entity.Folder;
import com.ensolvers.app.entity.Task;
import com.ensolvers.app.service.IFolderService;
import com.ensolvers.app.service.ITaskService;

@Controller
public class FolderController {

	
	@Autowired
	private IFolderService foldRep;
	
	@Autowired
	private ITaskService taskRep;
	
	//get all folders
	@RequestMapping("/showFolder")
	public  String findTasks(Model model){
		List<Folder> listFolder = foldRep.listFolder();
		model.addAttribute("listFolder",listFolder);
		return "showFolder";
		}
	
	//add folder
	
	@GetMapping("/addFol")
	public String showAddFolderForm(@ModelAttribute("folder") Folder folder,Model model) {
		return "addFolder";
	}
	
	@PostMapping("/addFolder")
	public String addFolder(@ModelAttribute("folder") Folder folder) {
		foldRep.save(folder);
		return "redirect:/showFolder";
	}
	
	//delete folder
	
	@GetMapping("/deleteFolder/{id}")
	public String deleteFolder(@PathVariable (value = "id") long idFolder,Model model) {
		Folder folder = foldRep.listIdFolder(idFolder);
		foldRep.delete(folder);
		
		return "redirect:/showFolder";
	}
	
	@GetMapping("/view/{id}")
	public String viewTask(@PathVariable(value="id") long idFolder, Model model) {
		Folder fold = foldRep.listIdFolder(idFolder);
		List<Task>listTasks = fold.getTasks();
		model.addAttribute("listTasks", listTasks);	
		model.addAttribute("folder", foldRep.listIdFolder(idFolder));
		return "folderViews";
	}
	
	//Folders-tasks
	

	

}

