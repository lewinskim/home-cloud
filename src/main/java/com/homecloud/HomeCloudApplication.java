package com.homecloud;

import com.homecloud.files.FilesStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FilesStorageProperties.class)
public class HomeCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeCloudApplication.class, args);
	}

}
