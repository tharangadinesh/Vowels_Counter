package com.luxoft.vowelscounter.util;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CommandLineOptionBuilder {

	public static final Option INPUT = new Option("i", "input", true, "Input");

	private static CommandLine commandLine = null;

	public static CommandLine getCLIOptions (String arguments[]) {

		if (commandLine == null) {

			CommandLineParser commandLineParser = new DefaultParser();

			Options options = new Options();
			options.addOption(INPUT);

			try {
				commandLine = commandLineParser.parse(options, arguments);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return commandLine;
	}
}
