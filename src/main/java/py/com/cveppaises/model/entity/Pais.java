package py.com.cveppaises.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import py.com.cveppaises.model.enums.Estado;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "paises")
@Data
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Identificador único del registro.")
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true)
    @Comment("Nombre del país")
    private String nombre;

    @Column(name = "codigo_iso2", nullable = true)
    @Comment("Código ISO de 2 letras del país")
    private String codigoIso2;

    @Column(name = "codigo_iso3", nullable = true)
    @Comment("Código ISO de 3 letras del país")
    private String codigoIso3;

    @Column(name = "capital", nullable = true)
    @Comment("Capital del país")
    private String capital;

    @Column(name = "poblacion", nullable = true)
    @Comment("Cantidad de la poblacion")
    private Integer poblacion;

    @Column(name = "area", nullable = true)
    @Comment("Área total del país (en km²)")
    private BigDecimal area;

    @Column(name = "idioma", nullable = true)
    @Comment("Idioma oficial del país")
    private String idioma;

    @Column(name = "moneda", nullable = true)
    @Comment("Moneda oficial del país")
    private String moneda;

    @Column(name = "dominio_tld", nullable = true)
    @Comment("Dominio de nivel superior del país")
    private String dominioTld;

    @Column(name = "huso_horario", nullable = true)
    @Comment("Huso horario del país")
    private String husoHorario;

    @Column(name = "continente", nullable = true)
    @Comment("Continente en el que se encuentra el país")
    private String continente;

    @Column(name = "estado", nullable = true)
    @Enumerated(EnumType.STRING)
    @Comment("Estado actual del registro.")
    private Estado estado;

    @Column(name = "created_by", nullable = true)
    @Comment("Campos para la seguridad. (Creado por) Registro del usuario que creó el registro.")
    private String createdBy;

    @Column(name = "created_at", nullable = true)
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Comment("Campos para la seguridad. (Fecha de creación) Registro de la fecha y hora en que se creó el registro.")
    private LocalDateTime createdAt;

    @Column(name = "updated_by", nullable = true)
    @Comment("Campos para la seguridad. (Actualizado por) Registro del usuario que realizó la última actualización en el registro.")
    private String updatedBy;

    @Column(name = "updated_at", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Comment("Campos para la seguridad. (Fecha de actualización) Registro de la fecha y hora de la última actualización en el registro.")
    private LocalDateTime updatedAt;

    @Column(name = "deleted")
    @Comment("Campos para la parte de auditoría. (Eliminado) Registro de si el registro ha sido eliminado o no.")
    private boolean deleted = false;

    @Column(name = "deleted_by", nullable = true)
    @Comment("Campos para la parte de auditoría. (Eliminado por) Registro del usuario que eliminó el registro.")
    private String deletedBy;

    @Column(name = "deleted_at", nullable = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Comment("Campos para la parte de auditoría. (Fecha de eliminación): Registro de la fecha y hora en que el registro fue eliminado.")
    private LocalDateTime deletedAt;
}
