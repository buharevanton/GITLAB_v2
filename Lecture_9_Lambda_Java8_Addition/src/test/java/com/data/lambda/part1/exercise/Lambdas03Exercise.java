package com.data.lambda.part1.exercise;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;

public class Lambdas03Exercise {

    private interface GenericProduct<T> {
        T prod(T a, int i);

        default T twice(T t) {
            return prod(t, 2);
        }
    }

    @Test
    public void generic0() {
        final GenericProduct<Integer> prod = new GenericProduct<Integer>() {
            @Override
            public Integer prod(Integer a, int i) {
                return a * i;
            }
        };

        assertEquals(prod.prod(3, 2), Integer.valueOf(6));
    }

    @Test
    public void generic1() {
        final GenericProduct<Integer> prod = (a, b) -> {return a * b;}; // TODO: Use statement lambda

        assertEquals(prod.prod(3, 2), Integer.valueOf(6));
    }

    @Test
    public void generic2() {
        final GenericProduct<Integer> prod = (a, b) -> a * b; // TODO: Use expression lambda

        assertEquals(prod.prod(3, 2), Integer.valueOf(6));
    }

    private static String stringProd(String s, int i) {
        final StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(s);
        }
        return sb.toString();
    }

    @Test
    public void strSum() {
        final GenericProduct<String> prod = (a, i) -> "aa"; // TODO: use convertion to str

        assertEquals(prod.prod("a", 2), "aa");
    }
}
