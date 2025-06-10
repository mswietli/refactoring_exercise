package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;
    List<ItemWrapper> itemWrappers;

    public GildedRose(Item[] items) {
        this.itemWrappers = Arrays.stream(items).map(ItemWrapperFactory::wrapItem).toList();
        this.items = items;
    }

    public void updateQuality() {
        for (ItemWrapper item : itemWrappers) {
            item.updateQuality();
        }
    }
}
