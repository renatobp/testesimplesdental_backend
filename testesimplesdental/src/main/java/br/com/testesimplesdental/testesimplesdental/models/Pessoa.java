package br.com.testesimplesdental.testesimplesdental.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Classe abstrata que uni os campos em comuns de suas subclasses.
 * 
 * @author Renato Botelho Pereira
 */
@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq_gen")
    @SequenceGenerator(name = "pessoa_seq_gen", sequenceName = "pessoa_id_seq")
    private Long id;

    @Column(nullable = false)
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate created_date;
}
