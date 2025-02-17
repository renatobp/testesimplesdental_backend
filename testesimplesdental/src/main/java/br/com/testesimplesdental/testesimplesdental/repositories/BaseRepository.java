package br.com.testesimplesdental.testesimplesdental.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.testesimplesdental.testesimplesdental.models.Pessoa;

@Repository
public interface BaseRepository<T extends Pessoa, ID extends Long> extends JpaRepository<T, ID> {
}
