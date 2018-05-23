/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.sampleprj.dao.mybatis.mappers;

import edu.eci.pdsw.samples.entities.Tema;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Tatiana
 */
public interface TemaMapper {

    default Tema consultarTema(int temId) {
        return consultarTemaGeneral(temId, null).get(0);
    }

    public List<Tema> consultarTemaGeneral(@Param("temId") Integer temId, @Param("matID") Integer matID);

    default List<Tema> consultarTemas() {
        return consultarTemaGeneral(null, null);
    }

    default List<Tema> consultaTemasMateria(int materiaID){
        return consultarTemaGeneral(null, materiaID);
    }

    public void registroTemaMonitoria(@Param("asID") int asesoriaID,
            @Param("carnet") int codigoInt,
            @Param("temaID") Integer temaID);

    public void insertarTema(@Param("matID") int materiaID, @Param("tema") String tema, @Param("desc") String descripcion);

    public void deleteTema(@Param("temID") Integer id);

    public void actualizarTema(@Param("temID") int temaId, @Param("tema")String topic, @Param("desc") String descripcion);

}
