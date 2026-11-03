package HW1;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HW1 {
    public static void main(String[] args) {
        System.out.println("HW1");
        listAndSet();
        System.out.println("Set does not allow duplicates, adding duplicates will be ignored\n");

        linkedListAndArrayList();
        System.out.println("ArrayList is a dynamically resizing array, " +
                "while LinkedList is a chain of distinct node objects where each node references the next and previous ones\n");

        map();
        System.out.println("Map is a collection that stores key and value," +
                " HashMap is an implementation of the Map, using a linkedList to store value pair buckets\n" +
                "Hash collision occurs when two distinct keys produce the same hash code or map to the same index in a hash table\n");

        System.out.println("Collections is a utility class from java.util package that helps to store, manipulate, and organize groups of objects\n" +
                "Collections can change size dynamically, where arrays can't\n" +
                "Example Collections are List, Set and Map\n");

        System.out.println("Immutable class is a class whose instances cannot be modified after they are constructed. " +
                "Once initialized, the internal state of the object remains completely constant throughout its lifetime\n" +
                "Example of immutable class is String, Integer, Float, Double, Long, Short, Byte, Boolean, Character\n");

        System.out.println("Hashtable, HashMap, and ConcurrentHashMap are all hash table–based key-value stores, but they differ fundamentally in thread safety, locking granularity, null handling, and performance.\n" +
                "Hashtable is synchronized, meaning it is thread-safe and can be shared between multiple threads without additional synchronization. However, this synchronization comes at a performance cost, making Hashtable slower than HashMap in single-threaded scenarios.\n" +
                "HashMap is not synchronized, meaning it is not thread-safe and should not be used in concurrent environments without external synchronization. It allows one null key and multiple null values.\n" +
                "ConcurrentHashMap is designed for concurrent access and provides better scalability than Hashtable by allowing multiple threads to read and write concurrently. It does not allow null keys or values.\n");

        strings();
        System.out.println("String is an immutable class, meaning once a String object is created, it cannot be changed.\n " +
                "Any operation that seems to modify a String actually creates a new String object.\n" +
                "This immutability provides several benefits, including thread safety, security, and performance optimizations through string pooling.\n" );

        System.out.println("If you override equals() but not hashCode(), two equal objects may have different hash codes, causing them to be stored in different buckets in a hash-based collection.\n" +
                "This can lead to unexpected behavior, such as failing to retrieve an object that was previously added.\n" +
                "if you override hashCode() but not equals(), two objects with the same hash code may not be considered equal, leading to duplicate entries in collections that rely on equality checks.\n" +
                "To ensure consistent behavior in hash-based collections, it is essential to override both equals() and hashCode() methods in a way that maintains the contract between them.");
    }

    public static void listAndSet(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.clear();
        list.add("b");
        list.add("b");
        System.out.println("list "+list);

        Set<String> set = new HashSet<>();
        set.add("a");
        set.clear();
        set.add("b");
        set.add("b");
        System.out.println("set: "+set);
    }

    public static void linkedListAndArrayList(){
        List<String> arraylist = new ArrayList<>();
        arraylist.add("a");
        arraylist.add("b");
        arraylist.add(1,"c");
        System.out.println("arraylist "+arraylist);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add(1,"c");
        System.out.println("linkedList "+linkedList);
    }

    public static void map(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"q");
        map.put(2,"b");

        Map<Integer, String> hashtable = new Hashtable<>();
        hashtable.putIfAbsent(1, "q");

        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.putIfAbsent(1, "q");

        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println("Map, key: "+entry.getKey()+" value: "+entry.getValue());
        }

        for (Map.Entry<Integer,String> entry : hashtable.entrySet()){
            System.out.println("HashTable, key: "+entry.getKey()+" value: "+entry.getValue());
        }

        for (Map.Entry<Integer,String> entry : concurrentHashMap.entrySet()){
            System.out.println("ConcurrentHashMap, key: "+entry.getKey()+" value: "+entry.getValue());
        }
    }

    public static void strings(){
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");
        System.out.println("str1 == str2: "+(str1==str2));
        System.out.println("str1 == str3: "+(str1==str3));
        System.out.println("str1.equals(str3): "+(str1.equals(str3)));

        StringBuilder sb = new StringBuilder(32);
        sb.append("Hello");
        System.out.println("StringBuilder: "+sb.toString());
        sb.delete(0,3);
        System.out.println("After deletion: "+sb.toString());

        StringBuffer sbf = new StringBuffer();
        sbf.append("Hello");
        System.out.println("StringBuffer: "+sbf.toString());
        sbf.delete(0,3);
        System.out.println("After deletion: "+sbf.toString());
    }
}
