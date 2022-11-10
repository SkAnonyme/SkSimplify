package main.java.fr.devanonyme.sksimplify.messages;

public enum LangEN {

    console_msg("§cThis command can only be executed in-game."),

    help_message("§f/sks §ahelp §ffor more information."),

    help_1("§f/sks §aadd <name> §8| §fCreate a new skript file."),
    help_2("§f/sks §cremove <name> §8| §fDelete a skript file."),
    help_3("§f/sks §ebook <name> §8| §fPass a book to manipulate the skript."),

    no_permission("§cYou do not have permission to run this command."),

    error_extension("§cThe \".sk\" extension is already set by default."),

    file_creation("§aCreation of the skript: §f%skript%.sk"),
    file_delete("§aDeleting the skript: §f%skript%.sk"),
    file_exist("§cThis skript already exists!"),
    file_not_exist("§cThis skript does not exist!"),

    skript_created("§aSkript creates."),
    skript_deleted("§aSkript deleted."),

    book_creation("§aCreation of the handling book."),
    book_created("§abook created!"),
    ;

    private String m;

    LangEN(String m) {
        this.m = m;
    }

    public String getM() {
        return m.replace("&", "§");
    }

}
