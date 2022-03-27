package com.kolmakova.array.service.impl;

import com.kolmakova.array.entity.ArrayEntity;
import com.kolmakova.array.exception.ArrayNotExistsException;
import com.kolmakova.array.exception.IllegalEntityStateException;
import com.kolmakova.array.service.ArrayEntityService;
import com.kolmakova.array.utils.ArrayEntityParserUtil;
import com.kolmakova.array.utils.FileReaderUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayEntityServiceImpl implements ArrayEntityService {

    private final FileReaderUtil fileReaderUtil;
    private final ArrayEntityParserUtil parserUtil;

    public ArrayEntityServiceImpl(FileReaderUtil fileReaderUtil, ArrayEntityParserUtil parserUtil) {
        this.fileReaderUtil = fileReaderUtil;
        this.parserUtil = parserUtil;
    }

    @Override
    public ArrayEntity readFromFile(String filePath) throws ArrayNotExistsException {
        List<String> strings = fileReaderUtil.readDataFromFile(filePath);

        return parserUtil.parseToArrayEntity(strings);
    }

    @Override
    public int getMinValue(ArrayEntity array) {
        int[] arr = array.getArray();
        if (arr == null) {
            throw new IllegalEntityStateException("Array can not be null!");
        }
        return Arrays
                .stream(arr)
                .min()
                .orElseThrow(this::throwException);
    }

    @Override
    public int getMaxValue(ArrayEntity array) {
        int[] arr = array.getArray();
        if (arr == null) {
            throw new IllegalEntityStateException("Array can not be null!");
        }
        return IntStream.of(arr)
                .max()
                .orElseThrow(this::throwException);
    }

    @Override
    public int getAverageValue(ArrayEntity array) {
        int sum = getSumOfElements(array);
        int[] arr = array.getArray();
        int numberOfElements = arr.length;

        return sum / numberOfElements;
    }

    @Override
    public int getSumOfElements(ArrayEntity array) {
        int[] arr = array.getArray();
        if (arr == null) {
            throw new IllegalEntityStateException("Array can not be null!");
        }
        return IntStream.of(arr)
                .sum();
    }

    @Override
    public int getNumberOfPositiveElements(ArrayEntity array) {
        int[] arr = array.getArray();
        if (arr == null) {
            throw new IllegalEntityStateException("Array can not be null!");
        }
        return (int) IntStream.of(arr)
                .filter(this::isPositive)
                .count();
    }

    @Override
    public ArrayEntity exchangePositiveValuesToOne(ArrayEntity array) {
        int[] arr = array.getArray();
        if (arr == null) {
            throw new IllegalEntityStateException("Array can not be null!");
        }
        int[] updatedArray = IntStream.of(arr)
                .map(this::replacePositiveToOne)
                .toArray();

        array.setArray(updatedArray);
        return array;
    }

    private IllegalEntityStateException throwException() {
        throw new IllegalEntityStateException("Array can not be empty!");
    }

    private int replacePositiveToOne(int element) {
        return element >= 0 ? 1 : element;
    }

    private boolean isPositive(int element) {
        return element >= 0;
    }
}
