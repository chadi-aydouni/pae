package g43729.webg5.pae.authentification;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * Users
 */
@Data
@Entity
public class User {
    @Id
    private String username;
    private String password;
    private boolean enabled;
}
