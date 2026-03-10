package com.forohub.api.domain.curso;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Curso {
    private String nombre_curso;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(DatosCurso curso) {
        this.nombre_curso= curso.nombre_curso();
        this.categoria= curso.categoria();
    }
}
