package com.gildedrose;

public class NormalItem extends ItemWrapper {

    public NormalItem(Item item) {
        super(item);
    }

    public void updateQuality() {
        if (item.quality > 0) {
            item.quality--;
        }
        item.sellIn--;

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}
