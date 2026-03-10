package com.forohub.api.domain.topico;

import com.forohub.api.domain.curso.DatosCurso;
import com.forohub.api.domain.autor.DatosAutor;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopicos(@NotBlank String titulo,
                                   @NotBlank String mensaje,
                                   @NotNull @Valid DatosAutor autor,
                                   @NotNull @Valid DatosCurso curso) {
}
