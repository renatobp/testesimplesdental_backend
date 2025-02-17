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

import br.com.testesimplesdental.testesimplesdental.models.Contatos;
import br.com.testesimplesdental.testesimplesdental.services.ContatosService;

@RequestMapping(value = "/contatos")
@RestController
public class ContatosController {

    @Autowired
    private ContatosService service;

    @GetMapping
    public List<Contatos> findAll() {
	return service.findAll();
    }

    @GetMapping("{id}")
    public Contatos findById(@PathVariable("id") Long id) {
	return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Contatos contatos) {
	return service.save(contatos);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id, @RequestBody Contatos contatos) {
	return service.delete(id, contatos);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable("id") Long id, @RequestBody Contatos contatos) {
	return service.edit(id, contatos);
    }
}
