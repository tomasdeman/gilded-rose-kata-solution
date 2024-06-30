package com.gildedrose;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
                new ItemBuilder().withName(SmarterItem.VEST).withSellIn(10).withQuality(20).build(),
                new ItemBuilder().withName(SmarterItem.AGED_BRIE).withSellIn(2).withQuality(0).build(),
                new ItemBuilder().withName(SmarterItem.ELIXIR).withSellIn(5).withQuality(7).build(),
                new ItemBuilder().withName(SmarterItem.SULFURAS).withSellIn(0).withQuality(80).build(),
                new ItemBuilder().withName(SmarterItem.SULFURAS).withSellIn(-1).withQuality(80).build(),
                new ItemBuilder().withName(SmarterItem.BACKSTAGE_PASSES_TAFKAL80ETC).withSellIn(15).withQuality(20).build(),
                new ItemBuilder().withName(SmarterItem.BACKSTAGE_PASSES_TAFKAL80ETC).withSellIn(10).withQuality(49).build(),
                new ItemBuilder().withName(SmarterItem.BACKSTAGE_PASSES_TAFKAL80ETC).withSellIn(5).withQuality(49).build(),
                new ItemBuilder().withName(SmarterItem.CONJURED_CAKE).withSellIn(3).withQuality(6).build()
        };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateItems();
        }
    }

}
