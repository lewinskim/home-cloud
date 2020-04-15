package com.homecloud.files;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FilesService {

    Stream<Path> loadPaths();
}
