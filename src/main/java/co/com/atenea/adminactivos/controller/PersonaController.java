/**
 * 
 */
package co.com.atenea.adminactivos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.atenea.adminactivos.modelo.Persona;
import co.com.atenea.adminactivos.service.PersonaService;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonaController.
 *
 * @author sanal
 */
@RestController
@RequestMapping("/api/persona")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	/**
	 * Gets the all personas.
	 *
	 * @return the all personas
	 */
	@GetMapping
	public ResponseEntity<List<Persona>> getAllPersonas(){
		return ResponseEntity.ok(personaService.getAllPersonas());
	}
}
