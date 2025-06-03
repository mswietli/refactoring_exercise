package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConjuredTest {

    @Test
    void shouldUpdateConjuredItem() {
        Conjured wrapper = new Conjured(new Item("Conjured", 10, 5));
        wrapper.updateQuality();
        assertEquals(9, wrapper.item.sellIn);
        assertEquals(3, wrapper.item.quality);
    }

    @Test
    void shouldUpdateConjuredItem_afterLastDay() {
        Conjured wrapper = new Conjured(new Item("Conjured", 0, 5));
        wrapper.updateQuality();
        assertEquals(-1, wrapper.item.sellIn);
        assertEquals(1, wrapper.item.quality);
    }

    @Test
    void shouldNotUpdateConjuredItem_toNegative() {
        Conjured wrapper = new Conjured(new Item("Conjured", 5, 1));
        wrapper.updateQuality();
        assertEquals(4, wrapper.item.sellIn);
        assertEquals(0, wrapper.item.quality);
    }
}
