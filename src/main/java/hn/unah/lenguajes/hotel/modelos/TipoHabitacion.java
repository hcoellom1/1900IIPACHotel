package hn.unah.lenguajes.hotel.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tipohabitacion")
@Data
public class TipoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigotipohabitacion")
    private long codigoTipoHabitacion;

    private String descripcion;

    @Column(name="valoradicional")
    private double valorAdicional;

    
}
