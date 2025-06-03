package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ItemWrapperFactoryTest {

    @ParameterizedTest(name = "{index} - Update pass quality for sellIn: {0} and quality: {1}, expectedQuality: {2}")
    @MethodSource("provideArgsForTests")
    public void shouldCreateWrappersProperly(Item item, Class<ItemWrapper> expectedClass) {
        assertInstanceOf(expectedClass, ItemWrapperFactory.wrapItem(item));
    }

    private static Stream<Arguments> provideArgsForTests() {
        return Stream.of(
            Arguments.of(new Item("Normal Item", 10, 20), NormalItem.class),
            Arguments.of(new Item("Aged Brie", 5, 30), AgedBrie.class),
            Arguments.of(new Item("Sulfuras, Hand of Ragnaros", 0, 80), Sulfuras.class),
            Arguments.of(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 40), Pass.class),
            Arguments.of(new Item("Conjured", 3, 6), Conjured.class)
        );
    }

}
