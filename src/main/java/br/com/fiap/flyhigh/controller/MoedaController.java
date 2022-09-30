package br.com.fiap.flyhigh.controller;

import br.com.fiap.flyhigh.model.Categoria;
import br.com.fiap.flyhigh.model.Moeda;
import br.com.fiap.flyhigh.repository.CategoriaRepository;
import br.com.fiap.flyhigh.repository.MoedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("moeda")
public class MoedaController {

    @Autowired
    private MoedaRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Moeda> listar() {
        return repository.findAll();
    }

    @GetMapping("{codigo}")
    public Moeda buscar(@PathVariable int codigo) {
        return repository.findById(codigo).get();
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Moeda cadastrar(@RequestBody Moeda moeda, Model model) {
    model.addAttribute("categorias", categoriaRepository.findAll());
        return repository.save(moeda);
    }

    @PutMapping("{id}")
    public Moeda atualizar(@RequestBody Moeda moeda, @PathVariable int id) {
        moeda.setCodigo(id);
        return repository.save(moeda);
    }
    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo) {
        repository.deleteById(codigo);
    }

    @GetMapping("pesquisa")
    public List<Moeda> buscar(@RequestParam(required = false) String nome, @RequestParam(defaultValue = "false") boolean blockchain) {
        return nome != null ? repository.findByNomeAndBlockchain(nome, blockchain) : repository.findByBlockchain(blockchain);
    }

}