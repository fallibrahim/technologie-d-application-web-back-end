package sn.unchk.user_service.dtos;

import lombok.*;

@AllArgsConstructor @Getter @Setter @Builder
public class AuthResponse {
    private String token;
}
