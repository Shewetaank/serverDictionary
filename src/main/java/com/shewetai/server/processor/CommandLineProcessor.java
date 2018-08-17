package com.shewetai.server.processor;

/**
 * Class is called from main application
 */
public class CommandLineProcessor {

    private String filePath;
    private String clientDictLocation;
    private String serverDictLocation;
    private FileProcessor fileProcessor;

    /**
     * Constructor to set the file locations
     * @param filePath
     * @param clientDictLocation
     * @param serverDictLocation
     */
    public CommandLineProcessor(String filePath, String clientDictLocation, String serverDictLocation){
        this.filePath = filePath;
        this.clientDictLocation = clientDictLocation;
        this.serverDictLocation = serverDictLocation;
        this.fileProcessor = new FileProcessor();
    }

    /**
     * process method used to parse the file and create outputs
     */
    public void process() {
        fileProcessor.process(this.filePath, this.clientDictLocation, this.serverDictLocation);
    }
}
