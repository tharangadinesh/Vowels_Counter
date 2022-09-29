package com.luxoft.vowelscounter.source;

import java.nio.file.FileSystem;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Source {

	private final FileSystem fileSystem;

	private final String fileInput;
	private final String fileOutput = "OUTPUT.txt";

}
