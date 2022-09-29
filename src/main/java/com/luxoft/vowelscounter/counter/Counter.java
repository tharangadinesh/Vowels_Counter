package com.luxoft.vowelscounter.counter;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.luxoft.vowelscounter.util.DecimalFormater;

public class Counter {

	private final static Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

	public static Stream<AverageVowel> countVowels(Stream<String> words) {

		System.out.println("----------------------------- Counting vowels ----------------------");

		return words.map( (word) -> {

			List<Character> filteredVowels = word.chars()
					.map(Character::toLowerCase)
					.mapToObj(c -> (char) c)
					.filter(VOWELS::contains)
					.collect(Collectors.toList());

			return new AverageVowel(new Vowel(new HashSet<>(filteredVowels), word.length()), filteredVowels.size());

		}).collect(groupingBy(AverageVowel::getVowel, averagingDouble(AverageVowel::getAverage)))
				.entrySet().stream()
				.map(entry -> new AverageVowel(entry.getKey(), entry.getValue()));
	}

	public static Stream<String> format(Stream<AverageVowel> averageVowels) {

		System.out.println("----------------------------- Formating result write to file ----------------------");

		return averageVowels.map( averageVowel ->

		String.format(
				"({%s}, %d) -> %s",
				averageVowel.getVowel().getChars().stream()
				.map(String::valueOf)
				.collect(Collectors.joining(",")),
				averageVowel.getVowel().getLength(),
				DecimalFormater.format(averageVowel.getAverage()))

				);

	}




}
