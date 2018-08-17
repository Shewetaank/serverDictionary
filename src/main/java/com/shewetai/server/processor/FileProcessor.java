package com.shewetai.server.processor;


import com.shewetai.server.enums.FileType;
import com.shewetai.server.modal.ClientDocs;
import com.shewetai.server.modal.ClientNode;
import com.shewetai.server.modal.ServerDocs;
import com.shewetai.server.modal.ServerNode;
import org.w3c.dom.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for processing the input files and generate client and server dictionary
 */
public class FileProcessor {

    private List<ClientNode> clientNodeData = new ArrayList<>();
    private List<ServerNode> serverNodeData = new ArrayList<>();
    private List<String> fileErrors = new ArrayList<>();

    /**
     * processes the input files and write the result to client and server locations
     * @param filePath
     * @param clientDictLocation
     * @param serverDictLocation
     */
    public void process(String filePath, String clientDictLocation, String serverDictLocation) {
        List<String> filesList = getFilesList(filePath);
        String clientFile = createFileAtLocation(clientDictLocation, FileType.CLIENT);
        String serverFile = createFileAtLocation(serverDictLocation, FileType.SERVER);
        // for each file parse the file and create client and server nodes
        filesList.forEach(p -> {
            processFile(p);
        });
        displayError();
        // write the created child and server node to the respective files
        writeToClientXMLFile(clientFile, new ClientDocs(){{ setClientNodes(clientNodeData);}});
        writeToServerXMLFile(serverFile, new ServerDocs(){{ setServerNodes(serverNodeData);}});
    }

    /**
     * Display all the file having problem while parsing
     */
    private void displayError() {
        if(fileErrors.size() > 0) {
            System.out.println("Error while parsing the following files: ");
            for (String val:
                    fileErrors) {
                System.out.println(val);
            }
            System.out.println("Still continuing writing the other data from other files to dictionary.");
        }
    }

    /**
     *
     * @param serverFile
     * @param serverDocs
     */
    private void writeToServerXMLFile(String serverFile, ServerDocs serverDocs) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ServerDocs.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(serverDocs, new File(serverFile));
        } catch (Exception e) {
            System.out.println("Exception thrown while creating the server XML file");
        }
    }

    /**
     * write to the client XML file
     * @param clientFile
     * @param clientDocs
     */
    private void writeToClientXMLFile(String clientFile, ClientDocs clientDocs) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ClientDocs.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(clientDocs, new File(clientFile));
        } catch (Exception e) {
            System.out.println("Exception thrown while creating the client XML file");
        }
    }

    /**
     * Create the XML files at location
     * @param dictLocation
     * @param type
     * @return
     */
    private String createFileAtLocation(String dictLocation, FileType type) {
        String path = dictLocation + "/" + type.getText() + ".xml";
        File f = new File(path);
        try{
            if(f.exists()){
                if(f.delete()){
                    f.createNewFile();
                }
            } else{
                f.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error while creating the file: " + path);
        }
        return path;
    }

    /**
     * process each and create the nodelist for client and server xmls
     * @param filePath
     */
    private void processFile(String filePath) {
        try {
            File file = new File(filePath);
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            if (doc.hasChildNodes()) {
                serverNodeData.add(writeToServerFile(doc));
                clientNodeData.add(writeToClientFile(doc));
            }
        } catch (Exception e) {
            fileErrors.add(filePath);
        }
    }

    /**
     * create client file nodes
     * @param doc
     * @return
     * @throws Exception
     */
    private ClientNode writeToClientFile(Document doc) throws Exception{
        return new ClientNode() {{
            setDocumentName(doc.getDocumentElement().getElementsByTagName("document_name").item(0)
                    .getFirstChild().getTextContent());
            setVersion(doc.getDocumentElement().getElementsByTagName("version").item(0)
                    .getFirstChild().getTextContent());
            setLength(doc.getDocumentElement().getElementsByTagName("data").item(0)
                    .getFirstChild().getTextContent().length());
        }};
    }

    /**
     * create server file nodes
     * @param doc
     * @return
     * @throws Exception
     */
    private ServerNode writeToServerFile(Document doc) throws Exception{
        return new ServerNode() {{
            setDocumentName(doc.getDocumentElement().getElementsByTagName("document_name").item(0)
                    .getFirstChild().getTextContent());
            setVersion(doc.getDocumentElement().getElementsByTagName("version").item(0)
                    .getFirstChild().getTextContent());
            setLength(doc.getDocumentElement().getElementsByTagName("data").item(0)
                    .getFirstChild().getTextContent().length());
            setPath(doc.getDocumentURI());

        }};
    }

    /**
     * get the list of the files
     * @param filePath
     * @return
     */
    public List<String> getFilesList(String filePath){
        List<String> results = new ArrayList<>();
        File[] files = new File(filePath).listFiles((dir, name) -> !name.equals(".DS_Store"));
        if(files != null){
            for (File file : files) {
                if (file.isFile()) {
                    results.add(file.getAbsolutePath());
                }
            }
        }
        return results;
    }
}
