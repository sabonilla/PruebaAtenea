/**
 * 
 */
package co.com.atenea.adminactivos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.atenea.adminactivos.modelo.Persona;
import co.com.atenea.adminactivos.repository.PersonaRepository;
import co.com.atenea.adminactivos.service.PersonaService;

/**
 * @author sanal
 *
 */
@Service
public class PersonaSeviceImpl implements PersonaService{

	@Autowired
	private PersonaRepository peroRepository;
	
	
	@Override
	public List<Persona> getAllPersonas() {
		
		return peroRepository.findAll();
	}

}
