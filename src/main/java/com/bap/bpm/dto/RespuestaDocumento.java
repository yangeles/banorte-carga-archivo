package com.bap.bpm.dto;

import java.util.Objects;

public class RespuestaDocumento {

    protected String documentID;
    protected Boolean exito;
    protected String mensajeError;

    public RespuestaDocumento() {

    }

    public RespuestaDocumento(String documentID) {
        this.documentID = documentID;
        this.exito = true;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public Boolean getExito() {
        return exito;
    }

    public void setExito(Boolean exito) {
        this.exito = exito;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaDocumento that = (RespuestaDocumento) o;
        return Objects.equals(getDocumentID(), that.getDocumentID()) && Objects.equals(getExito(), that.getExito()) && Objects.equals(getMensajeError(), that.getMensajeError());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDocumentID(), getExito(), getMensajeError());
    }

    @Override
    public String toString() {
        return "RespuestaDocumento{" +
                "documentID='" + documentID + '\'' +
                ", exito=" + exito +
                ", mensajeError='" + mensajeError + '\'' +
                '}';
    }
}
