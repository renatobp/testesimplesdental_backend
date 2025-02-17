package br.com.testesimplesdental.testesimplesdental.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa e entidade contatos no banco de dados.
 * 
 * @author Renato Botelho Pereira
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Contatos extends Pessoa {

    @Column(nullable = false)
    private String contato;

    @JoinColumn(nullable = false)
    @ManyToOne
    private Profissionais profissionais;
}
