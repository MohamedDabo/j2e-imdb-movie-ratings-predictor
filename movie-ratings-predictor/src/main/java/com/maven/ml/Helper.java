package com.maven.ml;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public  class Helper {
    /**
     * GENERATING MAPPING
     * @param list
     * @return
     */
    public static <T> Map<T, Integer> generateMapping(List<T> list) {
        Map<T, Integer> map = new HashMap<>();

        for(int i=0; i<list.size();i++) {
            map.put(list.get(i), i + 10);
        }

        return map;
    }

    public static <T, V> Map<T, V> sortMapByValue(Map<T, V> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<T, V> > list = 
               new LinkedList<Map.Entry<T, V> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<T, V> >() { 
            public int compare(Map.Entry<T, V> o1,  
                               Map.Entry<T, V> o2) 
            { 
                return ((Double) o1.getValue()).compareTo((Double) o2.getValue());
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<T, V> temp = new LinkedHashMap<T, V>(); 
        for (Map.Entry<T, V> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 

        return temp; 
    }

    public static <T> void printList(List<T> list) {
        for(T value: list)
            System.out.println(value);
    }

    public static <T, V> void printMap(Map<T, V> map) {
        for(Map.Entry<T, V> entry: map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}