package main.java.fr.devanonyme.sksimplify.messages;

public enum LangFR {

    console_msg("§cCette commande n'est executable qu'en jeu."),

    help_message("§f/sks §ahelp §fpour plus d'informations."),

    help_1("§f/sks §aadd <name> §8| §fCrée un nouveau fichier skript."),
    help_2("§f/sks §cremove <name> §8| §fSupprime un fichier skript."),
    help_3("§f/sks §ebook <name> §8| §fPasse un livre pour manipuler le skript."),

    no_permission("§cVous n'avez pas la permission d'exécuter cette commande."),

    error_extension("§cL'extension \".sk\" est déjà mis par défaut."),

    file_creation("§aCréation du skript: §f%skript%.sk"),
    file_delete("§aSuppression du skript: §f%skript%.sk"),
    file_exist("§cCe skript est déjà existant !"),
    file_not_exist("§cCe skript est n'existe pas !"),

    skript_created("§aSkript crée"),
    skript_deleted("§aSkript supprimé."),

    book_creation("§aCréation du livre de manipulation."),
    book_created("§aLivre crée !"),
    ;

    private String m;

    LangFR(String m) {
        this.m = m;
    }

    public String getM() {
        return m.replace("&", "§");
    }
}
