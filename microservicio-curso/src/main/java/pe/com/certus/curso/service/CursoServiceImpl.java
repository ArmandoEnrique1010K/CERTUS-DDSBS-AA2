package pe.com.certus.curso.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.certus.curso.dto.CursoDto;
import pe.com.certus.curso.entity.CursoEntity;
import pe.com.certus.curso.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<CursoDto> getAllCurso() {
        List<CursoEntity> listCursoEntity = cursoRepository.findAll();
        List<CursoDto> list = new ArrayList<CursoDto>();
        for (CursoEntity cursoEntity : listCursoEntity) {
            list.add(CursoDto.builder()
                    .id_curso(cursoEntity.getId_curso())
                    .nombre(cursoEntity.getNombre())
                    .dia(cursoEntity.getDia())
                    .hora_inicio(cursoEntity.getHora_inicio())
                    .hora_fin(cursoEntity.getHora_fin())
                    .seccion(cursoEntity.getSeccion())
                    .cupomaximo(cursoEntity.getCupomaximo())
                    .estado(cursoEntity.getEstado())
                    .build());
        }
        return list;
    }
    
    @Override
    public List<CursoDto> getAllCursoEstadoTrue(Boolean estado) {
    List<CursoEntity> listCursoEntity = cursoRepository.getAllCursoEstadoTrue(estado);
    List<CursoDto> list = new ArrayList<>();
        for (CursoEntity cursoEntity : listCursoEntity) {
            list.add(CursoDto.builder()
                    .id_curso(cursoEntity.getId_curso())
                    .nombre(cursoEntity.getNombre())
                    .dia(cursoEntity.getDia())
                    .hora_inicio(cursoEntity.getHora_inicio())
                    .hora_fin(cursoEntity.getHora_fin())
                    .seccion(cursoEntity.getSeccion())
                    .cupomaximo(cursoEntity.getCupomaximo())
                    .estado(cursoEntity.getEstado())
                    .build());
        }
        return list;
    }

    @Override
    public CursoDto getCurso(Long id_curso) {
        CursoEntity cursoEntity = cursoRepository.findById(id_curso).orElse(null);
        return CursoDto.builder()
                    .id_curso(cursoEntity.getId_curso())
                    .nombre(cursoEntity.getNombre())
                    .dia(cursoEntity.getDia())
                    .hora_inicio(cursoEntity.getHora_inicio())
                    .hora_fin(cursoEntity.getHora_fin())
                    .seccion(cursoEntity.getSeccion())
                    .cupomaximo(cursoEntity.getCupomaximo())
                    .estado(cursoEntity.getEstado())
                    .build();
    }

    @Override
    public CursoDto createCurso(CursoDto curso) {
        CursoEntity cursoEntity = CursoEntity.builder()
                    .nombre(curso.getNombre())
                    .dia(curso.getDia())
                    .hora_inicio(curso.getHora_inicio())
                    .hora_fin(curso.getHora_fin())
                    .seccion(curso.getSeccion())
                    .cupomaximo(curso.getCupomaximo())
                    .estado(true)
                    .build();
        cursoRepository.save(cursoEntity);
        curso.setId_curso(cursoEntity.getId_curso());
        return curso;
    }

    @Override
    public CursoDto updateCurso(CursoDto curso) {
        CursoEntity cursoEntity = cursoRepository.findById(curso.getId_curso()).orElse(null);
        cursoEntity.setNombre(curso.getNombre());
        cursoEntity.setDia(curso.getDia());
        cursoEntity.setHora_inicio(curso.getHora_inicio());
        cursoEntity.setHora_fin(curso.getHora_fin());
        cursoEntity.setSeccion(curso.getSeccion());
        cursoEntity.setCupomaximo(curso.getCupomaximo());
        cursoRepository.save(cursoEntity);
        return curso;
    }

    @Override
    public void deleteCurso(Long id) {
        CursoEntity cursoEntity = cursoRepository.findById(id).orElse(null);
        cursoEntity.setEstado(Boolean.FALSE);
        cursoRepository.save(cursoEntity);
    }



}
