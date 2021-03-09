package io.namoosori.web.fileserver.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.namoosori.web.fileserver.service.FileService;
import lombok.RequiredArgsConstructor;

@RequestMapping(value = { "/file"})
@Controller
@RequiredArgsConstructor
public class FileController {
	//
    private final FileService fileService;
    
    @GetMapping("/")
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView("/views/main.jsp");

        System.out.println("fileService.listFiles() : " + fileService.listFiles());
        
        // TODO Implements method
        modelAndView.addObject("fileNames", fileService.listFiles());
        
        return modelAndView;
    }
    
    @GetMapping("/find")
    public ModelAndView findNameLike(@RequestParam String nameLike) {
        ModelAndView modelAndView = new ModelAndView("/views/main.jsp");
        
        // TODO Implements method
        modelAndView.addObject("fileNames", fileService.listFilesNameLike(nameLike));
        
        return modelAndView;
    }
}
