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

import co.com.atenea.adminactivos.exceptions.ApiResponseMessage;
import co.com.atenea.adminactivos.modelo.ActivoFijo;
import co.com.atenea.adminactivos.service.AdministracionActivosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// TODO: Auto-generated Javadoc
/**
 * The Class AdministarActivosController.
 *
 * @author sanal
 */
@Api(tags = "AdministarActivosController")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/activos")
public class AdministarActivosController {
	
	@Autowired
	private AdministracionActivosService administracionActivosService;

	/**
	 * Gets the all activos.
	 *
	 * @return the all activos
	 */
	@ApiOperation("Obtener todos los activos")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de activos obtenida con éxito"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })
	@GetMapping
	public ResponseEntity<Object> getAllActivos() {	
		
		List<ActivoFijo> activos = administracionActivosService.getAllActivos();
	    if (activos.isEmpty()) {
	        // Devolver respuesta con código de estado 404 y un mensaje personalizado
	        ApiResponseMessage responseMessage = new ApiResponseMessage(404, "No se encontraron activos");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
	    }	
		
		return ResponseEntity.ok(administracionActivosService.getAllActivos());
	}

	/**
	 * Buscar activos por parametros.
	 *
	 * @param tipo the tipo
	 * @param fechaCompra the fecha compra
	 * @param serial the serial
	 * @return the response entity
	 */
	@ApiOperation("Buscar activos por parámetros")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Lista de activos encontrada con éxito"),
			@ApiResponse(code = 400, message = "Datos faltantes al realizar la búsqueda"),
			@ApiResponse(code = 404, message = "No se encontraron activos"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })
	@GetMapping("/buscar")
	public ResponseEntity<Object> buscarActivosPorParametros(
			@RequestParam(required = false) ActivoFijo.TipoActivo tipo,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaCompra,
			@RequestParam(required = false) String serial) {

		if (fechaCompra != null) {
			Instant instant = fechaCompra.toInstant();
			fechaCompra = Date.from(instant.atZone(ZoneId.of("UTC")).toInstant());
		}
		// Lógica para realizar la búsqueda basada en los parámetros recibidos
	    List<ActivoFijo> activos = administracionActivosService.buscarActivosPorCriterios(tipo, fechaCompra, serial);

	    if (activos.isEmpty()) {
	        // Devolver respuesta con código de estado 404 y un mensaje personalizado
	        ApiResponseMessage responseMessage = new ApiResponseMessage(404, "No se encontraron activos");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMessage);
	    }

	    return ResponseEntity.ok(activos);
	}

	/**
	 * Creates the activo.
	 *
	 * @param activo the activo
	 * @return the response entity
	 */
	@ApiOperation("Crear un nuevo activo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Activo creado con éxito"),
			@ApiResponse(code = 400, message = "Datos faltantes al crear el activo"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })
	@PostMapping
	public ResponseEntity<ActivoFijo> createActivo(@RequestBody ActivoFijo activo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(administracionActivosService.createActivo(activo));
	}

	/**
	 * Update activo.
	 *
	 * @param id the id
	 * @param updatedActivo the updated activo
	 * @return the activo fijo
	 */
	@ApiOperation("Actualizar un activo por su ID")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Activo actualizado con éxito"),
			@ApiResponse(code = 400, message = "Datos faltantes al actualizar el activo"),
			@ApiResponse(code = 404, message = "Activo no encontrado"),
			@ApiResponse(code = 500, message = "Error interno del servidor") })
	@PutMapping("/{id}")
	public ActivoFijo updateActivo(@PathVariable Long id, @RequestBody ActivoFijo updatedActivo){
		return administracionActivosService.updateActivo(id, updatedActivo);
	}

}
