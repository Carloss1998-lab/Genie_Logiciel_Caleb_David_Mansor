package main.java;

public class ExecutorBuilder{

    public MLExecutor build(String path ) {
    	
    	
    	
    	MLExecutor executor = null;
		ConfigurationML configuration = new ConfigurationML(path);

    	if (configuration.getTargetLanguage().equals("PYTHON")) {			
    		executor = new PythonMLExecutor(configuration);				
    	}		
    	else if (configuration.getTargetLanguage().equals("R")) {			
    		executor = new RLanguageMLExecutor(configuration);			
    	}
    	
    	else if (configuration.getTargetLanguage().equals("JULIA")) {
			// executor = new JuliaMLExecutor();
			executor = new JuliaLanguageMLExecutor(configuration);
    		//System.err.println("Unsupported target language (TODO)");
    		// TODO
    }
	
    	
		
	else {
		System.err.println("Unrecognized target language");
		// TODO 
	}
	
    System.out.println("################################\n#########Configurations#########\n################################\n\n");	
	System.out.println("Target langage: "+ configuration.getTargetLanguage());
	System.out.println("Dataset: "+configuration.getFilePath());
	System.out.println("Predictive variables: "+ configuration.getPredictiveVariables());
	System.out.println("Target variable: "+ configuration.getTarget());
	System.out.println("Train data proportion: " + configuration.getTrainSize());


		return executor;		
    	
    }
	
}
