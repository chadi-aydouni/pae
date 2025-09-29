package g43729.webg5.pae.model;

public enum Section {
    GESTION("Gestion"),
    INDUSTRIELLE("Industrielle"),
    RESEAU("Réseau");

    private final String displayValue;
    
    private Section(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}
