package com.arthur.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Título não pode ficar vazio")
    private String titulo;

    private String autor;

    private Integer anoPublicacao;

    @Enumerated(EnumType.STRING)
    private Status status = Status.DISPONIVEL;

    public enum Status {
        DISPONIVEL, EMPRESTADO
    }
}
