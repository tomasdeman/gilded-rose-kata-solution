package com.gildedrose;

public class ConjuredCake extends SmarterItem
{
    public ConjuredCake(Item item)
    {
        super(item);
    }

    @Override
    protected Integer getUpdateDelta()
    {
        return super.getUpdateDelta() * 2;
    }
}
