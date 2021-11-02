package com.bap.bpm.resource;

import com.bap.bpm.dto.Documento;
import com.bap.bpm.dto.RespuestaDocumento;
import com.bap.bpm.services.CargaArchivoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/archivo")
public class CargaArchivoResource {

    protected Logger logger = LoggerFactory.getLogger(CargaArchivoResource.class);

    @Inject
    protected CargaArchivoService cargaArchivoService;

    @POST
    public RespuestaDocumento cargarArchivo(Documento documento) {
        try {
            return cargaArchivoService.cargarArchivo(documento);
        } catch (Throwable e) {
            logger.error("Error al cargar archivo ",e);
            RespuestaDocumento respuesta = new RespuestaDocumento();
            respuesta.setExito(false);
            respuesta.setMensajeError(e.getMessage());
            return respuesta;
        }
    }


}
