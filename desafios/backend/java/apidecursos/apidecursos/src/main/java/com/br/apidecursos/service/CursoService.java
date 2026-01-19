package com.br.apidecursos.service;

import com.br.apidecursos.entity.Curso;
import com.br.apidecursos.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso criar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não eocntroado,  id={"+id+"}"));
    }

    public Curso atualizar(Long id, Curso curso) {
        Curso existente = buscarPorId(id);

        existente.setName(curso.getName());
        existente.setCategory(curso.getCategory());
        existente.setActive(curso.isActive());
        existente.setUpdatedAt(LocalDateTime.now());

        return cursoRepository.save(existente);
    }

    public void deletar(Long id) {
        Curso existente = buscarPorId(id);
        cursoRepository.delete(existente);
    }

}
