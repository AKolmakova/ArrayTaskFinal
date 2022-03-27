package com.kolmakova.array.entity;

import java.util.Arrays;

public class ArrayEntity {

    private int[] array;

    public ArrayEntity(int[] array) {
        this.array = array;
    }

    public ArrayEntity() {

    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayEntity)) return false;
        ArrayEntity that = (ArrayEntity) o;
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
