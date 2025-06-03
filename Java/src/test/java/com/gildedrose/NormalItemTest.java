package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalItemTest {

    @Test
    void shouldUpdateNormalItem() {
        Item[] items = {new Item("foo", 10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
        assertEquals(9, app.items[0].sellIn);
        assertEquals(4, app.items[0].quality);
    }

    @Test
    void shouldUpdateNormalItem_afterLastDay() {
        Item[] items = {new Item("foo", 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void shouldNotUpdateNormalItem_toNegative() {
        Item[] items = {new Item("foo", 5, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
