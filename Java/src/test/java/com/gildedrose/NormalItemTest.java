package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NormalItemTest {

    @Test
    void shouldUpdateNormalItem() {
        NormalItem wrapper = new NormalItem(new Item("foo", 10, 5));
        wrapper.updateQuality();
        assertEquals("foo", wrapper.item.name);
        assertEquals(9, wrapper.item.sellIn);
        assertEquals(4, wrapper.item.quality);
    }

    @Test
    void shouldUpdateNormalItem_afterLastDay() {
        NormalItem wrapper = new NormalItem(new Item("foo", 0, 5));
        wrapper.updateQuality();
        assertEquals(-1, wrapper.item.sellIn);
        assertEquals(3, wrapper.item.quality);
    }

    @Test
    void shouldNotUpdateNormalItem_toNegative() {
        NormalItem wrapper = new NormalItem(new Item("foo", 5, 0));
        wrapper.updateQuality();
        assertEquals(4, wrapper.item.sellIn);
        assertEquals(0, wrapper.item.quality);
    }

    @Test
    void shouldNotUpdateNormalItem_toNegative_afterLastDay() {
        NormalItem wrapper = new NormalItem(new Item("foo", 0, 0));
        wrapper.updateQuality();
        assertEquals(-1, wrapper.item.sellIn);
        assertEquals(0, wrapper.item.quality);
    }
}
