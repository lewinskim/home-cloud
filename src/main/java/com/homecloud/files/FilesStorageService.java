package com.homecloud.files;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@Slf4j
@Service
public class FilesStorageService implements FilesService {

    private final Path userDir;

    public FilesStorageService(FilesStorageProperties properties) {
        this.userDir = Path.of(properties.getUserDir());
        initializeFilesStorageService();
    }


    @Override
    public Stream<Path> loadPaths() {
        Stream<Path> result = Stream.empty();
        try {
            result = Files.walk(userDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void initializeFilesStorageService() {
        if (!Files.exists((userDir))) {
            try {
                Files.createDirectory(userDir);
            } catch (IOException e) {
                e.printStackTrace();
                log.error("files not created");
            }
        }
    }
}
