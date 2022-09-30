package br.com.fiap.flyhigh.controller;

import br.com.fiap.flyhigh.model.Categoria;
import br.com.fiap.flyhigh.model.Moeda;
import br.com.fiap.flyhigh.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Categoria cadastrar(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @PutMapping("{id}")
    public Categoria atualizar(@RequestBody Categoria categoria, @PathVariable int id) {
        categoria.setCodigo(id);
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo) {
        categoriaRepository.deleteById(codigo);
    }
}
