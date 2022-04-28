package ua.advanced.lesson05;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Program {
    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue;
        Hashtable hashtable;
        HashMap hashMap = null;
        Map synchronizedMap =  Collections.synchronizedMap(hashMap);
        ConcurrentHashMap concurrentHashMap;
    }
}
