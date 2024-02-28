/**
 * 
 */
package co.com.atenea.adminactivos.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanal
 *
 */
@Entity
@Table(name = "activos_fijos")
@Getter
@Setter
public class ActivoFijo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nombre;

	@Size(max = 255)
	private String descripcion;

	@Enumerated(EnumType.STRING)
	private TipoActivo tipo;

	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String serial;

	@NotNull
	private String numeroInventario;

	private Double peso;

	private Double alto;

	private Double ancho;

	private Double largo;

	@NotNull
	private Double valorCompra;

	@NotNull
	private Date fechaCompra;

	private Date fechaBaja;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_actual")
	private EstadoActivo estado;

	private String color;

	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;

	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "municipio_id")
	private Municipio municipio;

	public enum TipoActivo {
		INMUEBLE, MAQUINARIA, MATERIAL_OFICINA
	}

	public enum EstadoActivo {
		ACTIVO, DADO_DE_BAJA, EN_REPARACION, DISPONIBLE, ASIGNADO
	}

}