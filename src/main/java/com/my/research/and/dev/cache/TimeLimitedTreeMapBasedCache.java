package com.my.research.and.dev.cache;

import com.google.common.collect.TreeMultimap;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class TimeLimitedTreeMapBasedCache {

    private static final Random random = new Random();

    private static final long EXPIRED_TIME_IN_SECONDS = 10L;
    private final Timer timer;
    private final TreeMultimap<Long, TickData> cache;
    volatile long fistTs;
    volatile long lastTs;

    public TimeLimitedTreeMapBasedCache(final int seconds) {
        cache = TreeMultimap.create();
        timer = new Timer("CacheCleaner", true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                clearExpiredElements(cache);
            }
        }, 0, seconds * 1000);
    }

    private void clearExpiredElements(final TreeMultimap<Long, TickData> cache) {
        final long expiredTs = System.currentTimeMillis() - EXPIRED_TIME_IN_SECONDS * 1000L;
        while (cache.size() > 0) {
            final long firstKey = cache.asMap().firstKey();
            if (firstKey <= expiredTs) {
                // final TickData tickData = cache.get(firstKey);
                cache.removeAll(firstKey);
                final Long nextKey = cache.asMap().firstEntry().getKey();
                if (nextKey != null) {
                    fistTs = nextKey;
                } else {
                    fistTs = 0;
                    lastTs = 0;
                }
                // log("Removed timestamp: " + firstKey + ", toData: " + new Date(firstKey) + " , " + tickData);
            }
            if (firstKey > expiredTs) {
                break;
            }
        }
    }

    public void put(final long key, final TickData value) {
        cache.put(key, value);
        if (fistTs == 0 || key < fistTs) {
            fistTs = key;
        }
        if (lastTs == 0 || key > lastTs) {
            lastTs = key;
        }
    }

    public int size() {
        return cache.size();
    }

    public static void main(final String[] args) throws InterruptedException {
        final TimeLimitedTreeMapBasedCache cache = new TimeLimitedTreeMapBasedCache(1);
        long showedTs = 0;
        for (int i = 0; i < 100_000; i++) {
            final long ts = System.currentTimeMillis();
            Thread.sleep(0, 50);
            cache.put(ts, TickData.of(ts, random.nextFloat(), random.nextFloat(), random.nextDouble(), random.nextDouble()));
            if (ts - showedTs >= 1000) {
                showedTs = ts;
                System.out.println("Cache size: " + cache.size() + ", ft: " + cache.fistTs + ", lt: " + cache.lastTs);
            }
        }
        while(cache.size() > 0) {
            Thread.sleep(1000);
            System.out.println("Cache size: " + cache.size() + ", ft: " + cache.fistTs + ", lt: " + cache.lastTs);
        }
    }

    private static void log(final String str) {
        System.out.println(str);
    }
}
