package br.com.testesimplesdental.testesimplesdental.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.testesimplesdental.testesimplesdental.enums.Cargo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe que representa e entidade profissionais no banco de dados.
 * 
 * @author Renato Botelho Pereira
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Profissionais extends Pessoa {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargo cargo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate nascimento;
}
