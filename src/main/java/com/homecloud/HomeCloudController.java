package com.homecloud;

import com.homecloud.files.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
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

    @GetMapping("/remove")
    @ResponseBody
    boolean delete(@RequestParam(value = "file") String file){
        String replace = file.replace("file:///", "");
        File file1 = new File(replace);
        return file1.delete();
    }

    @GetMapping("/add")
    @ResponseBody
    boolean create(@RequestParam(value = "file") String file,
                   @RequestParam(value = "newdir") String dir){
        String replace = file.replace("file:///", "");
        File file1 = new File(replace + dir);
        return file1.mkdir();
    }
}
