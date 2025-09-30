package g43729.webg5.pae.authentification;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Users
 */
@Entity
public class User {

    @Id
    private String username;
    private String password;
    private boolean enabled;

    // ==================== Constructeurs ====================

    /** Constructeur vide nécessaire pour JPA */
    public User() {
    }

    /** Constructeur complet */
    public User(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    // ==================== Getters / Setters ====================

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    // ==================== toString ====================

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
