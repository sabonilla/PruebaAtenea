package co.com.atenea.adminactivos.service;

import java.util.Date;
import java.util.List;

import co.com.atenea.adminactivos.exceptions.ActivoFijoNotFoundException;
import co.com.atenea.adminactivos.modelo.ActivoFijo;

// TODO: Auto-generated Javadoc
/**
 * The Interface AdministracionActivosService.
 *
 * @author sanal
 */
public interface AdministracionActivosService {

	/**
	 * Gets the all activos.
	 *
	 * @return the all activos
	 */
	List<ActivoFijo> getAllActivos();

	/**
	 * Buscar activos por criterios.
	 *
	 * @param tipo the tipo
	 * @param fechaCompra the fecha compra
	 * @param serial the serial
	 * @return the list
	 */
	List<ActivoFijo> buscarActivosPorCriterios(ActivoFijo.TipoActivo tipo, Date fechaCompra, String serial);

	/**
	 * Creates the activo.
	 *
	 * @param activo the activo
	 * @return the activo fijo
	 */
	ActivoFijo createActivo(ActivoFijo activo);

	/**
	 * Update activo.
	 *
	 * @param id the id
	 * @param updatedActivo the updated activo
	 * @return the activo fijo
	 */
	ActivoFijo updateActivo(Long id, ActivoFijo updatedActivo);
}
