package g43729.webg5.pae.model;

public enum Gender {
    MALE("M"),
    FEMALE("F");

    private final String displayValue;
    
    private Gender(String displayValue) {
        this.displayValue = displayValue;
    }
    
    public String getDisplayValue() {
        return displayValue;
    }
}
