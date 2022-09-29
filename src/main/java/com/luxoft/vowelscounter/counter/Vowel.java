package com.luxoft.vowelscounter.counter;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Vowel {

	private Set<Character> chars;

	private final int length;

}
