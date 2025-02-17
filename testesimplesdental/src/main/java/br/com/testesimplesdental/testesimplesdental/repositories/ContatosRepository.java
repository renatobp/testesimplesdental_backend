package br.com.testesimplesdental.testesimplesdental.repositories;

import org.springframework.stereotype.Repository;

import br.com.testesimplesdental.testesimplesdental.models.Contatos;

/**
 * Interface que tem a função de realizar as operações de banco de dados para a
 * classe {@link Contatos}.
 * 
 * @author Renato Botelho Pereira
 */
@Repository
public interface ContatosRepository extends BaseRepository<Contatos, Long> {
}
