package main.java;

public class ExecutorBuilder{
	
	ConfigurationML configuration;
	String configurationDisplay;
	public MLExecutor executor;				  

	
	public ExecutorBuilder(String path) {
		
		this.configuration = new ConfigurationML(path);    	
    	
		}
	
	public void build() {
		

		
		System.err.println(this.configuration.getTargetLanguage());

		if (this.configuration.getTargetLanguage().equals("PYTHON")) {			
    		this.executor = new PythonMLExecutor(this.configuration);				
    	}		
    	else if (this.configuration.getTargetLanguage().equals("R")) {			
    		this.executor = new RLanguageMLExecutor(this.configuration);			
    	}
    	
    	else if (this.configuration.getTargetLanguage().equals("JULIA")) {
    		this.executor = new JuliaLanguageMLExecutor(this.configuration);
    	}

		else {
			System.err.println("Unrecognized target language");
			this.executor = null;
	}
	
}
}