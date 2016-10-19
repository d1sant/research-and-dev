package com.my.research.and.dev.cache;

import java.util.Random;
import java.util.TreeMap;

public class SizeLimitedTreeMapBasedCache<T extends TickData> extends TreeMap<Long, T> {

    private static final Random random = new Random();

    final int size;
    long fistTs;
    long lastTs;

    public SizeLimitedTreeMapBasedCache(final int size) {
        this.size = size;
    }

    @Override
    public T put(final Long key, final T value) {
        final T put = super.put(key, value);
        if (fistTs == 0 || key < fistTs) {
            fistTs = key;
        }
        if (lastTs == 0 || key > lastTs) {
            lastTs = key;
        }
        if (size() > size) {
            pollFirstEntry();
            fistTs = firstKey();
        }
        return put;
    }

    public static void main(final String[] args) {
        final SizeLimitedTreeMapBasedCache<TickData> cache = new SizeLimitedTreeMapBasedCache<>(1_000_000);
        for (long i = 10; i < 10_000_000; i++) {
            cache.put(i, TickData.of(i, random.nextFloat(), random.nextFloat(), random.nextDouble(), random.nextDouble()));
        }
        System.out.println(cache.fistTs + " : " + cache.lastTs);
        System.out.println(cache.firstEntry().getValue() + " : " + cache.lastEntry());
    }
}