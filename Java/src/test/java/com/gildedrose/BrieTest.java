package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BrieTest {

    @Test
    void shouldIncreaseQualityOfBrie() {
        Item[] items = {new Item("Aged Brie", 10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(6, app.items[0].quality);
    }

    @Test
    void shouldIncreaseQualityOfBrie_afterLastDay() {
        Item[] items = {new Item("Aged Brie", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void shouldNotIncreaseQualityOfBrie_toMoreThan50() {
        Item[] items = {new Item("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }
}
