package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";

    private static final String BACKSTAGE_PASSES_CONCERT = "Backstage passes to a TAFKAL80ETC concert";

    private static final String HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";

    private static final Integer QUALITY_FIFTY = 50;

    private static final Integer SELL_IN_SIX = 6;

    private static final Integer SELL_IN_ELEVEN = 11;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void update_quality() {
        Arrays.stream(items).forEach( item -> {
            if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE_PASSES_CONCERT)
                && item.quality > 0
                && (!item.name.equals(HAND_OF_RAGNAROS))) {
                    item.quality--;
            }else if(item.quality < QUALITY_FIFTY){
                    item.quality++;
                if (item.name.equals(BACKSTAGE_PASSES_CONCERT)
                        && (item.sell_in < SELL_IN_ELEVEN && item.quality < QUALITY_FIFTY
                        || item.sell_in < SELL_IN_SIX && item.quality < QUALITY_FIFTY)) {
                    item.quality++;
                }
            }

            if (!item.name.equals(HAND_OF_RAGNAROS)) {
                item.sell_in--;
            }

            if (item.sell_in < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (item.name.equals(BACKSTAGE_PASSES_CONCERT)) {
                        item.quality = 0;
                    } else if (item.quality > 0 && !item.name.equals(HAND_OF_RAGNAROS)) {
                        item.quality--;
                    }
                } else if (item.quality < QUALITY_FIFTY) {
                    item.quality++;
                }
            }
        });
    }
}
