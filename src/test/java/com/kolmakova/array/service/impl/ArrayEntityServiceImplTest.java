package com.kolmakova.array.service.impl;

import com.kolmakova.array.entity.ArrayEntity;
import com.kolmakova.array.utils.ArrayEntityParserUtil;
import com.kolmakova.array.utils.FileReaderUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;

public class ArrayEntityServiceImplTest {

    private FileReaderUtil fileReaderUtil;
    private ArrayEntityParserUtil parserUtil;
    private ArrayEntityServiceImpl entityService;

    @BeforeTest
    public void setUp() {
        fileReaderUtil = mock(FileReaderUtil.class);
        parserUtil = mock(ArrayEntityParserUtil.class);

        entityService = new ArrayEntityServiceImpl(fileReaderUtil, parserUtil);
    }

    @Test
    public void testGetMinValue() {
        //GIVEN
        int[] array = {12, 34, 6, 23};

        ArrayEntity arrayEntity = new ArrayEntity();
        arrayEntity.setArray(array);

        //WHEN
        int actual = entityService.getMinValue(arrayEntity);

        //THEN
        Assert.assertEquals(actual, 6);
    }

    @Test
    public void testGetMaxValue() {
        //GIVEN
        int[] array = {12, 34, 6, 23};

        ArrayEntity arrayEntity = new ArrayEntity();
        arrayEntity.setArray(array);

        //WHEN
        int actual = entityService.getMaxValue(arrayEntity);

        //THEN
        Assert.assertEquals(actual, 34);
    }

    @Test
    public void testGetAverageValue() {
        //GIVEN
        int[] array = {12, 34, 6, 23};

        ArrayEntity arrayEntity = new ArrayEntity();
        arrayEntity.setArray(array);

        //WHEN
        int actual = entityService.getAverageValue(arrayEntity);

        //THEN
        Assert.assertEquals(actual, 18);
    }

    @Test
    public void testGetSumOfElements() {
        //GIVEN
        int[] array = {12, 34, 6, 23};

        ArrayEntity arrayEntity = new ArrayEntity();
        arrayEntity.setArray(array);

        //WHEN
        int actual = entityService.getSumOfElements(arrayEntity);

        //THEN
        Assert.assertEquals(actual, 75);
    }

    @Test
    public void testGetNumberOfPositiveElements() {
        //GIVEN
        int[] array = {12, 34, 6, 23};

        ArrayEntity arrayEntity = new ArrayEntity();
        arrayEntity.setArray(array);

        //WHEN
        int actual = entityService.getNumberOfPositiveElements(arrayEntity);

        //THEN
        Assert.assertEquals(actual, 4);
    }

    @Test
    public void exchangePositiveValuesToOne() {
        //GIVEN
        int[] array = {12, -34, 6, 23};
        ArrayEntity arrayEntity = new ArrayEntity();
        arrayEntity.setArray(array);

        int[] expected = {1, -34, 1, 1};

        //WHEN
        ArrayEntity arrayEntity1 = entityService.exchangePositiveValuesToOne(arrayEntity);
        int[] actual = arrayEntity1.getArray();

        //THEN
        Assert.assertEquals(actual, expected);
    }
}