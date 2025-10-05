package com.arthur.biblioteca.model;

import com.arthur.biblioteca.validator.DataPrevistaValida;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@DataPrevistaValida
public class Emprestimo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @NotNull(message = "Livro é obrigatório")
    private Livro livro;

    @ManyToOne @NotNull(message = "Usuário é obrigatório")
    private Usuario usuario;

    @NotNull(message = "Data retirada é obrigatória")
    private LocalDate dataRetirada;

    @NotNull(message = "Data prevista é obrigatória")
    private LocalDate dataPrevistaDevolucao;

    private boolean devolvido = false;

    private LocalDate dataDevolucaoReal;
}
