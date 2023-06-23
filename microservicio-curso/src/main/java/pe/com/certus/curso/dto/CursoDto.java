package pe.com.certus.curso.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDto {
    private Long id_curso;
    private String nombre;
    private String dia;
    private String hora_inicio;
    private String hora_fin;
    private String seccion;
    private int cupomaximo;
    private Boolean estado;
}
