package com.gildedrose;

public class BackstagePass extends SmarterItem
{
    public BackstagePass(Item item)
    {
        super(item);
    }

    @Override
    protected void updateQuality()
    {
        if (isExpired())
        {
            setQuality(0);
        }
        else if (getSellIn() <= 5)
        {
            updateQuality(3);
        }
        else if (getSellIn() <= 10)
        {
            updateQuality(2);
        }
        else
        {
            updateQuality(1);
        }

    }
}
