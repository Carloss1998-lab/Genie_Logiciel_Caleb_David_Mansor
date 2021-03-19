package Unit_test.java;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertTrue;

import main.java.MLExecutor;
import main.java.PythonMLExecutor;
import main.java.RLanguageMLExecutor;
import main.java.ExecutorBuilder;
import main.java.JuliaLanguageMLExecutor;

public class TestExecutorBuilder {
	String path;
	@Before
	public void setUp() throws Exception{
		// TODO Auto-generated constructor stub

		String config_file = "mml.json";
		try {
			 path= Files.readString(Paths.get(config_file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
		/*JsonExtractor json_extractor = new JsonExtractor(path);
		json_extractor.Extract_information();*/

	}
	@After
	public void tearDown () throws Exception{
		
	}
	@Test
	public void testRExecutorBuilter() {
		String config_file = "mml.json";
		try {
			 path= Files.readString(Paths.get(config_file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
		/*JsonExtractor json_extractor = new JsonExtractor(path);
		json_extractor.Extract_information();*/
		
				
		MLExecutor executor = new ExecutorBuilder().build(path);
		assertTrue(executor instanceof  RLanguageMLExecutor);
		
	}
	@Test
	public void testJuliaExecutorBuilter() {
		String config_file = "mml1.json";
		try {
			 path= Files.readString(Paths.get(config_file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
		/*JsonExtractor json_extractor = new JsonExtractor(path);
		json_extractor.Extract_information();*/
		
				
		MLExecutor executor = new ExecutorBuilder().build(path);
		assertTrue(executor instanceof  JuliaLanguageMLExecutor);
		
	}
	@Test
	public void testPythonExecutorBuilter() {
		String config_file = "mml2.json";
		try {
			 path= Files.readString(Paths.get(config_file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}					
		/*JsonExtractor json_extractor = new JsonExtractor(path);
		json_extractor.Extract_information();*/
		
				
		MLExecutor executor = new ExecutorBuilder().build(path);
		assertTrue(executor instanceof  PythonMLExecutor);
		
	}
	
	


}
