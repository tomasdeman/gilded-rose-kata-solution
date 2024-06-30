package com.gildedrose;

public class SmarterItemFactory
{
    public static SmarterItem create(Item item)
    {
        if (SmarterItem.AGED_BRIE.equals(item.name)) return new AgedBrie(item);
        if (SmarterItem.BACKSTAGE_PASSES_TAFKAL80ETC.equals(item.name)) return new BackstagePass(item);
        if (SmarterItem.SULFURAS.equals(item.name)) return new Sulfuras(item);
        if (SmarterItem.CONJURED_CAKE.equals(item.name)) return new ConjuredCake(item);

        return new SmarterItem(item);
    }

}
