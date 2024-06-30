package com.gildedrose;

public class Sulfuras extends SmarterItem
{
    public Sulfuras(Item item)
    {
        super(item);
    }

    @Override
    public Integer getMaxQuality()
    {
        return 80;
    }

    @Override
    protected void updateQuality()
    {
        // empty implementation
    }

    @Override
    protected void updateSellIn()
    {
        // empty implementation
    }
}
