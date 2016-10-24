package fileup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fileup.FileUploadController;
import fileup.storage.StorageService;

public class FileUploadController {
	
	 private final StorageService storageService;

	    @Autowired
	    public FileUploadController(StorageService storageService) {
	        this.storageService = storageService;
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
