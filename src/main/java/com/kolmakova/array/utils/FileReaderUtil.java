package com.kolmakova.array.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {

    private static final Logger LOG = LogManager.getLogger();

    private static FileReaderUtil instance;

    private FileReaderUtil() {

    }

    public static FileReaderUtil getInstance() {
        if (instance == null) {
            instance = new FileReaderUtil();
        }

        return instance;
    }

    public List<String> readDataFromFile(String path) {
        List<String> dataFromFile = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dataFromFile.add(line);
            }
        } catch (IOException e) {
            LOG.error(String.format("Error occurred during read file %s", path), e);
        }

        return dataFromFile;
    }
}



