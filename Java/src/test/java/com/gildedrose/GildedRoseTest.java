package com.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Nested
    class NormalItem {
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


    @Nested
    class Brie {
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

    @Nested
    class Sulfuras {

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

    @Nested
    class Pass {

        @ParameterizedTest(name = "{index} - Update pass quality for sellIn: {0} and quality: {1}, expectedQuality: {2}")
        @MethodSource("provideArgsForPassTests")
        void shouldUpdatePassQuality(int sellIn, int quality, int expectedQuality) {
            Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality)};
            GildedRose app = new GildedRose(items);
            app.updateQuality();
            assertEquals(sellIn - 1, app.items[0].sellIn);
            assertEquals(expectedQuality, app.items[0].quality);
        }

        private static Stream<Arguments> provideArgsForPassTests() {
            return Stream.of(
                Arguments.of(11, 5, 6),
                Arguments.of(10, 5, 7),
                Arguments.of(6, 5, 7),
                Arguments.of(5, 5, 8),
                Arguments.of(1, 5, 8),
                Arguments.of(0, 5, 0)
            );
        }
    }

    @Nested
    class Conjured {

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
}
