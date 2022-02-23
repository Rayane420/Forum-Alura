package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.CursoDto;
import br.com.alura.forum.controller.dto.DetalhesCursoDto;
import br.com.alura.forum.controller.form.CursoForm;
import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<CursoDto>lista(){
        List<Curso> cursos = cursoRepository.findAll();
        return CursoDto.converter(cursos);
    }

    //Detalhando curso
    @GetMapping("/{id}")
    public CursoDto detalhar(@PathVariable Long id){
        Curso curso = cursoRepository.getOne(id);
        return new CursoDto(curso);
    }


    //cadastrar cursos
    @PostMapping
    public ResponseEntity<CursoDto> cadastrar(@RequestBody CursoForm cursoForm, UriComponentsBuilder uriComponentsBuilder){
        Curso curso = cursoForm.converter(cursoRepository);
        cursoRepository.save(curso);

        URI uri = uriComponentsBuilder.path("cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new CursoDto(curso));

    }

}
