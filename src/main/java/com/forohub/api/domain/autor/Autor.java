package com.forohub.api.domain.autor;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Autor {
    private String nombre_autor;
    private String email;

    public Autor(DatosAutor autor) {
        this.nombre_autor = autor.nombre_autor();
        this.email = autor.email();
    }
}
