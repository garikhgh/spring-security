package am.hgh.springsecurity.domain;

import am.hgh.springsecurity.security.EncriptionAlgorithm;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String authority;

    @Enumerated(EnumType.STRING)
    private EncriptionAlgorithm algorithm;
}
