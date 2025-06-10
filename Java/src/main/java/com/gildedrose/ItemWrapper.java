package com.gildedrose;

public abstract class ItemWrapper {

    protected Item item;

    public ItemWrapper(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item.toString();
    }

    public abstract void updateQuality();
}
