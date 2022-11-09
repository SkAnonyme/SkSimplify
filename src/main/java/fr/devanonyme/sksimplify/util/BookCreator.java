package main.java.fr.devanonyme.sksimplify.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BookCreator {

    private ItemStack b;

    public BookCreator() {
        b = new ItemStack(Material.BOOK);
    }

    public BookCreator init(String skriptName) {
        ItemMeta m = b.getItemMeta();
        m.setDisplayName(skriptName + ".sk");
        b.setItemMeta(m);
        return this;
    }

    public ItemStack build() {
        return b;
    }

}
