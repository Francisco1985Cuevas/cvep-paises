package py.com.cveppaises.service.implementation;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import py.com.cveppaises.model.dto.DepartamentoDTO;
import py.com.cveppaises.model.dto.PaisDTO;
import py.com.cveppaises.model.entity.Departamento;
import py.com.cveppaises.model.entity.Pais;
import py.com.cveppaises.model.enums.Estado;
import py.com.cveppaises.repository.DepartamentoRepository;
import py.com.cveppaises.service.DepartamentoService;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
@Transactional
@Slf4j
public class DepartamentoServiceImpl implements DepartamentoService {
    DepartamentoRepository repository;
    ModelMapper mapper;

    public DepartamentoServiceImpl(DepartamentoRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DepartamentoDTO> findAll() {
        log.info("DepartamentoServiceImpl.findAll");
        List<Departamento> entity = repository.findAll();
        List<DepartamentoDTO> paisDTOList = new ArrayList<>();
        for (Departamento elemento : entity) {
            DepartamentoDTO dto = new DepartamentoDTO();
            PaisDTO paisDTO = mapper.map(elemento.getPais(), PaisDTO.class);

            dto.setId(elemento.getId());
            dto.setNombre(elemento.getNombre());
            dto.setCodigoIso(elemento.getCodigoIso());
            dto.setCapital(elemento.getCapital());
            dto.setPoblacion(elemento.getPoblacion());
            dto.setSuperficie(elemento.getSuperficie());
            dto.setPaisDTO(paisDTO);
            dto.setEstado(elemento.getEstado());

            //Agregar los valores a la lista.
            paisDTOList.add(dto);
        }
        return paisDTOList;
    }

    @Override
    public DepartamentoDTO getDepartamentoById(Long id) {
        log.info("DepartamentoServiceImpl.getDepartamentoById.id: {}", id);
        Departamento entity = repository.findById(id).get();
        DepartamentoDTO response;

        PaisDTO paisDTO = mapper.map(entity.getPais(), PaisDTO.class);

        response = mapper.map(entity, DepartamentoDTO.class);

        response.setPaisDTO(paisDTO);

        return response;
    }

    @Override
    public DepartamentoDTO store(DepartamentoDTO request) {
        log.info("DepartamentoServiceImpl.store.request: {}", request);
        DepartamentoDTO response;
        try {
            request.setEstado(Estado.ACTIVO);

            Departamento entity = mapper.map(request, Departamento.class);
            entity = repository.save(entity);
            response = mapper.map(entity, DepartamentoDTO.class);
        } catch (Exception e) {
            log.error("Error en la implementación del Service Departamento: {}", e.getMessage());
            response = null;
        }
        return response;
    }

    @Override
    public DepartamentoDTO update(Long id, DepartamentoDTO request) {
        log.info("DepartamentoServiceImpl.update id:{}, request:{}", id, request);
        Departamento entity = repository.findById(id).get();
        DepartamentoDTO response;

        Pais pais = mapper.map(request.getPaisDTO(), Pais.class);

        entity.setNombre(request.getNombre());
        entity.setCodigoIso(request.getCodigoIso());
        entity.setCapital(request.getCapital());
        entity.setPoblacion(request.getPoblacion());
        entity.setSuperficie(request.getSuperficie());
        entity.setPais(pais);
        entity.setEstado(request.getEstado());

        repository.save(entity);
        response = mapper.map(entity, DepartamentoDTO.class);
        return response;
    }

    @Override
    public void deleteById(Long id) {
        log.info("DepartamentoServiceImpl.deleteById id:{}", id);
        repository.deleteById(id);
    }

}
