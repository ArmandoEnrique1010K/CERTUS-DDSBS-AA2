package pe.com.certus.curso.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Table(name = "curso")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long id_curso;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dia")
    private String dia;
    @Column(name = "hora_inicio")
    private String hora_inicio;
    @Column(name = "hora_fin")
    private String hora_fin;
    @Column(name = "seccion")
    private String seccion;
    @Column(name = "cupomaximo")
    private int cupomaximo;
    @Column(name = "estado")
    private Boolean estado;
}
