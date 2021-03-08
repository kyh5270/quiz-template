package io.namoosori.web.fileserver.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import io.namoosori.web.fileserver.service.FileService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = {"/rest"})
@RequiredArgsConstructor
public class FileRestController {
    //
    private final FileService fileService;

    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam("file") List<MultipartFile> uploadFiles) throws IOException {
        //
        // TODO 
    	// 1. save file to server using FileService 
        // 2. redirect to main page    	
    	for(MultipartFile multiFile : uploadFiles) {
    		File file = new File(multiFile.getOriginalFilename());
    		file.createNewFile();
    		FileOutputStream fos = new FileOutputStream(file);
    		fos.write(multiFile.getBytes());
    		fos.close();
    		
    		fileService.upload(file);
		}
    	
    	ModelAndView modelAndView = new ModelAndView("/views/main.jsp");
        System.out.println("upload fileService.listFiles() : " + fileService.listFiles());
        
        modelAndView.addObject("fileNames", fileService.listFiles());
        return modelAndView;
    }

    @GetMapping(value = {"/download"}, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName) {
        //
    	// TODO send file to client using FileService
    	byte[] output = fileService.download(fileName);    	
    	
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charset", "utf-8");
        responseHeaders.setContentType(MediaType.valueOf("text/html"));
        responseHeaders.setContentLength(output.length);
        responseHeaders.set("Content-disposition", "attachment; filename="+fileName);
    	
    	return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
    }
    

    @GetMapping("/remove")
    public void remove(@RequestParam("fileName") String fileName) {
        //
        fileService.delete(fileName);
    }
    
    
}
