package api.prueba.brasilia.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Tarea")
@Data
@Getter
@Setter
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Titulo;
    private String Descripcion;
    private boolean Completa;

    @ManyToOne
    @JoinColumn(name = "UsuarioId", foreignKey = @ForeignKey(name = "FK_TAREA_USUARIO"))
    private Usuario Usuario;
}
