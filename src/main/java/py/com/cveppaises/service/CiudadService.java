package py.com.cveppaises.service;

import jakarta.validation.Valid;
import py.com.cveppaises.model.dto.CiudadDTO;

import java.util.List;

public interface CiudadService {
    //List<CiudadDTO> findAll();
    //CiudadDTO getCiudadById(Long id);
    CiudadDTO store(@Valid CiudadDTO request);
    //CiudadDTO update(Long id, @Valid CiudadDTO request);
    void deleteById(Long id);
}
