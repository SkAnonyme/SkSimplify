package main.java.fr.devanonyme.sksimplify.util;

import main.java.fr.devanonyme.sksimplify.util.enums.ItemData;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemConstructor {

    private ItemStack i;

    public ItemConstructor(Material material, int amount, ItemData data) {
        i = new ItemStack(material, amount, data.getData());
    }

    public ItemConstructor(Material material, int amount) {
        i = new ItemStack(material, amount);
    }

    public ItemConstructor(Material material) {
        i = new ItemStack(material);
    }

    public ItemConstructor setDisplayName(String displayName) {
        ItemMeta m = i.getItemMeta();
        m.setDisplayName(displayName);
        i.setItemMeta(m);
        return this;
    }

    public ItemConstructor setLore(String... lore) {
        ItemMeta m = i.getItemMeta();
        m.setLore(Arrays.asList(lore));
        i.setItemMeta(m);
        return this;
    }

    public ItemConstructor addItemFlag(ItemFlag itemFlag) {
        ItemMeta m = i.getItemMeta();
        m.addItemFlags(itemFlag);
        i.setItemMeta(m);
        return this;
    }

    public ItemStack build() {
        return i;
    }
}
