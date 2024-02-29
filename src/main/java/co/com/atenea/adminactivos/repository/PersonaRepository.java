/**
 * 
 */
package co.com.atenea.adminactivos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.atenea.adminactivos.modelo.Persona;

/**
 * The Interface PersonaRepository.
 *
 * @author sanal
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
