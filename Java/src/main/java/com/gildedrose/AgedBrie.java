package com.gildedrose;

public class AgedBrie extends SmarterItem
{
    public AgedBrie(Item item)
    {
        super(item);
    }

    @Override
    protected Integer getUpdateDelta()
    {
        return 1;
    }
}
