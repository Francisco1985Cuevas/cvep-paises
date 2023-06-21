package py.com.cveppaises.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.cveppaises.model.dto.PaisDTO;
import py.com.cveppaises.service.PaisService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/cvep/paises")
@Slf4j
public class PaisRestController {
    PaisService service;
    public PaisRestController(PaisService service) {
        this.service = service;
    }




    //Crear nuevos países
    /*@PostMapping("/")
    public ResponseEntity newPais(@RequestBody PaisDTO newPais) {
        log.info("PaisRestController.newPais newPais: {}", newPais);
        try {
            PaisDTO response;
            response = service.savePais(newPais);
            //return ResponseEntity.ok(response);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(response);
        } catch (Exception e) {
            log.error("Error en la petición para crear nuevo Pais: {}", e.getMessage());
            return new ResponseEntity<>("Error generado en la petición para crear nuevo Pais: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
    /*@PostMapping("/")
    public PaisDTO newPais(@RequestBody PaisDTO newPais) {
        log.info("PaisRestController.create newPais: {}", newPais);
        PaisDTO response = service.savePais(newPais);
        return response;
    }*/
    @PostMapping("/")
    public ResponseEntity newPais(@RequestBody PaisDTO newPais) {
        log.info("PaisRestController.newPais: {}", newPais);
        try {
            PaisDTO response;
            response = service.savePais(newPais);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Registro creado exitosamente!");
        } catch (Exception e) {
            log.error("Error en la petición para crear nuevo Pais: {}", e.getMessage());
            return new ResponseEntity<>("Error generado en la petición para crear nuevo Pais: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






















    //Buscar países (uno, todos o buscar por propiedades simples o complejas)
    //Buscar países (todos).
    @GetMapping
    public List<PaisDTO> all() {
        log.info("PaisRestController.all");
        List<PaisDTO> response = service.findAll();
        return response;
    }

    //Buscar paises (uno)
    @GetMapping("/{id}")
    public PaisDTO one(@PathVariable("id") Long id) {
        log.info("PaisRestController.one");
        PaisDTO response = service.findById(id);
        return response;
    }

    //Update existing ones
    @PutMapping("/{id}")
    /*public ResponseEntity replacePais(@PathVariable("id") Long id, @RequestBody PaisDTO newPais) {
        log.info("PaisRestController.replacePais id:{}, newPais:{}", id, newPais);
        try {
            service.updatePais(id, newPais);
            return ResponseEntity.status(HttpStatus.CREATED).body("Se actualizo exitosamente el registro! " + newPais);
        } catch (Exception e) {
            log.error("Error en la petición para actualizar Pais: {}", e.getMessage());
            return new ResponseEntity<>("Error generado en la petición para actualizar Pais: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
    public PaisDTO replacePais(@PathVariable("id") Long id, @RequestBody PaisDTO newPais) {
        log.info("PaisRestController.replacePais id:{}, newPais:{}", id, newPais);
        PaisDTO response = service.updatePais(id, newPais);
        return response;
    }


    //Delete Paises
    @DeleteMapping("/{id}")
    public ResponseEntity deletePais(@PathVariable("id") Long id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>("Registro eliminado exitosamente!", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al eliminar registro {}", e.getMessage());
            return new ResponseEntity<>("Error al eliminar registro. Error: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
