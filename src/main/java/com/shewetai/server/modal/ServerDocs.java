package com.shewetai.server.modal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Server Docs used to create the list of server nodes
 */
@XmlRootElement(name = "serverDocs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServerDocs {


    @XmlElement(name = "doc")
    private List<ServerNode> serverNodes;


    public List<ServerNode> getServerNodes() {
        return serverNodes;
    }

    public void setServerNodes(List<ServerNode> serverNodes) {
        this.serverNodes = serverNodes;
    }
}