package co.com.atenea.adminactivos.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.atenea.adminactivos.modelo.ActivoFijo;

@Repository
public interface ActivosFijosRepository extends JpaRepository<ActivoFijo, Long>{

	List<ActivoFijo> findByTipoOrFechaCompraOrSerial(ActivoFijo.TipoActivo tipo, Date fechaCompra, String serial);
}
