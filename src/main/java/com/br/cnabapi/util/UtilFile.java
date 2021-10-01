package com.br.cnabapi.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;

public class UtilFile {
	
	public static String readFile() {
		Path path = Paths.get("./uploads/" + "cnab.txt");

		StringBuilder sb = new StringBuilder();

		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(s -> sb.append(s).append("\n"));
			
		} catch (IOException ex) {
			throw new RuntimeException("Unable to read file: " + ex.getMessage());
		}

		String contents = sb.toString();
		
		return contents;
	}

}
