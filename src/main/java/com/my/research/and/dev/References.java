package com.my.research.and.dev;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;

public class References {

    List<BigObject> strongList; // strong references
    List<Reference<BigObject>> softList; // soft references
    List<Reference<BigObject>> weakList; // week references
    List<Reference<BigObject>> phantomList; // phantom references
    ReferenceQueue<BigObject> queue; // que
    List<String> loadMemoryList; // here we'll store a references to string which are used to load a memory

    private void printLists() {
        System.out.println("Strong references: ");
        for (BigObject bo : strongList) {
            System.out.print(bo + " ");
        }
        System.out.println();
        System.out.println("SoftReferences: ");
        printList(softList);
        System.out.println("WeakReferences: ");
        printList(weakList);
        System.out.println("PhantomReferences: ");
        printList(phantomList);
    }

    private void printList(List<Reference<BigObject>> pList) {
        for (Reference<BigObject> ref : pList) {
            System.out.print(ref.get() + " ");
        }
        System.out.println();
    }

    private void init() {
        strongList = new ArrayList<>();
        softList = new ArrayList<>();
        weakList = new ArrayList<>();
        phantomList = new ArrayList<>();
        loadMemoryList = new ArrayList<>();
        queue = new ReferenceQueue<>();
        for (int i = 0; i < 3; i++) {
            strongList.add(new BigObject(i));
            softList.add(new SoftReference<>(new BigObject(i)));
            weakList.add(new WeakReference<>(new BigObject(i)));
            phantomList.add(new PhantomReference<>(new BigObject(i), queue));
        }
        printLists();
    }

    private void loadMemory() {
        for (int i = 0; i < 1_200_000; i++) {
            loadMemoryList.add(i + "");
        }
    }

    public void testPhantomReferences() {
        init();
        System.gc();
        System.out.println("garbage collector invoked");
        printLists();
    }

    public void testSoftRefences() {
        init();
        System.gc();
        System.out.println("garbage collector invoked");
        printLists();
        System.out.println("memory usage increased");
        loadMemory();
        System.out.println("loadMemoryList.size() = " + loadMemoryList.size());
        System.gc();
        System.out.println("garbage collector invoked");
        printLists();
    }

    public static void main(String[] args) {
        References references = new References();
        // references.testPhantomReferences();
        references.testSoftRefences();
    }
}

class BigObject {
    private int value;

    public BigObject(Integer pValue) {
        value = pValue;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("BigObject (" + value + ") finalize()");
    }

    @Override
    public String toString() {
        return value + "";
    }
}
