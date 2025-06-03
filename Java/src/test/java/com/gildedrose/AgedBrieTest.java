package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieTest {

    @Test
    void shouldIncreaseQualityOfBrie() {
        AgedBrie wrapper = new AgedBrie(new Item("Aged Brie", 10, 5));
        wrapper.updateQuality();
        assertEquals(9, wrapper.item.sellIn);
        assertEquals(6, wrapper.item.quality);
    }

    @Test
    void shouldIncreaseQualityOfBrie_afterLastDay() {
        AgedBrie wrapper = new AgedBrie(new Item("Aged Brie", 0, 10));
        wrapper.updateQuality();
        assertEquals(-1, wrapper.item.sellIn);
        assertEquals(12, wrapper.item.quality);
    }

    @Test
    void shouldNotIncreaseQualityOfBrie_toMoreThan50() {
        AgedBrie wrapper = new AgedBrie(new Item("Aged Brie", 5, 50));
        wrapper.updateQuality();
        assertEquals(4, wrapper.item.sellIn);
        assertEquals(50, wrapper.item.quality);
    }
}
