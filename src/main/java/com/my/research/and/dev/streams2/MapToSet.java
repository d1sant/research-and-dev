package com.my.research.and.dev.streams2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapToSet {

    public static void main(String[] args) {
        final Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 0);
        map.put("C", 3);
        Set<String> filteredKeys = map.entrySet().stream().filter(entry -> entry.getValue() > 0).map(Map.Entry::getKey).collect(Collectors.toSet());
        System.out.println(filteredKeys);
    }
}
