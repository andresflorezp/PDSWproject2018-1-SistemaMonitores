/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Profesor;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author sergiort
 */
public interface ProfesorMapper {
    
    default Profesor consultarProfesor(Long carnet){
        return consultaProfesorGeneral(carnet).get(0);
    }

    default List<Profesor> consultarProfesores() {
        return consultaProfesorGeneral(null);
    }
        
    public List<Profesor> consultaProfesorGeneral(@Param("proID") Long carnet);

    public void agregarProfesor(@Param("codID") Integer codigoID,
                                @Param("nom") String nombre,
                                @Param("apell") String apellido,
                                @Param("mail") String correo,
                                @Param("tel") Long telefono);
    
    public void actualizarProfesor(@Param("id") int codigoID,
                                @Param("nom") String nombre,
                                @Param("apell") String apellido,
                                @Param("mail") String correo,
                                @Param("tel") long telefono);

    public void deleteProfesor(@Param("id") Integer codigo);
}
