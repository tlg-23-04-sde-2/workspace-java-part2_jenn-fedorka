/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog.test;

import com.javatunes.catalog.InMemoryCatalog;
import com.javatunes.catalog.MusicCategory;
import com.javatunes.catalog.MusicItem;

import java.util.Collection;

class InMemoryCatalogTest {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        // testFindById();
        //testFindByKeyword();
        // testFindByCategory();
        // testSize();
        testGetAll();
        //testGenreCount();
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem itemFound = catalog.findById(6L);
        System.out.println(itemFound);

        MusicItem itemNotFound = catalog.findById(20L);
        System.out.println(itemNotFound);
    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();

//        Collection<MusicItem> itemFound = catalog.findByKeyword("the");
//        dump(itemFound);

        Collection<MusicItem> itemNotFound = catalog.findByKeyword("Madonna");
        dump(itemNotFound);

    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> item = catalog.findByCategory(MusicCategory.POP);
        dump(item);
    }

    private static void testSize() {
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> allItems = catalog.getAll();


//        InMemoryCatalog catalog = new InMemoryCatalog();
//        Collection<MusicItem> wholeCollection = catalog.getAll();
//        dump(wholeCollection);
    }

    private static void dump(Collection<MusicItem> items){
        for (MusicItem item : items) {
            System.out.println(item);

        }
    }
}