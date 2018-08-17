To run the program please follow the steps below- 
1. Open intellij, click on Impoer Project.
2. Browse to the cloned directory of the project and click on build.gradle file.
3. Uncheck "Create sepearate module per source set". and select "Use gradle wrapper task configuration" and click OK.
4. If prompted in the code please --add-module=java.xml.bind
5. There is run configuraiton with the repo to run the program from IDE.
7. You can setup the program agrugments by your self. Please make sure that the directory for the program arguments exists. 
And the location to the client and server output is different than the input files.

To run from terminal- 
1.Create a jar artifiact form the IDE.
2. Use the following commond to execute the jar- 
java -jar dictionary.jar -src /Users/shewetaankindora/files -clientDir /Users/shewetaankindora/output/client -serverDir /Users/shewetaankindora/output/serve
3. Browse to the out directory for the server and client files. The output will be there. 

Note- In case the input files are missing the top nodes that particular file will be skipped and shown in the output of the program.

