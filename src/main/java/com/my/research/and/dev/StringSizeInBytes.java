package com.my.research.and.dev;

import java.io.UnsupportedEncodingException;

public class StringSizeInBytes {

    public static void main(String[] args) throws UnsupportedEncodingException {

        final String symbol = "EURUSD";
        System.out.println(symbol.getBytes("UTF-8").length);

        final String jtix = "20160912-00:00:00.005:{s:\"EURUSD\",sn:1471089547814,ns:5986190,m:{pts:0},bids:{1.12402:788000,1.12401:200000,1.124:2800000,1.12399:1500000,1.12398:2500000},asks:{1.12408:500000,1.12409:694000,1.1241:1850000,1.12411:1500000,1.12412:3800000}}";
        System.out.println(jtix.getBytes("UTF-8").length);
    }
}
