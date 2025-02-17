package br.com.testesimplesdental.testesimplesdental.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface GenericService<T, ID> {

    List<T> findAll();

    T findById(ID id);

    ResponseEntity<String> save(T object);

    ResponseEntity<String> edit(ID id, T object);

    ResponseEntity<String> delete(ID id, T object);
}
