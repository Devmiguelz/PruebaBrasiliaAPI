package api.prueba.brasilia.dto.usuario;

import api.prueba.brasilia.dto.tarea.TareaListarDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UsuarioListarDto {
    private Long Id;
    private String NombreUsuario;
    private List<TareaListarDto> Tareas = new ArrayList<>();
}
