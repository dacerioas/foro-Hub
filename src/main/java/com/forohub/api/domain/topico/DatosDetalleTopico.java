package com.forohub.api.domain.topico;

import com.forohub.api.domain.autor.Autor;
import com.forohub.api.domain.curso.Curso;

public record DatosDetalleTopico(
                                 Long id,
                                 java.time.LocalDateTime fechaCreacion,
                                 String titulo,
                                 Autor autor,
                                 String mensaje,
                                 Curso curso,
                                 Status status
) {
    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getFechaCreacion(),
                topico.getTitulo(),
                topico.getAutor(),
                topico.getMensaje(),
                topico.getCurso(),
                topico.getStatus()
        );
    }
}

