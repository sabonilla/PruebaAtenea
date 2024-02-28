package co.com.atenea.adminactivos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.atenea.adminactivos.modelo.Area;
import co.com.atenea.adminactivos.service.AreaService;

/**
 * 
 * @author sanal
 *
 */
@RestController
@RequestMapping("/api/area")
public class AreasController {
	
	@Autowired
	private AreaService areaService;

	@GetMapping
	public ResponseEntity<List<Area>> getAllAreas(){
		return ResponseEntity.ok(areaService.getAllAreas());
	}
}
