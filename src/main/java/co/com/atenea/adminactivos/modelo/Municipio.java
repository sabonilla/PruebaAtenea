/**
 * 
 */
package co.com.atenea.adminactivos.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanal
 *
 */
@Entity
@Table(name="municipios")
@Getter
@Setter
public class Municipio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_municipio")
	private Integer id;

	@Column(name = "municipio", nullable = false)
	private String nombre;

	@Column(name = "estado", nullable = false)
	private Integer estado;

	@Column(name = "departamento_id", nullable = false)
	private Integer departamentoId;
}
