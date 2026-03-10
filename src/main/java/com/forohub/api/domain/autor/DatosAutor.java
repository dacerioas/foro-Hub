package com.forohub.api.domain.autor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosAutor(
        @NotBlank String nombre_autor,
        @NotBlank @Email String email
) {
}
