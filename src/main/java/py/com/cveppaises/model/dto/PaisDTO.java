package py.com.cveppaises.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import py.com.cveppaises.model.enums.Estado;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaisDTO {
    private Long id;

    @NotNull(message = "El campo Nombre no puede ser nulo")
    @NotEmpty(message = "El campo Nombre no puede estar vacío")
    @NotBlank(message = "El campo Nombre no puede estar en blanco")
    @Size(min = 2, max = 255, message = "El campo Nombre debe tener entre 2 y 255 caracteres")
    private String nombre;

    @JsonProperty("codigo_iso2")
    private String codigoIso2;

    @JsonProperty("codigo_iso3")
    private String codigoIso3;

    private String capital;

    private Integer poblacion;

    private BigDecimal area;

    private String idioma;

    private String moneda;

    @JsonProperty("dominio_tld")
    private String dominioTld;

    @JsonProperty("huso_horario")
    private String husoHorario;

    private String continente;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonProperty("updated_by")
    private String updatedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    private boolean deleted;

    @JsonProperty("deleted_by")
    private String deletedBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deletedAt;
}
