package com.shewetai.server.modal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Server node containing the elements for the XML file
 */
@XmlRootElement(name = "doc")
@XmlAccessorType(XmlAccessType.FIELD)
public class ServerNode extends BaseNode {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
