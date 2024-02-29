package co.com.atenea.adminactivos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.atenea.adminactivos.exceptions.AreaCustomException;
import co.com.atenea.adminactivos.modelo.Area;
import co.com.atenea.adminactivos.repository.AreasRepository;
import co.com.atenea.adminactivos.service.AreaService;

// TODO: Auto-generated Javadoc
/**
 * The Class AreaServiceImpl.
 */
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreasRepository areasRepository;
	
	/**
	 * Gets the all areas.
	 *
	 * @return the all areas
	 */
	@Override
	public List<Area> getAllAreas() throws AreaCustomException{
		return areasRepository.findAll();
	}

}
