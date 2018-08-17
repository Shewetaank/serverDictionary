package com.shewetai.server.modal;


/**
 * Base Node extended by Server and Client Nodes
 */
public class BaseNode {

    private String document_name;
    private String version;
    private long length;

    public String getDocumentName() {
        return document_name;
    }

    public void setDocumentName(String documentName) {
        this.document_name = documentName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }
}