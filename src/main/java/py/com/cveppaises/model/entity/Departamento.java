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
@Table(name = "departamentos")
@Data
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("Identificador único del registro.")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pais_id")
    @Comment("Identificador del país al que pertenece el departamento")
    Pais pais;
    @Column(name = "nombre", nullable = false)
    @Comment("Nombre del departamento o estado")
    private String nombre;
    @Column(name = "codigo_iso", nullable = true)
    @Comment("Código ISO del departamento (opcional)")
    private String codigoIso;
    @Column(name = "capital", nullable = true)
    @Comment("Capital del departamento")
    private String capital;
    @Column(name = "poblacion", nullable = true)
    @Comment("Población del departamento")
    private Integer poblacion;
    @Column(name = "superficie", nullable = false)
    @Comment("Superficie total del departamento (en km²)")
    private BigDecimal superficie;

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
