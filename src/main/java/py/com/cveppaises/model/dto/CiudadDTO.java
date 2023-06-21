package py.com.cveppaises.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CiudadDTO extends GenericDTO {
    DepartamentoDTO departamentoDTO;
    @NotNull(message = "El campo Nombre no puede ser nulo")
    @NotEmpty(message = "El campo Nombre no puede estar vacío")
    @NotBlank(message = "El campo Nombre no puede estar en blanco")
    private String nombre;
    private String codigoPostal;
    private Integer poblacion;
}
