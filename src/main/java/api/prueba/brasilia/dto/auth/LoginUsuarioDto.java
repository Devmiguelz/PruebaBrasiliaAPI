package api.prueba.brasilia.dto.auth;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUsuarioDto {
    private String Token;
}
