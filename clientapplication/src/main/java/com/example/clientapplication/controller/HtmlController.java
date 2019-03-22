<<<<<<< HEAD
package com.example.clientapplication.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HtmlController {

	@GetMapping(value="/home")
	public String getHomePage(){
		System.out.println("home controller");
		return "home";
	//	clientService.getAllProduct();
	}
	
	@GetMapping(value="/registration")
	public String getRegistrationPage(){
		System.out.println("registration controller");
		return "registration";
	}
	
	@GetMapping(value="/login")
	public String getLogInPage(){
		System.out.println("login controller");
		return "login";
	}
	
	@GetMapping(value="/upload")
	public String getUploadPage(){
		System.out.println("upload controller");
		return "upload";
	}
	
	 /*@PostMapping("/uploadFile") 
	    public String singleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("text") String text,
	                                   RedirectAttributes redirectAttributes) {
		 
		 System.out.println(text);
		 String UPLOADED_FOLDER = "C://Users//koustuvmu//";
	if (file.isEmpty()) {
        return "upload?again=true";
    }

    try {

        // Get the file and save it somewhere
        byte[] bytes = file.getBytes();
        Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
        Files.write(path, bytes);

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + file.getOriginalFilename() + "'");

    } catch (IOException e) {
        e.printStackTrace();
    }

    return "home";
}*/
}



=======
package com.example.clientapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HtmlController {
	


	@GetMapping(value="/home")
	public String getHomePage(){
		System.out.println("home controller");
		return "home";
	//	clientService.getAllProduct();
	}
	
	@GetMapping(value="/registration")
	public String getRegistrationPage(){
		System.out.println("registration controller");
		return "registration";
	}
	
	@GetMapping(value="/login")
	public String getLogInPage(){
		System.out.println("login controller");
		return "login";
	}
	
	@GetMapping(value="/upload")
	public String getUploadPage(){
		System.out.println("upload controller");
		return "upload";
	}
	
}



>>>>>>> 11c6e1b3db2177851a55a3fcaceeab4dd853a740
