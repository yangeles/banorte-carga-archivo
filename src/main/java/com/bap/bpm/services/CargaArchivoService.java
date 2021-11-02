package com.bap.bpm.services;

import com.bap.bpm.dto.Documento;
import com.bap.bpm.dto.RespuestaDocumento;
import com.ibm.lombardi.schema.ArrayOfNameValuePair;
import com.ibm.lombardi.schema.NameValuePair;
import com.ibm.lombardi.schema.ObjectFactory;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import vd.documentows_tws.DocumentoWS;
import vd.documentows_tws.DocumentoWSPortType;

import javax.enterprise.context.ApplicationScoped;
import java.net.MalformedURLException;
import java.net.URL;

@ApplicationScoped
public class CargaArchivoService {

    @ConfigProperty(name = "bpm.documentows.url", defaultValue = "https://localhost:9444/teamworks/webservices/VD/documentoWS.tws?WSDL")
    protected String wsdlURL;

    public RespuestaDocumento cargarArchivo(Documento documento) throws MalformedURLException {
        DocumentoWS webService = new DocumentoWS(new URL(wsdlURL));

        ObjectFactory factory = new ObjectFactory();
        ArrayOfNameValuePair parametros = factory.createArrayOfNameValuePair();
        parametros.getItem().add(crearParametro(factory,"idCliente",documento.getIdCliente()));
        parametros.getItem().add(crearParametro(factory,"processId",documento.getProcessId()));
        parametros.getItem().add(crearParametro(factory,"tipoDocumento",documento.getTipoDocumento()));
        DocumentoWSPortType portType =  webService.getSoap12DocumentoWSSoap();
        String documentId = portType.guardarDocumento(documento.getContentLength(), documento.getMimeType(),
                documento.getFileName(), documento.getContent(), parametros);
        return new RespuestaDocumento(documentId);
    }

    protected NameValuePair crearParametro(ObjectFactory factory, String llave, String valor) {
        NameValuePair pair = factory.createNameValuePair();
        pair.setName(llave);
        pair.setValue(valor);
        return pair;
    }

}
