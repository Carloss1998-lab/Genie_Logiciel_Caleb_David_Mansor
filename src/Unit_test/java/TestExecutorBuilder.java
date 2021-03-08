package Unit_test.java;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertTrue;

import main.java.MLExecutor;
import main.java.ExecutorBuilder;

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
	public void testExecutorInstance() {
		
				
		MLExecutor executor = new ExecutorBuilder().build(path);
		assertTrue(executor instanceof MLExecutor);
		
	}

	
	


}
