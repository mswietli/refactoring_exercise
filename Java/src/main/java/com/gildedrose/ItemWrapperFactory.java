package com.gildedrose;

public abstract class ItemWrapperFactory {

    public static ItemWrapper wrapItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedBrie(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePass(item);
            case "Sulfuras, Hand of Ragnaros":
                return new Sulfuras(item);
            case "Conjured":
                return new Conjured(item);
            default:
                return new NormalItem(item);
        }
    }
}
