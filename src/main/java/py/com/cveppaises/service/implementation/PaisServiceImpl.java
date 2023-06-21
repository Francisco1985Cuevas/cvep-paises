package py.com.cveppaises.service.implementation;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import py.com.cveppaises.exceptions.GeneralException;
import py.com.cveppaises.exceptions.NoDataFoundException;
import py.com.cveppaises.exceptions.ResourceNotFoundException;
import py.com.cveppaises.model.dto.PaisDTO;
import py.com.cveppaises.model.entity.Pais;
import py.com.cveppaises.model.enums.Estado;
import py.com.cveppaises.repository.PaisRepository;
import py.com.cveppaises.service.PaisService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Validated
@Transactional
@Slf4j
public class PaisServiceImpl implements PaisService {
    PaisRepository repository;
    ModelMapper mapper;
    public PaisServiceImpl(PaisRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public PaisDTO savePais(PaisDTO newPais) {
        log.info("PaisServiceImpl.savePais");
        /*
        PaisDTO response;
        try {
            newPais.setEstado(Estado.ACTIVO);

            Pais entity = mapper.map(newPais, Pais.class);
            entity = repository.save(entity);
            response = mapper.map(entity, PaisDTO.class);
        } catch (Exception e) {
            log.error("Error en la implementación del Service Pais: {}", e.getMessage());
            response = null;
        }
        return response;
        */

        PaisDTO response;
        newPais.setEstado(Estado.ACTIVO);
        Pais entity = mapper.map(newPais, Pais.class);
        entity = repository.save(entity);
        if (entity != null) {
            response = mapper.map(entity, PaisDTO.class);
            return response;
        }
        throw new GeneralException("No se puede guardar el registro.");
        //throw new IllegalArgumentException("No se puede guardar el registro.");//No funciona

        /*
        newPais.setEstado(Estado.ACTIVO);
        Pais entity = mapper.map(newPais, Pais.class);
        entity = repository.save(entity);
        PaisDTO response;
        response = mapper.map(entity, PaisDTO.class);
        return response;
        */
    }




















    @Override
    public List<PaisDTO> findAll() {
        log.info("PaisServiceImpl.findAll");

        List<Pais> entity = repository.findAll();
        if (entity.size() > 0) {
            List<PaisDTO> paisDTOList = new ArrayList<>();

            for (Pais elemento : entity) {
                PaisDTO dto = new PaisDTO();
                dto.setId(elemento.getId());
                dto.setNombre(elemento.getNombre());
                dto.setCodigoIso2(elemento.getCodigoIso2());
                dto.setCodigoIso3(elemento.getCodigoIso3());
                dto.setCapital(elemento.getCapital());
                dto.setPoblacion(elemento.getPoblacion());
                dto.setArea(elemento.getArea());
                dto.setIdioma(elemento.getIdioma());
                dto.setMoneda(elemento.getMoneda());
                dto.setDominioTld(elemento.getDominioTld());
                dto.setHusoHorario(elemento.getHusoHorario());
                dto.setContinente(elemento.getContinente());
                dto.setEstado(elemento.getEstado());

                //Agregar los valores a la lista.
                paisDTOList.add(dto);
            }
            return paisDTOList;
        }

        throw new NoDataFoundException("No hay países disponibles");
    }

    @Override
    public PaisDTO findById(Long id) {
        log.info("PaisServiceImpl.findById");

        Optional<Pais> entity = repository.findById(id);
        if (!entity.isPresent()) {
            throw new ResourceNotFoundException("Recurso no encontrado para el identificador: "+id);
        }

        PaisDTO response;
        response = mapper.map(entity.get(), PaisDTO.class);
        return response;
    }


    @Override
    public PaisDTO updatePais(Long id, PaisDTO newPais) {
        log.info("PaisServiceImpl.updatePais id:{}, newPais:{}", id, newPais);
        /*
        Pais entity = repository.findById(id).get();
        PaisDTO response;

        entity.setNombre(newPais.getNombre());
        entity.setCodigoIso2(newPais.getCodigoIso2());
        entity.setCodigoIso3(newPais.getCodigoIso3());
        entity.setCapital(newPais.getCapital());
        entity.setPoblacion(newPais.getPoblacion());
        entity.setArea(newPais.getArea());
        entity.setIdioma(newPais.getIdioma());
        entity.setMoneda(newPais.getMoneda());
        entity.setDominioTld(newPais.getDominioTld());
        entity.setHusoHorario(newPais.getHusoHorario());
        entity.setContinente(newPais.getContinente());
        entity.setEstado(newPais.getEstado());
        entity.setUpdatedAt(LocalDateTime.now());

        repository.save(entity);
        response = mapper.map(entity, PaisDTO.class);
        return response;
        */

        Optional<Pais> entity = repository.findById(id);
        if (!entity.isPresent()) {
            throw new ResourceNotFoundException("Recurso no encontrado para el identificador: "+id);
        }

        PaisDTO response;

        entity.get().setNombre(newPais.getNombre().toUpperCase());
        entity.get().setCodigoIso2(newPais.getCodigoIso2());
        entity.get().setCodigoIso3(newPais.getCodigoIso3());
        entity.get().setCapital(newPais.getCapital());
        entity.get().setPoblacion(newPais.getPoblacion());
        entity.get().setArea(newPais.getArea());
        entity.get().setIdioma(newPais.getIdioma());
        entity.get().setMoneda(newPais.getMoneda());
        entity.get().setDominioTld(newPais.getDominioTld());
        entity.get().setHusoHorario(newPais.getHusoHorario());
        entity.get().setContinente(newPais.getContinente());
        entity.get().setEstado(newPais.getEstado());
        entity.get().setUpdatedAt(LocalDateTime.now());

        repository.save(entity.get());
        response = mapper.map(entity.get(), PaisDTO.class);
        return response;
    }

    @Override
    public void deleteById(Long id) {
        log.info("PaisServiceImpl.deleteById id:{}", id);
        repository.deleteById(id);
    }

}
