/**
 * 
 */
package co.com.atenea.adminactivos.controller;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.atenea.adminactivos.modelo.ActivoFijo;
import co.com.atenea.adminactivos.service.AdministracionActivosService;

/**
 * @author sanal
 *
 */
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/activos")
public class AdministarActivosController {

	@Autowired
    private AdministracionActivosService administracionActivosService;
	
	@GetMapping
    public ResponseEntity<List<ActivoFijo>> getAllActivos() {
        return ResponseEntity.ok(administracionActivosService.getAllActivos());
    }

	@GetMapping("/buscar")
    public ResponseEntity<List<ActivoFijo>> buscarActivosPorParametros(
            @RequestParam(required = false) ActivoFijo.TipoActivo tipo,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCompra,
            @RequestParam(required = false) String serial) {
		
		 if (fechaCompra != null) {
		        Instant instant = fechaCompra.toInstant();
		        fechaCompra = Date.from(instant.atZone(ZoneId.of("UTC")).toInstant());
		    }
        // Lógica para realizar la búsqueda basada en los parámetros recibidos
        List<ActivoFijo> activos = administracionActivosService.buscarActivosPorCriterios(tipo, fechaCompra, serial);

        return ResponseEntity.ok(activos);
    }

    @PostMapping
    public ResponseEntity<ActivoFijo> createActivo(@RequestBody ActivoFijo activo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(administracionActivosService.createActivo(activo));
    }

    @PutMapping("/{id}")
    public ActivoFijo updateActivo(@PathVariable Long id, @RequestBody ActivoFijo updatedActivo) {
        return administracionActivosService.updateActivo(id, updatedActivo);
    }
	
}
