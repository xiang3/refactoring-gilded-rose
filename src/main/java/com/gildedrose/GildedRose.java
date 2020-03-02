package com.gildedrose;

import java.util.Arrays;

public class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";

    private static final String BACKSTAGE_PASSES_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    private static final String HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private static final Integer QUALITY_FIFTY = 50;

    private static final Integer SELL_IN_SIX = 6;

    private static final Integer SELL_IN_ELEVEN = 11;

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        Arrays.stream(items).forEach( item -> {
            if (!item.getName().equals(AGED_BRIE)
                    && !item.getName().equals(BACKSTAGE_PASSES_CONCERT)
                    && !item.getName().equals(HAND_OF_RAGNAROS)
                    && item.getQuality()> 0) {
                item.setQuality(item.getQuality()-1);
            }else if(item.getQuality()< QUALITY_FIFTY){
                item.setQuality(item.getQuality()+1);
                if (item.getName().equals(BACKSTAGE_PASSES_CONCERT) && (item.getSellIn()< SELL_IN_ELEVEN || item.getSellIn()< SELL_IN_SIX)) {
                    item.setQuality(item.getQuality()+1);
                }
            }

            if (!item.getName().equals(HAND_OF_RAGNAROS)) {
                item.setSellIn(item.getSellIn()-1);
            }

            if (item.getSellIn() < 0) {
                if (!item.getName().equals(AGED_BRIE)
                        && !item.getName().equals(BACKSTAGE_PASSES_CONCERT)
                        && !item.getName().equals(HAND_OF_RAGNAROS)
                        && item.getQuality()> 0) {
                    item.setQuality(item.getQuality()-1);
                } else if (!item.getName().equals(AGED_BRIE)) {
                    item.setQuality(0);
                } else if (item.getQuality()< QUALITY_FIFTY) {
                    item.setQuality(item.getQuality());
                }
            }
        });
    }
}
