package co.com.atenea.adminactivos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.atenea.adminactivos.modelo.Area;
import co.com.atenea.adminactivos.repository.AreasRepository;
import co.com.atenea.adminactivos.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreasRepository areasRepository;
	
	@Override
	public List<Area> getAllAreas() {
		return areasRepository.findAll();
	}

}
