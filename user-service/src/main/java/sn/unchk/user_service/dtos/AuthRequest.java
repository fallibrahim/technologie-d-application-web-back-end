package sn.unchk.user_service.dtos;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class AuthRequest {
    private String email;
    private String motDePasse;
}
