package com.gildedrose;

public class Pass extends ItemWrapper {

    public Pass(Item item) {
        super(item);
    }

    public void updateQuality() {
        if (item.quality < 50) {
            item.quality++;
        }
        if (item.sellIn <= 10 && item.quality < 50) {
            item.quality++;
        }
        if (item.sellIn < 6 && item.quality < 50) {
            item.quality++;
        }
        if(item.sellIn == 0 ) {
            item.quality = 0;
        }
        item.sellIn--;
    }
}
