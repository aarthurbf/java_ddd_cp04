package com.arthur.biblioteca.validator;

import com.arthur.biblioteca.model.Emprestimo;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DataPrevistaValidaValidator implements ConstraintValidator<DataPrevistaValida, Emprestimo> {
    @Override
    public boolean isValid(Emprestimo emprestimo, ConstraintValidatorContext context) {
        if (emprestimo == null) return true;
        if (emprestimo.getDataRetirada() == null || emprestimo.getDataPrevistaDevolucao() == null) return true;
        return emprestimo.getDataPrevistaDevolucao().isAfter(emprestimo.getDataRetirada());
    }
}
