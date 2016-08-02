package com.my.research.and.dev;

import java.math.BigDecimal;

public class BigDecimalTest {

    public static void main(String[] args) {

        final BigDecimal decimal = new BigDecimal("0.001");
        System.out.println(decimal);
        System.out.println(decimal.movePointRight(1));
        System.out.println(decimal.movePointLeft(1));

        final BigDecimal decimal1 = new BigDecimal("2000.0").movePointLeft(1).setScale(2, BigDecimal.ROUND_UP);
        System.out.println(decimal1);

        System.out.println("S".equals("s"));
    }
}
