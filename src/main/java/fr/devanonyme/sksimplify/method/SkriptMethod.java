package main.java.fr.devanonyme.sksimplify.method;

import ch.njol.skript.Skript;
import main.java.fr.devanonyme.sksimplify.SkSimplify;
import main.java.fr.devanonyme.sksimplify.messages.LangFR;
import main.java.fr.devanonyme.sksimplify.util.BookCreator;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class SkriptMethod {

    private Player player;

    public SkriptMethod(Player player) {
        this.player = player;
    }

    public void add(String skriptName) {
        player.sendMessage(" ");
        String skName = skriptName;
        String skNameF = skriptName.replace("_", " ");
        if(skName.contains(".sk")) {
            player.sendMessage(LangFR.error_extension.getM());
            return;
        } else {
            player.sendMessage(LangFR.file_creation.getM().replace("%skript%", skriptName));
            File file = new File(Skript.getInstance().getDataFolder(), "scripts/" + skNameF + ".sk");
            if(file.exists()) {
                player.sendMessage(LangFR.file_exist.getM());
                player.sendMessage(" ");
                return;
            }
            try {
                SkSimplify.getInstance().getConfig().save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            player.sendMessage(LangFR.skript_created.getM());
            player.sendMessage(" ");
            return;
        }
    }

    public void remove(String skriptName) {
        player.sendMessage(" ");
        String skName = skriptName;
        String skNameF = skriptName.replace("_", " ");
        if(skName.contains(".sk")) {
            player.sendMessage(LangFR.error_extension.getM());
            return;
        } else {
            player.sendMessage(LangFR.file_delete.getM().replace("%skript%", skriptName));
            File file = new File(Skript.getInstance().getDataFolder(), "scripts/" + skNameF + ".sk");
            if(!file.exists()) {
                player.sendMessage(LangFR.file_not_exist.getM());
                player.sendMessage(" ");
                return;
            }
            file.delete();
            player.performCommand("sk reload all");
            player.sendMessage(LangFR.skript_deleted.getM());
        }
        player.sendMessage(" ");
        return;
    }

    public void book(String skriptName) {
        player.sendMessage(" ");
        String skName = skriptName;
        String skNameF = skriptName.replace("_", " ");
        if(skName.contains(".sk")) {
            player.sendMessage(LangFR.error_extension.getM());
            return;
        } else {
            player.sendMessage(LangFR.book_creation.getM());
            File file = new File(Skript.getInstance().getDataFolder(), "scripts/" + skNameF + ".sk");
            if(!file.exists()) {
                player.sendMessage(LangFR.file_not_exist.getM());
                player.sendMessage(" ");
                return;
            }
            player.getInventory().addItem(new BookCreator().init(skriptName).build());
            player.sendMessage(LangFR.book_created.getM());
        }
        player.sendMessage(" ");
    }

}
