package com.forohub.api.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCurso(
        @NotBlank String nombre_curso,
        @NotNull Categoria categoria
) {
}
