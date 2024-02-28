/**
 * 
 */
package co.com.atenea.adminactivos.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.atenea.adminactivos.exceptions.ActivoFijoNotFoundException;
import co.com.atenea.adminactivos.exceptions.FechasInvalidasException;
import co.com.atenea.adminactivos.modelo.ActivoFijo;
import co.com.atenea.adminactivos.repository.ActivosFijosRepository;
import co.com.atenea.adminactivos.service.AdministracionActivosService;
import lombok.extern.log4j.Log4j2;

/**
 * @author sanal
 *
 */
@Service
@Log4j2
public class AdministracionActivosServiceImpl implements AdministracionActivosService {

	@Autowired
	private ActivosFijosRepository activosFijosRepository;

	@Override
	public List<ActivoFijo> getAllActivos() {
		return activosFijosRepository.findAll();
	}

	@Override
	public List<ActivoFijo> buscarActivosPorCriterios(ActivoFijo.TipoActivo tipo, Date fechaCompra, String serial) {
        return activosFijosRepository.findByTipoOrFechaCompraOrSerial(tipo, fechaCompra, serial);
    }

	@Transactional
	@Override
	public ActivoFijo createActivo(ActivoFijo activo) throws FechasInvalidasException {
		if (!fechasValidas(activo)) {
			log.error("Las fechas no son válidas");
			throw new FechasInvalidasException("Las fechas no son válidas para el activo: " + activo.getNombre());
		}
		return activosFijosRepository.save(activo);
	}

	@Override
	public ActivoFijo updateActivo(Long id, ActivoFijo updatedActivo) {

		if (updatedActivo == null || id == null) {
			throw new IllegalArgumentException("El Activo o el ID no pueden ser nulos");
		}

		if (!fechasValidas(updatedActivo)) {

			log.error("Las fechas no son válidas");
			throw new FechasInvalidasException("Las fechas no son válidas para el activo: " + id);
		}
		// Buscar el alumno a editar
		ActivoFijo activoEncontrado = activosFijosRepository.findById(id)
				.orElseThrow(() -> new ActivoFijoNotFoundException(updatedActivo.getId()));

		activoEncontrado.setFechaBaja(updatedActivo.getFechaBaja());
		activoEncontrado.setSerial(updatedActivo.getSerial());

		return activosFijosRepository.save(activoEncontrado);
	}

	private boolean fechasValidas(ActivoFijo activoFijo) {
		// Implementar la lógica para validar las fechas
		Date fechaCompra = activoFijo.getFechaCompra();
		Date fechaBaja = activoFijo.getFechaBaja();

		// Verificar que la fecha de baja sea anterior o igual a la fecha de compra
		return fechaBaja == null || !fechaBaja.after(fechaCompra);
	}

}
