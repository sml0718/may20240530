package com.eden.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("file")
public class FileController {
	
	@Value("${file.upload}")
	private String realPath;
	
	@Value("$(file.download.dir)")
	private String downloadDir;
	
	@RequestMapping("download")
	public void download(String filename,HttpServletResponse response) throws IOException {
		log.info("ファイルの名:{}",filename);
		System.out.println("download ok");
		log.info("フォルダ名前:{}",downloadDir);
		File file = new File(downloadDir,filename);
				
		FileInputStream iSteam = new FileInputStream(file);
		
		response.setHeader("Content-Disposition","attachment:filename="+URLEncoder.encode(filename,"UTF-8"));
		
		ServletOutputStream oStream = response.getOutputStream();
		
		FileCopyUtils.copy(iSteam, oStream);
		
	
	}
	
	@RequestMapping("upload")
	public String upload(MultipartFile file,HttpServletRequest request) throws IOException {
		System.out.println("file OK");
		log.info("ファイルの名:{},ファイルのサイズ:{},ファイルのタイプ:{}",
				file.getOriginalFilename(),file.getSize(),file.getContentType());
		
		
		String OriginalFileName=file.getOriginalFilename();
		
		//String realPath = "C:\\pleiades\\2023-12\\workspace\\springthymeleaf\\upload";
		log.info("パ-ス:{}",realPath);
		
		String ext = OriginalFileName.substring(OriginalFileName.lastIndexOf("."));
		log.info("suffix:{}",ext);
		
		String newfileName=OriginalFileName.substring(0,OriginalFileName.lastIndexOf("."))+
				new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+ext;
		
		log.info("新しいファイルの名:{}",newfileName);
		
		file.transferTo(new File(realPath,newfileName));
		
		return "redirect:/upload";
		
		
		
		
	}
}
