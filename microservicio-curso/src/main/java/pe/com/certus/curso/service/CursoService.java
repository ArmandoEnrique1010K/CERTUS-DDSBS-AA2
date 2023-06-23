package pe.com.certus.curso.service;

import java.util.List;
import pe.com.certus.curso.dto.CursoDto;

public interface CursoService {
    
    public List<CursoDto> getAllCurso();
    public List<CursoDto> getAllCursoEstadoTrue(Boolean estado);
    public CursoDto getCurso(Long id_curso);
    public CursoDto createCurso(CursoDto curso);
    public CursoDto updateCurso(CursoDto curso);
    public void deleteCurso(Long id);
}
