package py.com.cveppaises.service;

import jakarta.validation.Valid;
import py.com.cveppaises.model.dto.PaisDTO;

import java.util.List;

public interface PaisService {
    PaisDTO savePais(@Valid PaisDTO newPais);








    List<PaisDTO> findAll();

    PaisDTO findById(Long id);

    PaisDTO updatePais(Long id, @Valid PaisDTO newPais);

    void deleteById(Long id);
}
