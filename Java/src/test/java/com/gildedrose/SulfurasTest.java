package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SulfurasTest {

    @Test
    void shouldNotUpdateQualityOfSulfuras() {
        Sulfuras wrapper = new Sulfuras(new Item("Sulfuras, Hand of Ragnaros", 10, 5));
        wrapper.updateQuality();
        assertEquals(10, wrapper.item.sellIn);
        assertEquals(5, wrapper.item.quality);
    }

    @Test
    void shouldNotUpdateQualityOfSulfuras_afterLastDay() {
        Sulfuras wrapper = new Sulfuras(new Item("Sulfuras, Hand of Ragnaros", 0, 10));
        wrapper.updateQuality();
        assertEquals(0, wrapper.item.sellIn);
        assertEquals(10, wrapper.item.quality);
    }
}
