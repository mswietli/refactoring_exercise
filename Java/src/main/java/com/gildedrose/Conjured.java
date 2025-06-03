package com.gildedrose;

public class Conjured extends ItemWrapper {

    public Conjured(Item item) {
        super(item);
    }

    public void updateQuality() {
        if (item.quality > 1) {
            item.quality -= 2;
        } else {
            item.quality = 0;
        }
        item.sellIn--;

        if (item.sellIn < 0) {
            if( item.quality > 1) {
                item.quality -= 2;
            } else {
                item.quality = 0;
            }
        }
    }
}
