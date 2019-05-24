/**
 * NativeQueryRepositoryImp.java
 *
 * Creada el 20/10/2018, 12:28:22 PM
 *
 * Clase Java desarrollada por Julián Andrés Bolaños Ortega para la empresa Seratic Ltda el día 20/10/2018.
 *
 * Esta clase es confidencial y para uso de las aplicaciones de la empresa Seratic Ltda.
 * Prohibido su uso sin autorización explícita de personal autorizado de la empresa Seratic Ltda.
 *
 * Para información sobre el uso de esta clase, así como bugs, actualizaciones o mejoras
 * envíar un email a <seratic@seratic.com> o a <julian.bolanos@seratic.com>.
 */
package com.enterprise.usco.uvscannerservidor.repository;

import com.enterprise.usco.uvscannerservidor.data.DataUV;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ing. Julián Andrés Bolaños Ortega <julian.bolanos@seratic.com>
 * @version 1.0
 * @date 20/10/2018
 */
@Transactional
@Repository
public class NativeQueryRepositoryImp implements NativeQueryRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<DataUV> findLastTrack(Date fechaInferior, Date fechaSuperior) {
        List<DataUV> res = em.createNativeQuery("SELECT id,\n"
                + "  fecha_servidor,altitud,x(posicion) as latitud,\n"
                + "  y(posicion) as longitud,\n"
                + "  CAST( SUM(lectura)/COUNT(lectura) AS DECIMAL(10,2)) AS lectura ,\n"
                + "  CAST(  SUM(uvi)/COUNT(uvi) AS DECIMAL(10,2)) AS uvi\n"
                + "  FROM track WHERE fecha_servidor >= :fechaInferior AND fecha_servidor<=:fechaSuperior AND lectura IS NOT NULL GROUP BY YEAR(fecha_servidor),MONTH(fecha_servidor),DAY(fecha_servidor),HOUR(fecha_servidor),MINUTE(fecha_servidor) DIV 3 ORDER BY fecha_servidor ASC; ", DataUV.class)
                .setParameter("fechaInferior", fechaInferior)
                .setParameter("fechaSuperior", fechaSuperior)
                .getResultList();

        return res;
    }

}
