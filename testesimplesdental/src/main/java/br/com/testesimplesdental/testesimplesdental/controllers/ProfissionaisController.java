package br.com.testesimplesdental.testesimplesdental.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testesimplesdental.testesimplesdental.models.Profissionais;
import br.com.testesimplesdental.testesimplesdental.services.ProfissionaisService;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Classe responsável por receber as requisições do front.
 * 
 * @author Renato Botelho Pereira
 */

@RequestMapping(value = "/profissionais")
@RestController
public class ProfissionaisController {

    @Autowired
    private ProfissionaisService service;

    @GetMapping
    public List<Profissionais> findAll() {
	return service.findAll();
    }

    @GetMapping("{id}")
    public Profissionais findById(@PathVariable("id") Long id, HttpServletRequest request) {
	return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Profissionais profissionais) {
	return service.save(profissionais);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id, @RequestBody Profissionais profissionais) {
	return service.delete(id, profissionais);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable("id") Long id, @RequestBody Profissionais profissionais) {
	return service.edit(id, profissionais);
    }
}
