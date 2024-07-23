package hn.unah.lenguajes.hotel.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.hotel.modelos.TipoHabitacion;
import hn.unah.lenguajes.hotel.repositorios.TipoHabitacionRepositorio;


@Service
public class TipoHabitacionServicio {
    
    @Autowired
    private TipoHabitacionRepositorio tipoHabitacionRepositorio;

    public List<TipoHabitacion> obtenerTiposHabitacion(){
        return this.tipoHabitacionRepositorio.findAll();
    }


    public TipoHabitacion crearHabitacion(String descripcion, double valorAdicional){
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        tipoHabitacion.setDescripcion(descripcion);
        tipoHabitacion.setValorAdicional(valorAdicional);
        return this.tipoHabitacionRepositorio.save(tipoHabitacion);
    }

    public TipoHabitacion buscarPorId(long id){
        return this.tipoHabitacionRepositorio.findById(id).get();
    }

    public String eliminarPorId(long id){
        if(this.tipoHabitacionRepositorio.existsById(id)){
            this.tipoHabitacionRepositorio.deleteById(id);
            return "Se ha eliminado el registro";
        }

        return "No existe el registro";
    }

    public TipoHabitacion actualizarPorId(long id, TipoHabitacion tipoHabitacion){
        if(this.tipoHabitacionRepositorio.existsById(id)){
            TipoHabitacion tipoHabitacionActulizar = this.tipoHabitacionRepositorio.findById(id).get();
            tipoHabitacionActulizar.setDescripcion(tipoHabitacion.getDescripcion());
            tipoHabitacionActulizar.setValorAdicional(tipoHabitacion.getValorAdicional());
            this.tipoHabitacionRepositorio.save(tipoHabitacionActulizar);
            return tipoHabitacionActulizar;
        }

        return null;
    }

}
