package com.kolmakova.array.service;

import com.kolmakova.array.entity.ArrayEntity;
import com.kolmakova.array.exception.ArrayNotExistsException;

public interface ArrayEntityService {

    ArrayEntity readFromFile(String filePath) throws ArrayNotExistsException;

    int getMinValue(ArrayEntity array);

    int getMaxValue(ArrayEntity array);

    int getAverageValue(ArrayEntity array);

    int getSumOfElements(ArrayEntity array);

    int getNumberOfPositiveElements(ArrayEntity array);

    ArrayEntity exchangePositiveValuesToOne(ArrayEntity array);
}
