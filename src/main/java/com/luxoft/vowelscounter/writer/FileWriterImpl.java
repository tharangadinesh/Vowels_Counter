package com.luxoft.vowelscounter.writer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;


@Service
public class FileWriterImpl implements FileWriter {

	@Override
	public void write(Stream<String> lines, Path path) {
		try {

			System.out.println("----------------------------- Result writing to file ----------------------");

			Files.write(path, (Iterable<String>) lines::iterator);


			System.out.println("----------------------------- COMPLETED ! ----------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
