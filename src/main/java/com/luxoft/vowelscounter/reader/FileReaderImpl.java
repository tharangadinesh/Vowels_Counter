package com.luxoft.vowelscounter.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

@Service
public class FileReaderImpl implements FileReader {

	@Override
	public Stream<String> readFromFile(Path filepath) {

		try (Stream<String> lines = Files.lines(filepath)) {

			System.out.println("----------------------------- Reading lines from file----------------------");

			return lines.flatMap(Pattern.compile("\\W+")::splitAsStream).collect(Collectors.toList()).stream();

		} catch (IOException e) {

			System.out.println("----------------------------- Error occured while reading lines from file----------------------");

			throw new IllegalArgumentException("Unable to read the file", e);
		}

	}

}
