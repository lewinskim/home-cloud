package com.homecloud.files;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.nio.file.Path;
import java.nio.file.Paths;

@ConfigurationProperties("filestorage")
public class FilesStorageProperties {

    private String userDir = "homecloudDir";

    public String getUserDir(){
        return userDir;
    }

    public void setUserDir(String userDir){
        this.userDir = userDir;
    }

}
