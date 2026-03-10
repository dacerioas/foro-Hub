package com.forohub.api.domain.topico;

public record DatosListaTopicos(
        Long id,
        java.time.LocalDateTime fechaCreacion,
        String titulo,
        String autor,
        String mensaje,
        String curso,
        Status status
) {
    public DatosListaTopicos(Topico topico) {
            this(
                    topico.getId(),
                    topico.getFechaCreacion(),
                    topico.getTitulo(),
                    topico.getAutor().getNombre_autor(),
                    topico.getMensaje(),
                    topico.getCurso().getNombre_curso(),
                    topico.getStatus()
            );
        }
    }
