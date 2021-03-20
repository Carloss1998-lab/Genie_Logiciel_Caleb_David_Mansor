package Unit_test.java;
import org.junit.Test;
import main.java.ConfigurationML;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.assertEquals;

public class TestConfigurationML {
	
	String path;
	@Before
	public void setUp() throws Exception{

		String config_file = "mml.json";
		try {
			 path= Files.readString(Paths.get(config_file));
		} catch (IOException e) {
			e.printStackTrace();
		}					
		
	}
	
	
	@After
	public void tearDown () throws Exception{
		
	}
	
	@Test
	public void testConfigurationML() {		
				
		ConfigurationML configuration= new ConfigurationML(path);
		assertEquals(configuration.getTargetLanguage(),"R");
		assertEquals(configuration.getFilePath(),"iris.csv");
		assertEquals(configuration.getTarget(),"variety");
		assertEquals(Float.toString(configuration.getTrainSize()), "0.7");
		
	}

}
