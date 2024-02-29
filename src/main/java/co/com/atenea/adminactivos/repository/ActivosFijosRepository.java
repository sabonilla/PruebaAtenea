package co.com.atenea.adminactivos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.atenea.adminactivos.modelo.ActivoFijo;

// TODO: Auto-generated Javadoc
/**
 * The Interface ActivosFijosRepository.
 */
@Repository
public interface ActivosFijosRepository extends JpaRepository<ActivoFijo, Long>{

	/**
	 * Find by tipo or fecha compra or serial.
	 *
	 * @param tipo the tipo
	 * @param fechaCompra the fecha compra
	 * @param serial the serial
	 * @return the list
	 */
	List<ActivoFijo> findByTipoOrFechaCompraOrSerial(ActivoFijo.TipoActivo tipo, Date fechaCompra, String serial);
}
