package py.com.cveppaises.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepartamentoDTO extends GenericDTO {
    PaisDTO paisDTO;
    @NotNull(message = "El campo Nombre no puede ser nulo")
    @NotEmpty(message = "El campo Nombre no puede estar vacío")
    @NotBlank(message = "El campo Nombre no puede estar en blanco")
    private String nombre;
    private String codigoIso;
    private String capital;
    private Integer poblacion;
    private BigDecimal superficie;
}
