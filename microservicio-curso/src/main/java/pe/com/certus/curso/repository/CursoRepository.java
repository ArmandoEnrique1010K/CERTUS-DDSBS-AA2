package pe.com.certus.curso.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.certus.curso.entity.CursoEntity;

public interface CursoRepository extends JpaRepository<CursoEntity, Long>{
    
    @Query(value = "select c from CursoEntity c where c.estado = '1'")
    List<CursoEntity> getAllCursoEstadoTrue(Boolean estado);
    
}
