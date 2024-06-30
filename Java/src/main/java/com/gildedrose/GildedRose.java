package com.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;

class GildedRose
{
    Item[] items;
    ArrayList<SmarterItem> smartItemList = null;

    public GildedRose(Item[] items)
    {
        this.items = items;

        initSmartItemList();
    }

    private void initSmartItemList()
    {
        if (items == null) return;

        for (Item item : items)
        {
            if (smartItemList == null) smartItemList = new ArrayList<>();

            smartItemList.add(SmarterItemFactory.create(item));
        }
    }

    public void updateItems()
    {
        if (smartItemList != null) smartItemList.forEach(SmarterItem::update);
    }

    public Item getItemByName(String name)
    {
        if (items == null) return null;

        return Arrays.stream(items).filter(item -> item.name.equals(name)).findFirst().orElse(null);
    }

    public SmarterItem getSmarterItemByName(String name)
    {
        if (smartItemList == null) return null;

        return smartItemList.stream().filter(item -> item.getName().equals(name)).findFirst().orElse(null);
    }
}
