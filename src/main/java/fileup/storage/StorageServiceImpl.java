package fileup.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService {
	
	private final Path rootLocation;

    @Autowired
    public StorageServiceImpl(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    @Override
    public void store(MultipartFile file) {
        try {
        	
            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
            
        } catch (IOException e) {
        	
        	System.out.println (e.toString());
            System.out.println("Failed to store file " + file.getOriginalFilename());
        }
    }
    

    @Override
    public void init() {
        try {
        	
        	File directory = new File(String.valueOf(rootLocation));
        	if (! directory.exists()){
        		Files.createDirectory(rootLocation);
        	}
        	
        } catch (IOException e) {
        	
        	System.out.println (e.toString());
            System.out.println("Could not initialize storage");
        }
    }
}
