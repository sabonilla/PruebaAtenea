package co.com.atenea.adminactivos.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * O
 * @author sanal
 *
 */

@Entity
@Table(name = "areas")
@Getter
@Setter
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_area")
    private Long id;

    private String nombre;
    
    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;
}
