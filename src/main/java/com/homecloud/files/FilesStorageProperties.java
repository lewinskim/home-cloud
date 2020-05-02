package com.homecloud.files;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("filestorage")
public class FilesStorageProperties {

    private String userDir = "homecloudDir";

}
