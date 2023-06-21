package py.com.cveppaises.service;

import jakarta.validation.Valid;
import py.com.cveppaises.model.dto.DepartamentoDTO;

import java.util.List;

public interface DepartamentoService {
    List<DepartamentoDTO> findAll();
    DepartamentoDTO getDepartamentoById(Long id);
    DepartamentoDTO store(@Valid DepartamentoDTO request);
    DepartamentoDTO update(Long id, @Valid DepartamentoDTO request);
    void deleteById(Long id);
}
