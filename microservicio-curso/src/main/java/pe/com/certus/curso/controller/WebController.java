package pe.com.certus.curso.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.certus.curso.entity.CursoEntity;
import pe.com.certus.curso.service.CursoService;

@Controller
@RequestMapping("/curso")
public class WebController {

    @Autowired
    private CursoService cursoService;
    
    @ApiOperation(value = "METODO PARA OBTENER EL CODIGO HTML DE LA PÁGINA 'index.html', DESPUES DE HABERSE CONSTRUIDO")
    @GetMapping("/index")
    public String inicio(Model mostrarloscursos) {
        // var cursos = cursoService.getAllCurso();
        var cursos = cursoService.getAllCursoEstadoTrue(Boolean.TRUE);
        mostrarloscursos.addAttribute("cursos", cursos);
        return "index.html";
    }
    
}
