package main.java.fr.devanonyme.sksimplify.listener;

import main.java.fr.devanonyme.sksimplify.gui.ManipulationGui;
import main.java.fr.devanonyme.sksimplify.method.SkriptMethod;
import main.java.fr.devanonyme.sksimplify.permissions.Permissions;
import main.java.fr.devanonyme.sksimplify.util.BookCreator;
import main.java.fr.devanonyme.sksimplify.util.ItemConstructor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(event.getItem() == null) return;
        if(event.getItem().getItemMeta() == null) return;
        if(event.getItem().getItemMeta().getDisplayName() == null) return;

        String getName = event.getItem().getItemMeta().getDisplayName();

        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            switch (event.getItem().getType()) {
                case BOOK:
                    if(player.hasPermission(Permissions.global_perm.getP())) {
                        if (getName.equalsIgnoreCase(getName)) {
                            ManipulationGui manipulationGui = new ManipulationGui(player);
                            manipulationGui.g();
                        }
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
        if(player.getItemInHand() == null) return;
        if(player.getItemInHand().getItemMeta() == null) return;
        if(player.getItemInHand().getItemMeta().getDisplayName() == null) return;

        String getName = event.getCurrentItem().getItemMeta().getDisplayName();
        SkriptMethod skMethod = new SkriptMethod(player);
        String getIname = player.getInventory().getItemInHand().getItemMeta().getDisplayName();

        if(event.getView().getTitle().equalsIgnoreCase(getIname)) {
            if(event.getClick() == ClickType.LEFT) {
                event.setCancelled(true);
                switch (event.getCurrentItem().getType()) {
                    case WOOL:
                        if(getName.equals("§cDésactivé le skript") || getName.equals("§cDisabled the skript")) {
                            player.performCommand("sk disable " + getIname);
                            player.closeInventory();
                            String getV = getIname.replace(".sk", "");
                            player.setItemInHand(new BookCreator().init("-" + getV).build());
                            return;
                        }
                        if(getName.equals("§aActivé le skript") || getName.equals("§aActivated the skript")) {
                            player.performCommand("sk enable " + getIname);
                            player.closeInventory();
                            String getV = getIname.replace("-", "").replace(".sk", "");
                            player.setItemInHand(new BookCreator().init(getV).build());
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
                        if(getName.equals("§cSupprimer") || getName.equals("§cTo delete")) {
                            skMethod.remove(getIname.replace(".sk", ""));
                            player.closeInventory();
                            player.getInventory().setItemInHand(new ItemConstructor(Material.AIR).build());
                        }
                        break;
                    case BARRIER:
                        if(getName.equals("§cFermer") || getName.equals("§cClose")) player.closeInventory();
                        break;
                    default: break;
                }
            }
        }
    }

}
