package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredTest {

    @Test
    void shouldUpdateConjuredItem() {
        Item[] items = {new Item("Conjured", 10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void shouldUpdateConjuredItem_afterLastDay() {
        Item[] items = {new Item("Conjured", 0, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void shouldNotUpdateConjuredItem_toNegative() {
        Item[] items = {new Item("Conjured", 5, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }
}
