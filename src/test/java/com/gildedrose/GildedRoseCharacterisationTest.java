package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseCharacterisationTest {

    @Test
    void shouldMatchThirtyDaysOfTexttestOutput() throws IOException {
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)
        };
        GildedRose app = new GildedRose(items);
        StringBuilder output = new StringBuilder("OMGHAI!\n");

        for (int day = 0; day <= 30; day++) {
            output.append("-------- day ").append(day).append(" --------\n");
            output.append("name, sellIn, quality\n");
            for (Item item : items) {
                output.append(item).append('\n');
            }
            output.append('\n');
            app.updateQuality();
        }

        String expected = Files.readString(Path.of("texttests", "ThirtyDays", "stdout.gr"));
        assertEquals(expected, output.toString());
    }
}
