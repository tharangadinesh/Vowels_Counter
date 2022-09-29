package com.luxoft.vowelscounter.writer;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface FileWriter {

	void write(Stream<String> stream, Path path);

}
