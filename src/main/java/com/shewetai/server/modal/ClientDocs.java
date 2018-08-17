package com.shewetai.server.modal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Client Docs contaning list of the client nodes
 */
@XmlRootElement(name = "clientDocs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientDocs {

    @XmlElement(name = "doc")
    private List<ClientNode> clientNodes;

    public List<ClientNode> getClientNodes() {
        return clientNodes;
    }

    public void setClientNodes(List<ClientNode> clientNodes) {
        this.clientNodes = clientNodes;
    }
}
