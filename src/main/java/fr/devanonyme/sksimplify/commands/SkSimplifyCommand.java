package main.java.fr.devanonyme.sksimplify.commands;

import main.java.fr.devanonyme.sksimplify.SkSimplify;
import main.java.fr.devanonyme.sksimplify.messages.LangEN;
import main.java.fr.devanonyme.sksimplify.messages.LangFR;
import main.java.fr.devanonyme.sksimplify.method.SkriptMethod;
import main.java.fr.devanonyme.sksimplify.permissions.Permissions;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SkSimplifyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            if(SkSimplify.getLang().equals("fr")) Bukkit.getConsoleSender().sendMessage(LangFR.console_msg.getM());
            if(SkSimplify.getLang().equals("en")) Bukkit.getConsoleSender().sendMessage(LangEN.console_msg.getM());
            return false;
        }

        Player player = (Player) sender;

        if(player.hasPermission(Permissions.global_perm.getP())) {
            SkriptMethod skmethod = new SkriptMethod(player);

            if(args.length == 0) {
                String plName = SkSimplify.getInstance().getDescription().getName();
                String plVer = SkSimplify.getInstance().getDescription().getVersion();
                List<String> plAut = SkSimplify.getInstance().getDescription().getAuthors();

                player.sendMessage(" ");
                player.sendMessage("§a" + plName + "§f, v§a" + plVer + "§f, §a" + plAut);
                if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.help_message.getM());
                if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.help_message.getM());
                player.sendMessage(" ");
                return false;
            }

            if(args.length == 1) {
                help(player);
                return false;
            }

            if(args.length == 3) {
                help(player);
                return false;
            }

            if(args.length == 2) {
                if (args[0].equalsIgnoreCase("help")) {
                    help(player);
                    return false;
                }

                String skriptName = args[1];

                if (args[0].equalsIgnoreCase("add")) {
                    if (skriptName != null) {
                        skmethod.add(skriptName);
                        return false;
                    }
                }
                if (args[0].equalsIgnoreCase("remove")) {
                    if (skriptName != null) {
                        skmethod.remove(skriptName);
                        return false;
                    }
                }
                if (args[0].equalsIgnoreCase("book")) {
                    if (skriptName != null) {
                        skmethod.book(skriptName);
                        return false;
                    }
                }

                if ((!args[0].equalsIgnoreCase("help")) || (!args[0].equalsIgnoreCase("add")) || (!args[0].equalsIgnoreCase("remove")) || (!args[0].equalsIgnoreCase("book"))) {
                    help(player);
                    return false;
                }
            }
        } else {
            if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.no_permission.getM());
            if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.no_permission.getM());
        }

        return false;
    }

    private void help(Player player) {
        player.sendMessage("");
        if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.help_1.getM());
        if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.help_2.getM());
        if(SkSimplify.getLang().equals("fr")) player.sendMessage(LangFR.help_3.getM());

        if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.help_1.getM());
        if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.help_2.getM());
        if(SkSimplify.getLang().equals("en")) player.sendMessage(LangEN.help_3.getM());
        player.sendMessage("");
    }
}
