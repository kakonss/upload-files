package fileup;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;

import fileup.FileUploadController;
import fileup.storage.StorageService;

@Controller
public class FileUploadController {
	
	 private final StorageService storageService;

	    @Autowired
	    public FileUploadController(StorageService storageService) {
	        this.storageService = storageService;
	    }

	    @GetMapping("/")
	    public String listUploadedFiles(Model model) throws IOException {
	    	System.out.println("her1ehere1");
	        return "uploadForm";
	    }
	    
	    @PostMapping("/")
	    public String handleFileUpload(@RequestParam("file") MultipartFile file,
	                                   RedirectAttributes redirectAttributes) {

	        storageService.store(file);
	        redirectAttributes.addFlashAttribute("message",
	                "You successfully uploaded " + file.getOriginalFilename() + "!");

	        return "redirect:/";
	    }

}
