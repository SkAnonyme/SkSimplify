package main.java.fr.devanonyme.sksimplify.permissions;

public enum Permissions {

    global_perm("sksimplify.use")
    ;

    private String p;

    Permissions(String p) {
        this.p = p;
    }

    public String getP() {
        return p;
    }
}
