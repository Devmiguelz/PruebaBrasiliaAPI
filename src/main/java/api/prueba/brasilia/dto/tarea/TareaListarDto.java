package api.prueba.brasilia.dto.tarea;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TareaListarDto {
    private Long Id;
    private String Titulo;
    private String Descripcion;
    private boolean Completa;
    private Date CreatedAt;
    private Date UpdatedAt;
}
