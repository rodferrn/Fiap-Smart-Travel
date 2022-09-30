package br.com.fiap.flyhigh.controller;

import br.com.fiap.flyhigh.model.Moeda;
import br.com.fiap.flyhigh.model.Travel;
import br.com.fiap.flyhigh.repository.MoedaRepository;
import br.com.fiap.flyhigh.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("travel")
public class TravelController {

    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private MoedaRepository moedaRepository;

    @GetMapping
    public List<Travel> listar() {return travelRepository.findAll(); }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public Travel cadastrar(@RequestBody Travel travel, Model model) {
        model.addAttribute("moedas", moedaRepository.findAll());
        return travelRepository.save(travel);
    }

    @PutMapping("{id}")
    public Travel atualizar(@RequestBody Travel travel, @PathVariable int id) {
        travel.setCodigo(id);
        return travelRepository.save(travel);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo) {
        travelRepository.deleteById(codigo);
    }


}
