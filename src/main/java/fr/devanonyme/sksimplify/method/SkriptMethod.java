package main.java.fr.devanonyme.sksimplify.method;

import ch.njol.skript.Skript;
import main.java.fr.devanonyme.sksimplify.SkSimplify;
import main.java.fr.devanonyme.sksimplify.messages.LangEN;
import main.java.fr.devanonyme.sksimplify.messages.LangFR;
import main.java.fr.devanonyme.sksimplify.util.BookCreator;
import org.apache.commons.io.FileUtils;
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
            if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.error_extension.getM());
            if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.error_extension.getM());
            return;
        } else {
            if(SkSimplify.getLang().equals("FR")) player.sendMessage(LangFR.file_creation.getM().replace("%skript%", skriptName));
            if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.file_creation.getM().replace("%skript%", skriptName));
            File file = new File(Skript.getInstance().getDataFolder(), "scripts/" + skNameF + ".sk");
            File file2 = new File(SkSimplify.getInstance().getDataFolder(), "defaultConfig.txt");
            if(file.exists()) {
                if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.file_exist.getM());
                if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.file_exist.getM());
                player.sendMessage(" ");
                return;
            }
            try {
                FileUtils.copyFile(file2, file);
                file.getName().replace("defaultConfig.txt", skNameF + ".sk");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.skript_created.getM());
            if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.skript_created.getM());
            player.sendMessage(" ");
            return;
        }
    }

    public void remove(String skriptName) {
        player.sendMessage(" ");
        String skName = skriptName;
        String skNameF = skriptName.replace("_", " ");
        if(skName.contains(".sk")) {
            if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.error_extension.getM());
            if(SkSimplify.getLang().equals("en"))  player.sendMessage(LangEN.error_extension.getM());
            return;
        } else {
            if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.file_delete.getM().replace("%skript%", skriptName));
            if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.file_delete.getM().replace("%skript%", skriptName));
            File file = new File(Skript.getInstance().getDataFolder(), "scripts/" + skNameF + ".sk");
            if(!file.exists()) {
                if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.file_not_exist.getM());
                if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.file_not_exist.getM());
                player.sendMessage(" ");
                return;
            }
            file.delete();
            player.performCommand("sk reload all");
            if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.skript_deleted.getM());
            if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.skript_deleted.getM());
        }
        player.sendMessage(" ");
        return;
    }

    public void book(String skriptName) {
        player.sendMessage(" ");
        String skName = skriptName;
        String skNameF = skriptName.replace("_", " ");
        if(skName.contains(".sk")) {
            if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.error_extension.getM());
            if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.error_extension.getM());
            return;
        } else {
            if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.book_creation.getM());
            if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.book_creation.getM());
            File file = new File(Skript.getInstance().getDataFolder(), "scripts/" + skNameF + ".sk");
            if(!file.exists()) {
                if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.file_not_exist.getM());
                if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.file_not_exist.getM());
                player.sendMessage(" ");
                return;
            }
            player.getInventory().addItem(new BookCreator().init(skriptName).build());
            if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.book_created.getM());
            if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.book_created.getM());
        }
        player.sendMessage(" ");
    }
}
