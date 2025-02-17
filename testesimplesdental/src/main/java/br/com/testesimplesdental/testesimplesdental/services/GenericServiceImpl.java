package br.com.testesimplesdental.testesimplesdental.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.com.testesimplesdental.testesimplesdental.models.Pessoa;
import br.com.testesimplesdental.testesimplesdental.repositories.BaseRepository;

public abstract class GenericServiceImpl<T extends Pessoa, ID extends Long> implements GenericService<T, ID> {

    @Autowired
    protected BaseRepository<T, ID> repository;

    @Override
    public List<T> findAll() {
	return repository.findAll();
    }

    @Override
    public T findById(ID id) {
	return repository.findById(id).orElse(null);
    }

    public ResponseEntity<String> save(T entity) {
	try {
	    entity.setCreated_date(LocalDate.now());
	    repository.save(entity);
	    return ResponseEntity.ok("Salvo com sucesso!");
	} catch (Exception e) {
	    throw new RuntimeException("Ocorreu um erro ao tentar salvar: " + e.getMessage());
	}
    }

    @Override
    public ResponseEntity<String> delete(ID id, T entity) {
	Optional<T> localEntity = repository.findById(id);

	try {
	    if (entity != null && localEntity.isPresent()) {
		entity.setId(id);
		repository.delete(entity);
	    }
	    return ResponseEntity.ok("Excluído com sucesso!");
	} catch (Exception e) {
	    throw new RuntimeException("Ocorreu um erro ao tentar excluir: " + e.getMessage());
	}
    }

    @Override
    public ResponseEntity<String> edit(ID id, T entity) {
	Optional<T> localEntity = repository.findById(id);

	try {
	    if (entity != null && localEntity.isPresent()) {
		entity.setCreated_date(localEntity.get().getCreated_date());
		entity.setId(id);
		repository.save(entity);
	    }
	    return ResponseEntity.ok("Atualizado com sucesso!");
	} catch (Exception e) {
	    throw new RuntimeException("Ocorreu um erro ao tentar alterar: " + e.getMessage());
	}
    }
}
