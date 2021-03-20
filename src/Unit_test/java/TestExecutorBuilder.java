package Unit_test.java;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import main.java.MLExecutor;
import main.java.RLanguageMLExecutor;
import main.java.JuliaLanguageMLExecutor;
import main.java.PythonMLExecutor;
import main.java.ExecutorBuilder;



public class TestExecutorBuilder {
	

	@After
	public void tearDown () throws Exception{
		
	}
	
	@Test
	public void testRExecutorBuilter() {
		String config_file = "mml.json";
		String path=null;
		try {
			 path= Files.readString(Paths.get(config_file));
		} catch (IOException e) {
			e.printStackTrace();
		}					
		
		
		ExecutorBuilder executorBuilder = new ExecutorBuilder(path);
		executorBuilder.build();
		MLExecutor executor = executorBuilder.executor;
	    assertTrue(executor instanceof  RLanguageMLExecutor);
		
	}
	
	@Test
	public void testJuliaExecutorBuilter() {
		String config_file = "mml1.json";
		String path=null;
		try {
			 path= Files.readString(Paths.get(config_file));
		} catch (IOException e) {
			e.printStackTrace();
		}					
		
				
		ExecutorBuilder executorBuilder = new ExecutorBuilder(path);
		executorBuilder.build();
		MLExecutor executor = executorBuilder.executor;
		assertTrue(executor instanceof  JuliaLanguageMLExecutor);
		
	}
	
	@Test
	public void testPythonExecutorBuilter() {
		String config_file = "mml2.json";
		String path=null;
		try {
			 path= Files.readString(Paths.get(config_file));
		} catch (IOException e) {
			e.printStackTrace();
		}					
								
		ExecutorBuilder executorBuilder = new ExecutorBuilder(path);
		executorBuilder.build();
		MLExecutor executor = executorBuilder.executor;
		assertTrue(executor instanceof  PythonMLExecutor);
		
	}
	
	


	
	


}
