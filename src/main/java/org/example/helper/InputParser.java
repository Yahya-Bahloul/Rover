package org.example.helper;

import org.example.entity.ParsedInput;

import java.io.IOException;

public interface InputParser {
    ParsedInput parse(String path) throws IOException;
}
