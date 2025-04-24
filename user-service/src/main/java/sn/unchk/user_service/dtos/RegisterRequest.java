package sn.unchk.user_service.dtos;

import lombok.*;
import sn.unchk.user_service.enums.Role;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder @ToString
public class RegisterRequest {
    private String nom;
    private String email;
    private String motDePasse;
    private Role role;
}
