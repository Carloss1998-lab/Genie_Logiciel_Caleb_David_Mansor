package main.java;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MMLMain {


	public static void main(String[] args) throws Exception {
		

		
		String path = null;
		if(args.length== 0){
			path = Files.readString(Paths.get("mml2.json"));
		}
		else{
			path = Files.readString(Paths.get(args[0]));
		}
				
		
		//ConfigurationML configuration_ml = new ConfigurationML(path);
		//JsonExtractor json_extractor = new JsonExtractor(path);
		//json_extractor.Extract_information();
						
		
		MLExecutor executor = new ExecutorBuilder().build(path);

		executor.generateCode();
		
	    System.out.println("\n\n\n################################\n##########  RESULTS  ###########\n################################\n\n");	

		System.out.print(executor.run().getStringResult());	
		
	}

}
