package co.com.atenea.adminactivos.service;

import java.util.Date;
import java.util.List;

import co.com.atenea.adminactivos.modelo.ActivoFijo;

/**
 * 
 * @author sanal
 *
 */
public interface AdministracionActivosService {

	List<ActivoFijo> getAllActivos();

	List<ActivoFijo> buscarActivosPorCriterios(ActivoFijo.TipoActivo tipo, Date fechaCompra, String serial);

	ActivoFijo createActivo(ActivoFijo activo);

	ActivoFijo updateActivo(Long id, ActivoFijo updatedActivo);
}
