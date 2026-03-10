package com.forohub.api.domain.topico;

import com.forohub.api.domain.curso.Curso;
import com.forohub.api.domain.autor.Autor;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Status status;
    @Embedded
    private Autor autor;
    @Embedded
    private Curso curso;

    public Topico(@Valid DatosRegistroTopicos datos) {
        this.id = null;
        this.activo= true;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = Status.ABIERTO;
        this.autor = new Autor(datos.autor());
        this.curso = new Curso(datos.curso());
    }

    public void actualizarInformaciones (@Valid DatosActualizacionTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.status() != null) {
            this.status = datos.status();
        }
    }

    public void eliminar() {this.activo = false;}
}
