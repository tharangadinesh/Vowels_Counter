package com.luxoft.vowelscounter.service;

import java.util.stream.Stream;

import com.luxoft.vowelscounter.source.Source;

public interface FileReaderService {

	public Stream<String> readToStream(Source vowelsCounter) throws Exception;

}
