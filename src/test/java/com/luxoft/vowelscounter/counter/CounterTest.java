package com.luxoft.vowelscounter.counter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CounterTest {

	@Test
	void countVowels_with_noRepeatedSameVowels() {

		Stream<AverageVowel> count = Counter.countVowels(Stream.of("Platon"));

		assertThat(count).containsOnly(
				new AverageVowel( new Vowel(new HashSet<>(Arrays.asList('a', 'o')), 6), 2.0 )
				);
	}

	@Test
	void countVowels_with_repeatedSameVowels() {

		Stream<AverageVowel> count = Counter.countVowels(Stream.of("bamboo"));

		assertThat(count).containsOnly(
				new AverageVowel( new Vowel(new HashSet<>(Arrays.asList('a', 'o')), 6), 3.0 )
				);
	}

	@Test
	void countVowels_with_UpperCaseWord() {

		Stream<AverageVowel> count = Counter.countVowels(Stream.of("BAMBOO"));

		assertThat(count).containsOnly(
				new AverageVowel( new Vowel(new HashSet<>(Arrays.asList('a', 'o')), 6), 3.0 )
				);
	}


	@Test
	void countVowels_with_MultiWord() {

		Stream<AverageVowel> count = Counter.countVowels(Stream.of( "platon", "bamboo" ));

		assertThat(count).containsOnly(
				new AverageVowel( new Vowel(new HashSet<>(Arrays.asList('a', 'o')), 6), 2.5 )
				);
	}

}
