package com.luxoft.vowelscounter.util;

import java.util.Arrays;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class CommandLineOptionBuilder {


	public static final Option INPUT = new Option("i", "input", true, "Input");

	/**
	 * "Parsing" stage of command-line processing demonstrated with
	 * Apache Commons CLI.
	 * 
	 * @param arguments Command-line arguments provided to application.
	 * @return Instance of CommandLine as parsed from the provided Options and
	 *    command line arguments; may be {@code null} if there is an exception
	 *    encountered while attempting to parse the command line options.
	 */
	public static CommandLine getCLIOptions (String arguments[]) {

		try {

			return new DefaultParser().parse(new Options().addOption(INPUT), arguments);

		} catch (ParseException parseException)  {
			System.out.println(
					"ERROR: Unable to parse command-line arguments "
							+ Arrays.toString(arguments) + " due to: "
							+ parseException);
		}

		return null;
	}
}
