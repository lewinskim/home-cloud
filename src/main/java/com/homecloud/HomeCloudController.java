package com.homecloud;

import com.homecloud.files.FilesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class HomeCloudController {

    private final FilesService fs;

    public HomeCloudController(FilesService filesService) {
        this.fs = filesService;
    }

    @GetMapping("/files")
        List<Path> allFiles() {
        return fs.loadPaths().collect(Collectors.toList());
    }

}
