/**
 * 
 */
package co.com.atenea.adminactivos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.atenea.adminactivos.modelo.Area;

/**
 * @author sanal
 *
 */
@Repository
public interface AreasRepository extends JpaRepository<Area, Long>{

}
