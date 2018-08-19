To run the program please follow the steps below for Intllij- 
1. Open intellij, click on Impoer Project.
2. Browse to the cloned directory of the project and click on build.gradle file.
3. Uncheck "Create sepearate module per source set". and select "Use gradle wrapper task configuration" and click OK.
4. If prompted in the code please --add-module=java.xml.bind
5. There is run configuraiton with the repo to run the program from IDE.
7. You can setup the program agrugments by your self. Please make sure that the directory for the program arguments exists. 
And the location to the client and server output is different than the input files.

To run the program in Eclipse please use the following- 
1. Launch eclipse. Go to file and import.
2. Select gradle to import to project in the workspace. 
3. Gradle should build the project and add all the depenendies to the classpath. 
4. Go to run and click on Run Configurations.
5. Create a JAVA application run configuration. Set the project directory as "Dictionary" and Main class as "App".
6. In the arguments tab set the Set the program arguments something like below- 
-src /Users/shewetaankindora/files -clientDir /Users/shewetaankindora/output/client -serverDir /Users/shewetaankindora/output/server
7. Save and click run.
8. The console gives the output path to the server and client XML files.

To run from terminal- 
1.Create a jar artifiact form the IDE.
2. Use the following commond to execute the jar- 
java -jar dictionary.jar -src /Users/shewetaankindora/files -clientDir /Users/shewetaankindora/output/client -serverDir /Users/shewetaankindora/output/serve
3. Browse to the out directory for the server and client files. The output will be there. 

Note- In case the input files are missing the top nodes that particular file will be skipped and shown in the output of the program.
A good practice to add some test cases but I have not added them for this task.
