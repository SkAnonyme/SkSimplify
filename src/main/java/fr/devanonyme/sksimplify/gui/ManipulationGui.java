package main.java.fr.devanonyme.sksimplify.gui;

import ch.njol.skript.Skript;
import main.java.fr.devanonyme.sksimplify.SkSimplify;
import main.java.fr.devanonyme.sksimplify.util.ItemConstructor;
import main.java.fr.devanonyme.sksimplify.util.enums.ItemData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ManipulationGui {

    private Player player;
    private String fName = null;

    public ManipulationGui(Player player) {
        this.player = player;
    }

    public void g() {
        String getName = player.getItemInHand().getItemMeta().getDisplayName();

        Inventory inv = Bukkit.createInventory(player, 9*3, getName);

        inv.setItem(0, new ItemConstructor(Material.BOOK).setDisplayName("§aReload").build());
        if (getName.startsWith("-")) {
            if(SkSimplify.getLang().equals("fr")) inv.setItem(1, new ItemConstructor(Material.WOOL, 1, ItemData.LIGHT_GREEN).setDisplayName("§aActivé le skript").setLore("§fStatus: §cdisable").build());
            if(SkSimplify.getLang().equals("en")) inv.setItem(1, new ItemConstructor(Material.WOOL, 1, ItemData.LIGHT_GREEN).setDisplayName("§aActivated the skript").setLore("§fStatus: §cdisable").build());
        } else {
            if(SkSimplify.getLang().equals("fr")) inv.setItem(1, new ItemConstructor(Material.WOOL, 1, ItemData.RED).setDisplayName("§cDésactivé le skript").setLore("§fStatus: §aenable").build());
            if(SkSimplify.getLang().equals("en")) inv.setItem(1, new ItemConstructor(Material.WOOL, 1, ItemData.RED).setDisplayName("§cDisabled the skript").setLore("§fStatus: §aenable").build());
        }
        if(SkSimplify.getLang().equals("fr")) inv.setItem(8, new ItemConstructor(Material.LAVA_BUCKET).setDisplayName("§cSupprimer").setLore("§7Cette option reload tous les skripts.").build());
        if(SkSimplify.getLang().equals("en")) inv.setItem(8, new ItemConstructor(Material.LAVA_BUCKET).setDisplayName("§cTo delete").setLore("§7This option reloads all skripts.").build());
        if(SkSimplify.getLang().equals("fr")) inv.setItem(22, new ItemConstructor(Material.BARRIER).setDisplayName("§cFermer").build());
        if(SkSimplify.getLang().equals("en")) inv.setItem(22, new ItemConstructor(Material.BARRIER).setDisplayName("§cClose").build());

        //inv.setItem(26, new ItemConstructor(Material.PAPER).setDisplayName("§6Debug").setLore("fName: " + fName).build());

        player.openInventory(inv);
    }

}
