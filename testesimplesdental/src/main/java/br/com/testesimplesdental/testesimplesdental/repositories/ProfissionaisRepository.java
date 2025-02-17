package br.com.testesimplesdental.testesimplesdental.repositories;

import org.springframework.stereotype.Repository;

import br.com.testesimplesdental.testesimplesdental.models.Profissionais;

/**
 * Interface que tem a função de realizar as operações de banco de dados para a
 * classe {@link Profissionais}.
 * 
 * @author Renato Botelho Pereira
 */
@Repository
public interface ProfissionaisRepository extends BaseRepository<Profissionais, Long> {
}
