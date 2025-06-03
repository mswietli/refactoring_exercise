package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassTest {

    @ParameterizedTest(name = "{index} - Update pass quality for sellIn: {0} and quality: {1}, expectedQuality: {2}")
    @MethodSource("provideArgsForPassTests")
    void shouldUpdatePassQuality(int sellIn, int quality, int expectedQuality) {
        Pass wrapper = new Pass(new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality));
        wrapper.updateQuality();
        assertEquals(sellIn - 1, wrapper.item.sellIn);
        assertEquals(expectedQuality, wrapper.item.quality);
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
