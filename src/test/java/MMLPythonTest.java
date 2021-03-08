package test.java;


import java.nio.file.Files;
import java.nio.file.Paths;


import org.junit.Test;

import main.java.ExecutorBuilder;

import main.java.MLExecutor;


public class MMLPythonTest {
	
	
	@Test
	public void testPython1() throws Exception {
		
		String config_file = "mml.json";
		System.out.println("\n************* Configuration File: " + config_file + " *****************\n");
		
		String path = Files.readString(Paths.get(config_file));					
		/*JsonExtractor json_extractor = new JsonExtractor(path);
		json_extractor.Extract_information();*/
				
		MLExecutor executor = new ExecutorBuilder().build(path);

		executor.generateCode();
	    System.out.println("\n\n\n################################\n##########  RESULTS  ###########\n################################\n\n");	
		System.out.print(executor.run().getStringResult());
		
	}

	@Test
	public void testPython2() throws Exception {
		
		
		String config_file = "mml1.json";
		System.out.println("\n\n************* Configuration File: " + config_file + " *****************\n\n");
		
		String path = Files.readString(Paths.get(config_file));					
		/*JsonExtractor json_extractor = new JsonExtractor(path);
		json_extractor.Extract_information();*/
				
		MLExecutor executor = new ExecutorBuilder().build(path);

		executor.generateCode();
		System.out.print(executor.run().getStringResult());
		
}
	
	@Test
	public void testPython3() throws Exception {
		
		String config_file = "mml2.json";
		
		System.out.println("\n\n************* Configuration File: " + config_file + " *****************\n\n");
		
		String path = Files.readString(Paths.get(config_file));					
		//JsonExtractor json_extractor = new JsonExtractor(path);
		//json_extractor.Extract_information();
				
		//MLExecutor executor = new ExecutorBuilder().build(json_extractor);
		
		MLExecutor executor = new ExecutorBuilder().build(path);


		executor.generateCode();
	    System.out.println("\n\n\n################################\n##########  RESULTS  ###########\n################################\n\n");	
		System.out.print(executor.run().getStringResult());
		
	}
	
	
	@Test
	public void testPython4() throws Exception {
		
		String config_file = "mml3.json";
		
		System.out.println("\n\n************* Configuration File: " + config_file + " *****************\n\n");
		
		String path = Files.readString(Paths.get(config_file));					
		/*JsonExtractor json_extractor = new JsonExtractor(path);
		json_extractor.Extract_information();*/
				
		MLExecutor executor = new ExecutorBuilder().build(path);

		executor.generateCode();
	    System.out.println("\n\n\n################################\n##########  RESULTS  ###########\n################################\n\n");	
		System.out.print(executor.run().getStringResult());
		
	}
}
