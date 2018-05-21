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

    public Tema consultarTema(@Param("id") int temId);

    public void insertarCliente(@Param("tema") Tema tema);

    public List<Tema> consultarTemas();

    public void registroTemaMonitoria(@Param("asID") int asesoriaID,
            @Param("carnet") int codigoInt,
            @Param("temaID") Integer temaID);
}
