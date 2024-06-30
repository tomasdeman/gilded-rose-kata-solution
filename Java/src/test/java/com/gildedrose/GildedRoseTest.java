package com.gildedrose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest
{

    @Test
    void normalItemSellInAndQuality()
    {
        int initialSellIn = 20;
        int initialQuality = 20;

        Item normalItem = new ItemBuilder().withName(SmarterItem.DRY_AGED_BEEF).withSellIn(initialSellIn).withQuality(initialQuality).build();

        Item[] items = new Item[]{normalItem};

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateItems();


        int expectedSellIn = initialSellIn - 1;
        int expectedQuality = Math.max(initialQuality - 1, SmarterItem.DEFAULT_MIN_QUALITY);

        int actualSellIn = normalItem.sellIn;
        int actualQuality = normalItem.quality;

        assertEquals(expectedSellIn, actualSellIn);
        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void normalItemPastExpirationDateDoubleQualityDecrease()
    {
        int initialSellIn = 0;
        int initialQuality = 20;

        Item normalItem = new ItemBuilder().withName(SmarterItem.DRY_AGED_BEEF).withSellIn(initialSellIn).withQuality(initialQuality).build();

        Item[] items = new Item[]{normalItem};

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateItems();


        int expectedSellIn = initialSellIn - 1;
        int expectedQuality = Math.max(initialQuality - 2, SmarterItem.DEFAULT_MIN_QUALITY);

        int actualSellIn = normalItem.sellIn;
        int actualQuality = normalItem.quality;

        assertEquals(expectedSellIn, actualSellIn);
        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void qualityNeverNegative()
    {
        int initialSellIn = 10;
        int initialQuality = 20;

        Item normalItem = new ItemBuilder().withName(SmarterItem.DRY_AGED_BEEF).withSellIn(initialSellIn).withQuality(initialQuality).build();

        Item[] items = new Item[]{normalItem};

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateItems();


        int expectedSellIn = initialSellIn - 1;
        int expectedQuality = Math.max(initialQuality - 1, SmarterItem.DEFAULT_MIN_QUALITY);

        int actualSellIn = normalItem.sellIn;
        int actualQuality = normalItem.quality;

        assertEquals(expectedSellIn, actualSellIn);
        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void agedBrieQualityIncrease()
    {
        int initialSellIn = 10;
        int initialQuality = 20;

        Item agedBrie = new ItemBuilder().withName(SmarterItem.AGED_BRIE).withSellIn(initialSellIn).withQuality(initialQuality).build();

        Item[] items = new Item[]{agedBrie};

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateItems();


        int expectedSellIn = initialSellIn - 1;
        int expectedQuality = initialQuality + 1;

        int actualSellIn = agedBrie.sellIn;
        int actualQuality = agedBrie.quality;

        assertEquals(expectedSellIn, actualSellIn);
        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void agedBrieQualityNeverAbove50()
    {
        int days = 100;
        int initialSellIn = 10;
        int initialQuality = 20;

        Item agedBrie = new ItemBuilder().withName(SmarterItem.AGED_BRIE).withSellIn(initialSellIn).withQuality(initialQuality).build();

        Item[] items = new Item[]{agedBrie};

        GildedRose gildedRose = new GildedRose(items);

        for (int i = 0; i < days; i++)
        {
            gildedRose.updateItems();
        }

        int actualQuality = agedBrie.quality;

        Assertions.assertFalse(actualQuality > SmarterItem.DEFAULT_MAX_QUALITY);
    }

    @Test
    void legendaryItemUnchanged()
    {
        int initialSellIn = 10;
        int initialQuality = 20;

        Item legendaryItem = new ItemBuilder().withName(SmarterItem.SULFURAS).withSellIn(initialSellIn).withQuality(initialQuality).build();

        Item[] items = new Item[]{legendaryItem};

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateItems();

        int actualSellIn = legendaryItem.sellIn;
        int actualQuality = legendaryItem.quality;

        assertEquals(initialSellIn, actualSellIn);
        assertEquals(initialQuality, actualQuality);
    }

    @Test
    void backstagePassesQualityIncrease20DaysLeft()
    {
        int initialSellIn = 20;
        int initialQuality = 20;

        Item backstagePass = new ItemBuilder().withName(SmarterItem.BACKSTAGE_PASSES_TAFKAL80ETC).withSellIn(initialSellIn).withQuality(initialQuality).build();

        Item[] items = new Item[]{backstagePass};

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateItems();

        int expectedQuality = Math.min(initialQuality + 1, SmarterItem.DEFAULT_MAX_QUALITY);
        int actualQuality = backstagePass.quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void backstagePassesQualityIncrease10DaysLeft()
    {
        int initialSellIn = 10;
        int initialQuality = 20;

        Item backstagePass = new ItemBuilder().withName(SmarterItem.BACKSTAGE_PASSES_TAFKAL80ETC).withSellIn(initialSellIn).withQuality(initialQuality).build();

        Item[] items = new Item[]{backstagePass};

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateItems();

        int expectedQuality = Math.min(initialQuality + 2, SmarterItem.DEFAULT_MAX_QUALITY);
        int actualQuality = backstagePass.quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void backstagePassesQualityIncrease4DaysLeft()
    {
        int initialSellIn = 4;
        int initialQuality = 20;

        Item backstagePass = new ItemBuilder().withName(SmarterItem.BACKSTAGE_PASSES_TAFKAL80ETC).withSellIn(initialSellIn).withQuality(initialQuality).build();

        Item[] items = new Item[]{backstagePass};

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateItems();

        int expectedQuality = Math.min(initialQuality + 3, SmarterItem.DEFAULT_MAX_QUALITY);
        int actualQuality = backstagePass.quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void backstagePassesQualityIncrease0DaysLeft()
    {
        int initialQuality = 20;

        Item backstagePass = new ItemBuilder().withName(SmarterItem.BACKSTAGE_PASSES_TAFKAL80ETC).withSellIn(0).withQuality(initialQuality).build();

        Item[] items = new Item[]{backstagePass};

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateItems();

        int expectedQuality = 0;
        int actualQuality = backstagePass.quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void conjuredItemQuality()
    {
        int initialQuality = 20;

        Item conjuredItem = new ItemBuilder().withName(SmarterItem.CONJURED_CAKE).withSellIn(5).withQuality(initialQuality).build();

        Item[] items = new Item[]{conjuredItem};

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateItems();

        int expectedQuality = initialQuality - 2;
        int actualQuality = conjuredItem.quality;

        assertEquals(expectedQuality, actualQuality);
    }

    @Test
    void conjuredExpiredItemQuality()
    {
        int initialQuality = 20;

        Item conjuredItem = new ItemBuilder().withName(SmarterItem.CONJURED_CAKE).withSellIn(0).withQuality(initialQuality).build();

        Item[] items = new Item[]{conjuredItem};

        GildedRose gildedRose = new GildedRose(items);

        gildedRose.updateItems();

        int expectedQuality = initialQuality - 4;
        int actualQuality = conjuredItem.quality;

        assertEquals(expectedQuality, actualQuality);
    }
}
