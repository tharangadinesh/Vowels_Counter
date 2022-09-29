package com.luxoft.vowelscounter.reader;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileReader {

	Stream<String> readFromFile(Path path);

}
