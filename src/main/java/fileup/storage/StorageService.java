package fileup.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	void init();

    void store(MultipartFile file);
    
    Stream<Path> loadAll() throws IOException;

    Path load(String filename);
    
    void deleteAll();
}
