package pe.com.certus.curso.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.certus.curso.dto.CursoDto;
import pe.com.certus.curso.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @ApiOperation(value = "METODO PARA LISTAR TODOS LOS CURSOS")
    @GetMapping
    public ResponseEntity<?> mostrartodoslosCursos() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getAllCurso());
    }

    @ApiOperation(value = "METODO PARA LISTAR TODOS LOS CURSOS QUE TENGAN UN ESTADO TRUE")
    @GetMapping("/estadotrue")
    public ResponseEntity<?> mostrartodoslosCursosconEstadoTrue() {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getAllCursoEstadoTrue(true));
    }
    
    @ApiOperation(value = "METODO PARA OBTENER UN CURSO POR SU ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> mostrarunCurso(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getCurso(id));
    }
    
    @ApiOperation(value = "METODO PARA CREAR UN NUEVO CURSO")
    @PostMapping("/add")
    public ResponseEntity<?> crearCurso(@RequestBody CursoDto curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.createCurso(curso));
    }

    @ApiOperation(value = "METODO PARA ACTUALIZAR UN CURSO EXISTENTE")
    @PutMapping("/update")
    public ResponseEntity<?> actualizarCurso(@RequestBody CursoDto curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.updateCurso(curso));
    }
    
    @ApiOperation(value = "METODO PARA ELIMINAR UN CURSO (SOLO CAMBIA EL ESTADO POR FALSE)")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> borrarunCurso(@PathVariable("id") Long id) {
        cursoService.deleteCurso(id);
        return null;
    }
}
