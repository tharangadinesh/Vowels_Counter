package com.luxoft.vowelscounter.counter;

import java.nio.file.FileSystems;
import java.util.stream.Stream;

import org.apache.commons.cli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.luxoft.vowelscounter.service.FileReaderService;
import com.luxoft.vowelscounter.source.Source;
import com.luxoft.vowelscounter.util.CommandLineOptionBuilder;
import com.luxoft.vowelscounter.writer.FileWriter;

@Component
public class VowelCounter {

	@Autowired
	private FileReaderService fileReaderService;

	@Autowired
	private FileWriter writer;

	public void count(String... args) throws Exception {

		CommandLine commandLine = CommandLineOptionBuilder.getCLIOptions(args);

		if (commandLine.getOptions().length > 0) {

			if (commandLine.hasOption(CommandLineOptionBuilder.INPUT.getLongOpt())) {

				String fileInput = commandLine.getOptionValue(CommandLineOptionBuilder.INPUT);

				Source source = new Source(FileSystems.getDefault(), fileInput);

				Stream<String> words = fileReaderService.readToStream(source);

				Stream<AverageVowel> averageVowels = Counter.countVowels(words);

				writer.write(Counter.format(averageVowels), source.getFileSystem().getPath(source.getFileOutput()));

			}

		} else {
			System.out.println("ERROR: Unable to find command-line arguments ");
		}

	}
}
