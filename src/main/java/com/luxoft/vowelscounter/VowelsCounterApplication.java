package com.luxoft.vowelscounter;

import java.nio.file.FileSystems;
import java.util.stream.Stream;

import org.apache.commons.cli.CommandLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.luxoft.vowelscounter.counter.AverageVowel;
import com.luxoft.vowelscounter.counter.Counter;
import com.luxoft.vowelscounter.service.FileReaderService;
import com.luxoft.vowelscounter.source.Source;
import com.luxoft.vowelscounter.util.CommandLineOptionBuilder;
import com.luxoft.vowelscounter.writer.FileWriter;

@SpringBootApplication
@ComponentScan(basePackages = {"com.luxoft.vowelscounter.service", "com.luxoft.vowelscounter.reader", "com.luxoft.vowelscounter.writer", "com.luxoft.vowelscounter.counter"})
public class VowelsCounterApplication implements CommandLineRunner{

	@Autowired
	private FileReaderService fileReaderService;

	@Autowired
	private FileWriter writer;

	public static void main(String[] args) {
		SpringApplication.run(VowelsCounterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CommandLine cl = CommandLineOptionBuilder.getCLIOptions(args);

		if (cl.getOptions().length > 0) {

			if (cl.hasOption(CommandLineOptionBuilder.INPUT.getLongOpt())) {

				String fileInput = cl.getOptionValue(CommandLineOptionBuilder.INPUT);

				Source source = new Source(FileSystems.getDefault(), fileInput);

				Stream<String> words = fileReaderService.readToStream(source);

				Stream<AverageVowel> averageVowels = Counter.countVowels(words);

				writer.write(Counter.format(averageVowels), source.getFileSystem().getPath(source.getFileOutput()));

			}

		} else {
			System.out.println("Invalid input options!");
		}

	}
}
