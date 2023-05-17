package com.javatunes.catalog;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.*;

public class InMemoryCatalogTest {

    //object under test- fixture
    private InMemoryCatalog catalog;

    @Before
    public void setUp() {
        catalog = new InMemoryCatalog();
    }


    @Test
    public void findByCategory_shouldReturnPopulatedCollection_whenCategoryFound() {
        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);


    }

    @Test
    public void findById_shouldReturnNull_whenIdNotFound() {
        MusicItem item = catalog.findById(19L);
        assertNull(item);
    }

    @Test
    public void findById_shouldReturnMusicItemWithThatId_whenIdFound() {
        MusicItem item = catalog.findById(6L);
        assertEquals(6,item.getId().longValue());
    }
}