package com.eden.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.eden.anno.Log;
import com.eden.entity.Employee;
import com.eden.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Value("${file.upload.dir}")
	private String realpath;
	
	@RequestMapping("search")
	public String searchEmp(String searchName,String lowSalary,String topSalary, 
			String dateBegin,String dateEnd,Model model) {
		
		searchName=searchName.trim();
		lowSalary=lowSalary.trim();
		topSalary=topSalary.trim();
		dateBegin=dateBegin.trim();
		dateEnd=dateEnd.trim();
		
		log.info("名前:{},最低給料:{},最高給料:{},開始時間:{},完了時間:{},",searchName,lowSalary,topSalary,dateBegin,dateEnd);
		
		List<Employee>empployee=employeeService.searchEmp(searchName,lowSalary,topSalary,dateBegin,dateEnd);
		
		model.addAttribute("employeeList",empployee);
		
		return "emplist";
	}
	@Log
	@RequestMapping("delete")
	public String delete(Integer id) {
		log.info("削除の社員ID:{}",id);
		
		String photo = employeeService.findById(id).getPhoto();
		File file=new File(realpath,photo);
		if(file.exists())file.delete();
		
		employeeService.delete(id);
		return "redirect:/employee/lists";
		
	}
	@Log
	@RequestMapping("update")
	public String update(Employee employee,MultipartFile img) throws IllegalStateException, IOException {
		log.info("更新した社員：{},名前:{},給料:{},誕生日:{}",employee.getId(),employee.getName(),employee.getSalary(),employee.getBirthday());
		
		boolean notempty = !img.isEmpty();
		log.info("写真更新するかどうが:{}",notempty);
		
		if(notempty) {
			String oldphoto=employeeService.findById(employee.getId()).getPhoto();
			File file=new File(realpath,oldphoto);
			if(file.exists()) {
				file.delete();
			}
			String originalFilename = img.getOriginalFilename();
			
			String newName = uploadPhoto(img,originalFilename);
			
			employee.setPhoto(newName);
		}

		employeeService.update(employee);
		return "redirect:/employee/lists";
		
	}
	private String uploadPhoto(MultipartFile img,String originalFilename) throws IllegalStateException, IOException {
		
		String fileNamePrefix = originalFilename.substring(0,originalFilename.lastIndexOf("."));
		String fileNamesufix = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		
		String newName=fileNamePrefix+fileNamesufix+originalFilename.substring(originalFilename.lastIndexOf("."));

		log.info("新しいファイルの名:{}",newName);
		
		img.transferTo(new File(realpath,newName));
		
		
		return newName;
		
	}
	
	
	@RequestMapping("detail")
	public String detail(Integer id ,Model model) {
		log.info("更新ID:{}",id);
		
		Employee employee=employeeService.findById(id);
		
		model.addAttribute("employee",employee);
		
		return"updateEmp";
		
	}
	@Log
	@RequestMapping("save")
	public String save(Employee employee,MultipartFile img) throws IllegalStateException, IOException {
		log.info("名前:{},給料:{},誕生日:{}",employee.getName(),employee.getSalary(),employee.getBirthday());
		
		String originalFilename = img.getOriginalFilename();
		log.info("ファイルの名:{},ファイルのサイズ：{},アップロードあど:{}",originalFilename,img.getSize()
				,realpath);
		
		
		String newName = uploadPhoto(img,originalFilename);
		log.info("新しいファイルの名:{}",newName);
		
		
		
		
		employee.setPhoto(newName);
		
		employeeService.save(employee);
	
		
		return "redirect:/employee/lists";
	}
	
	@RequestMapping("lists")
	public String lists(Model model) {
		
		log.info("全部社員を照会する");
		
		List<Employee> employeeList=employeeService.lists();
		
		model.addAttribute("employeeList",employeeList);
		return "emplist";
		
	}

}
