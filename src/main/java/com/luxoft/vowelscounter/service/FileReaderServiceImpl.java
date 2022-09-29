package com.luxoft.vowelscounter.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luxoft.vowelscounter.reader.FileReader;
import com.luxoft.vowelscounter.source.Source;

@Service
public class FileReaderServiceImpl implements FileReaderService {

	@Autowired
	private FileReader reader;

	@Override
	public Stream<String> readToStream(Source vowelsCounter) throws Exception {

		return reader.readFromFile(vowelsCounter.getFileSystem().getPath(vowelsCounter.getFileInput()));

	}

}
