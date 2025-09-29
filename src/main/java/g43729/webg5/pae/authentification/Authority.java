package g43729.webg5.pae.authentification;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * Authorities
 */
@Entity
@Data
public class Authority {
    @Id
    private long id;
    private String username;
    private String authority;
}
