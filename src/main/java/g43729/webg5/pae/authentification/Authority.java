package g43729.webg5.pae.authentification;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Authorities
 */
@Entity
public class Authority {

    @Id
    private long id;
    private String username;
    private String authority;

    // ==================== Constructeurs ====================

    /** Constructeur vide nécessaire pour JPA */
    public Authority() {
    }

    /** Constructeur complet */
    public Authority(long id, String username, String authority) {
        this.id = id;
        this.username = username;
        this.authority = authority;
    }

    // ==================== Getters / Setters ====================

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    // ==================== toString ====================

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", authority='" + authority + '\'' +
                '}';
    }
}
