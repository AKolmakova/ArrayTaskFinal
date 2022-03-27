package com.kolmakova.array.utils;

import com.kolmakova.array.entity.ArrayEntity;
import com.kolmakova.array.exception.ArrayNotExistsException;

import java.util.Arrays;
import java.util.List;

public class ArrayEntityParserUtil {

    public ArrayEntity parseToArrayEntity(List<String> dataFromFile) throws ArrayNotExistsException {
        ArrayEntity arrayEntity = new ArrayEntity();

        for (String str : dataFromFile) {

            if (ValidatorUtil.isInvalid(str)) {
                continue;
            }

            int[] array = Arrays.stream(str.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            arrayEntity.setArray(array);
            break;
        }

        if (arrayNotExists(arrayEntity)) {
            throw new ArrayNotExistsException("Array is null or empty");
        }

        return arrayEntity;
    }

    private boolean arrayNotExists(ArrayEntity entity) {
        int[] array = entity.getArray();

        return array == null || array.length == 0;
    }
}
