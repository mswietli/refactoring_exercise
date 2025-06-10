package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    public void shouldUpdateItems() {
        Item[] items = {new Item("foo", 10, 5), new Item("bar", 5, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
        assertEquals("bar", app.items[1].name);
        assertEquals(4, app.items[1].sellIn);
        assertEquals(2, app.items[1].quality);
    }
}
