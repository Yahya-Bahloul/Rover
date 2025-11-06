package org.example.helper;

import java.io.IOException;
import java.util.List;

public interface InputReader {

    List<String> readLines(String path) throws IOException;
}
