package com.gildedrose;

public class SmarterItem
{
    protected final Item item;

    public static final String DRY_AGED_BEEF = "Dry aged beef";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED_CAKE = "Conjured Mana Cake";
    public static final String ELIXIR = "Elixir of the Mongoose";
    public static final String VEST = "+5 Dexterity Vest";

    public static final Integer DEFAULT_MIN_QUALITY = 0;
    public static final Integer DEFAULT_MAX_QUALITY = 50;

    public static final Integer DEFAULT_QUALITY_UPDATE_DELTA = -1;
    public static final Integer DEFAULT_SELL_IN_UPDATE_DELTA = -1;

    public SmarterItem(Item item)
    {
        this.item = item;
    }

    public String getName()
    {
        return item.name;
    }

    public int getSellIn()
    {
        return item.sellIn;
    }

    protected void setSellIn(int sellIn)
    {
        item.sellIn = sellIn;
    }

    public int getQuality()
    {
        return item.quality;
    }

    public void setQuality(int quality)
    {
        item.quality = quality;
    }

    protected Integer getUpdateDelta()
    {
        return isExpired() ? DEFAULT_QUALITY_UPDATE_DELTA * 2 : DEFAULT_QUALITY_UPDATE_DELTA;
    }

    protected void updateQuality()
    {
        updateQuality(getUpdateDelta());
    }

    protected void updateQuality(int delta)
    {
        if (delta < 0) item.quality = Math.max(DEFAULT_MIN_QUALITY, item.quality + delta);
        else if (delta > 0) item.quality = Math.min(DEFAULT_MAX_QUALITY, item.quality + delta);
    }

    protected void updateSellIn()
    {
        item.sellIn += DEFAULT_SELL_IN_UPDATE_DELTA;
    }

    protected void update()
    {
        updateQuality();
        updateSellIn();
    }

    protected boolean isExpired()
    {
        return item.sellIn <= 0;
    }

    public Integer getMinQuality()
    {
        return DEFAULT_MIN_QUALITY;
    }

    public Integer getMaxQuality()
    {
        return DEFAULT_MAX_QUALITY;
    }
}
