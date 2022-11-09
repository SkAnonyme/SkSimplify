package main.java.fr.devanonyme.sksimplify.listener;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptCommand;
import ch.njol.skript.SkriptConfig;
import main.java.fr.devanonyme.sksimplify.method.SkriptMethod;
import main.java.fr.devanonyme.sksimplify.util.ItemConstructor;
import main.java.fr.devanonyme.sksimplify.util.enums.ItemData;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class PlayerListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(event.getItem() == null) return;
        if(event.getItem().getItemMeta() == null) return;
        if(event.getItem().getItemMeta().getDisplayName() == null) return;

        String getName = event.getItem().getItemMeta().getDisplayName();
        String fName = "null";

        for(File file : new File(Skript.getInstance().getDataFolder().getAbsolutePath() + File.separator + "scripts").listFiles(((dir, name) -> name.endsWith(".sk")))) {
            String fileN = file.getName().substring(0, file.getName().length() - 3);
            fName = fileN;
        }

        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            switch (event.getItem().getType()) {
                case BOOK:
                    if(getName.equalsIgnoreCase(getName)) {
                        Inventory inv = Bukkit.createInventory(player, 9*3, getName);

                        inv.setItem(0, new ItemConstructor(Material.BOOK).setDisplayName("§aReload").build());
                        if(fName.startsWith("-")) {
                            inv.setItem(1, new ItemConstructor(Material.WOOL, 1, ItemData.LIGHT_GREEN).setDisplayName("§aActivé le skript").setLore("§fStatus: §cdisable").build());
                        } else {
                            inv.setItem(1, new ItemConstructor(Material.WOOL, 1, ItemData.RED).setDisplayName("§cDésactivé le skript").setLore("§fStatus: §aenable").build());
                        }
                        inv.setItem(8, new ItemConstructor(Material.LAVA_BUCKET).setDisplayName("§cSupprimer").build());
                        inv.setItem(22, new ItemConstructor(Material.BARRIER).setDisplayName("§cFermer").build());

                        player.openInventory(inv);
                    }
                    break;
                default: break;
            }
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if(event.getCurrentItem() == null) return;
        if(event.getCurrentItem().getItemMeta() == null) return;
        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        String getName = event.getCurrentItem().getItemMeta().getDisplayName();
        String getIname = player.getInventory().getItemInHand().getItemMeta().getDisplayName();
        SkriptMethod skMethod = new SkriptMethod(player);

        if(event.getView().getTitle().equalsIgnoreCase(getIname)) {
            if(event.getClick() == ClickType.LEFT) {
                event.setCancelled(true);
                switch (event.getCurrentItem().getType()) {
                    case WOOL:
                        if(getName.equals("§cDésactivé le skript")) {
                            player.performCommand("sk disable " + getIname);
                            player.closeInventory();
                            return;
                        }
                        if(getName.equals("§aActivé le skript")) {
                            player.performCommand("sk enable " + getIname);
                            player.closeInventory();
                            return;
                        }
                        break;
                    case BOOK:
                        if(getName.equals("§aReload")) {
                            player.performCommand("sk reload " + getIname);
                            player.closeInventory();
                        }
                        break;
                    case LAVA_BUCKET:
                        if(getName.equals("§cSupprimer")) {
                            skMethod.remove(getIname.replace(".sk", ""));
                            player.closeInventory();
                            player.getInventory().setItemInHand(new ItemConstructor(Material.AIR).build());
                        }
                        break;
                    case BARRIER:
                        if(getName.equals("§cFermer")) player.closeInventory();
                        break;
                    default: break;
                }
            }
        }
    }

}
