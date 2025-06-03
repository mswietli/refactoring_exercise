package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasTest {

    @Test
    void shouldNotUpdateQualityOfSulfuras() {
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", 10, 5)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(5, app.items[0].quality);
    }

    @Test
    void shouldNotUpdateQualityOfSulfuras_afterLastDay() {
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
    }
}
