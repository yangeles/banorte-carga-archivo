package com.bap.bpm.dto;

import java.util.Objects;

public class Documento {

    protected Integer contentLength;
    protected String mimeType;
    protected String fileName;
    protected String content;
    protected String idCliente;
    protected String processId;
    protected String tipoDocumento;

    public Integer getContentLength() {
        return contentLength;
    }

    public void setContentLength(Integer contentLength) {
        this.contentLength = contentLength;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documento documento = (Documento) o;
        return Objects.equals(getContentLength(), documento.getContentLength()) && Objects.equals(getMimeType(), documento.getMimeType()) && Objects.equals(getFileName(), documento.getFileName()) && Objects.equals(getContent(), documento.getContent()) && Objects.equals(getIdCliente(), documento.getIdCliente()) && Objects.equals(getProcessId(), documento.getProcessId()) && Objects.equals(getTipoDocumento(), documento.getTipoDocumento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContentLength(), getMimeType(), getFileName(), getContent(), getIdCliente(), getProcessId(), getTipoDocumento());
    }

    @Override
    public String toString() {
        return "Documento{" +
                "contentLength=" + contentLength +
                ", mimeType='" + mimeType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", content='" + content + '\'' +
                ", idCliente='" + idCliente + '\'' +
                ", processId='" + processId + '\'' +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                '}';
    }
}
