package com.my.research.and.dev;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class WeakHashMaps {

    public static void main(String[] args) {

        final ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        final WeakHashMap<Long, WeakReference<String>> hashMap = new WeakHashMap<>();
        hashMap.put(1L, new WeakReference<>("1", referenceQueue));
        hashMap.put(2L, new WeakReference<>("2", referenceQueue));
        hashMap.put(3L, new WeakReference<>("3", referenceQueue));
        System.out.println(hashMap.get(3L).get());

        referenceQueue.poll();
        System.out.println(hashMap.get(1L).get());
        System.out.println(hashMap.get(2L).get());
        System.out.println(hashMap.get(3L).get());
    }
}
