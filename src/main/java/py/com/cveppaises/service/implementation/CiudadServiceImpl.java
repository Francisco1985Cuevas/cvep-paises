package py.com.cveppaises.service.implementation;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import py.com.cveppaises.model.dto.CiudadDTO;
import py.com.cveppaises.model.dto.PaisDTO;
import py.com.cveppaises.model.entity.Ciudad;
import py.com.cveppaises.model.entity.Pais;
import py.com.cveppaises.model.enums.Estado;
import py.com.cveppaises.repository.CiudadRepository;
import py.com.cveppaises.service.CiudadService;

import java.util.ArrayList;
import java.util.List;

@Service
@Validated
@Transactional
@Slf4j
public class CiudadServiceImpl implements CiudadService {
    CiudadRepository repository;
    ModelMapper mapper;

    public CiudadServiceImpl(CiudadRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /*@Override
    public List<CiudadDTO> findAll() {
        log.info("CiudadServiceImpl.findAll");
        List<Ciudad> entity = repository.findAll();
        List<CiudadDTO> paisDTOList = new ArrayList<>();
        for (Ciudad elemento : entity) {
            CiudadDTO dto = new CiudadDTO();
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
    }*/

    /*@Override
    public CiudadDTO getCiudadById(Long id) {
        log.info("CiudadServiceImpl.getCiudadById.id: {}", id);
        Ciudad entity = repository.findById(id).get();
        CiudadDTO response;

        PaisDTO paisDTO = mapper.map(entity.getPais(), PaisDTO.class);

        response = mapper.map(entity, CiudadDTO.class);

        response.setPaisDTO(paisDTO);

        return response;
    }*/

    @Override
    public CiudadDTO store(CiudadDTO request) {
        log.info("CiudadServiceImpl.store.request: {}", request);
        CiudadDTO response;
        try {
            request.setEstado(Estado.ACTIVO);

            Ciudad entity = mapper.map(request, Ciudad.class);
            entity = repository.save(entity);
            response = mapper.map(entity, CiudadDTO.class);
        } catch (Exception e) {
            log.error("Error en la implementación del Service Ciudad: {}", e.getMessage());
            response = null;
        }
        return response;
    }

    /*@Override
    public CiudadDTO update(Long id, CiudadDTO request) {
        log.info("CiudadServiceImpl.update id:{}, request:{}", id, request);
        Ciudad entity = repository.findById(id).get();
        CiudadDTO response;

        Pais pais = mapper.map(request.getPaisDTO(), Pais.class);

        entity.setNombre(request.getNombre());
        entity.setCodigoIso(request.getCodigoIso());
        entity.setCapital(request.getCapital());
        entity.setPoblacion(request.getPoblacion());
        entity.setSuperficie(request.getSuperficie());
        entity.setPais(pais);
        entity.setEstado(request.getEstado());

        repository.save(entity);
        response = mapper.map(entity, CiudadDTO.class);
        return response;
    }*/

    @Override
    public void deleteById(Long id) {
        log.info("CiudadServiceImpl.deleteById id:{}", id);
        repository.deleteById(id);
    }

}
