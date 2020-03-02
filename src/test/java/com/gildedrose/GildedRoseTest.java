package com.gildedrose;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void should_sellIn_less_one_and_quality_less_1_when_name_is_foo_sellIn_is_one_quality_is_five() {
        Item[] items = new Item[] { new Item("foo", 1, 5) };
        GildedRose app = new GildedRose(items);
        app.update_quality();
        Assert.assertEquals("foo", app.getItems()[0].getName());
        Assert.assertEquals(0, app.getItems()[0].getSellIn());
        Assert.assertEquals(4, app.getItems()[0].getQuality());
    }

    @Test
    public void should_sellIn_less_one_and_quality_add_1_when_name_is_Aged_Brie_sellIn_is_one_quality_is_four() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 4) };
        GildedRose app = new GildedRose(items);
        app.update_quality();
        Assert.assertEquals("Aged Brie", app.getItems()[0].getName());
        Assert.assertEquals(0, app.getItems()[0].getSellIn());
        Assert.assertEquals(5, app.getItems()[0].getQuality());
    }
}
