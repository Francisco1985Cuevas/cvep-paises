package py.com.cveppaises.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.cveppaises.model.dto.DepartamentoDTO;
import py.com.cveppaises.service.DepartamentoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/cvep/paises/departamentos")
@Slf4j
public class DepartamentoRestController {
    DepartamentoService service;

    public DepartamentoRestController(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public List<DepartamentoDTO> findAll() {
        log.info("DepartamentoRestController.findAll");
        List<DepartamentoDTO> response = service.findAll();
        return response;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody DepartamentoDTO request) {
        log.info("DepartamentoRestController.create request: {}", request);
        try {
            service.store(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("Se creo exitosamente el nuevo registro! " + request);
        } catch (Exception e) {
            log.error("Error en la petición para crear nuevo Departamento: {}", e.getMessage());
            return new ResponseEntity<>("Error generado en la petición para crear nuevo Departamento: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity edit(@PathVariable("id") Long id, @RequestBody DepartamentoDTO request) {
        log.info("DepartamentoRestController.edit id:{}, request:{}", id, request);
        try {
            service.update(id, request);
            return ResponseEntity.status(HttpStatus.OK).body("Se actualizo exitosamente el registro! " + request);
        } catch (Exception e) {
            log.error("Error en la petición para actualizar Departamento: {}", e.getMessage());
            return new ResponseEntity<>("Error generado en la petición para actualizar Departamento: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Long id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>("Registro eliminado exitosamente!", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al eliminar registro {}", e.getMessage());
            return new ResponseEntity<>("Error al eliminar registro. Error: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public DepartamentoDTO findById(@PathVariable("id") Long id) {
        log.info("DepartamentoRestController.findById");
        DepartamentoDTO response = service.getDepartamentoById(id);
        return response;
    }

}
