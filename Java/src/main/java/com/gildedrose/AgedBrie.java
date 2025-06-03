package com.gildedrose;

public class AgedBrie extends ItemWrapper {

    public AgedBrie(Item item) {
        super(item);
    }

    public void updateQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
        if (item.sellIn <= 0 && item.quality < 50) {
            item.quality++;
        }
        item.sellIn--;
    }
}
