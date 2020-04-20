package com.homecloud;

import com.homecloud.files.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeCloudController {

    @Autowired
    private FilesService fs;

    @GetMapping("/")
    String index() { return "index"; }

    @GetMapping("/files")
    @ResponseBody
    List<Path> allFiles() {
        return fs.loadPaths().collect(Collectors.toList());
    }

}
