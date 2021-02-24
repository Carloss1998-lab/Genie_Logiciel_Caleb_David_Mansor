package main.java;

public class ExecutorBuilder{

    public MLExecutor build(JsonExtractor json_extractor ) {
    	
    	
    	
    	MLExecutor executor = null;
		ConfigurationML configuration = new ConfigurationML(json_extractor);

    	if (json_extractor.language.equals("PYTHON")) {			
    		executor = new PythonMLExecutor(configuration);				
    	}		
    	else if (json_extractor.language.equals("R")) {			
    		executor = new RLanguageMLExecutor(configuration);			
    	}
    	
    	else if (json_extractor.language.equals("JULIA")) {
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
	System.out.println("Target langage: "+ json_extractor.language);
	System.out.println("Dataset: "+json_extractor.file_name);
	System.out.println("Predictive variables: "+ json_extractor.predictive_Variables);
	System.out.println("Target variable: "+ json_extractor.target_variable);
	System.out.println("Train data proportion: " + json_extractor.training_size );


		return executor;		
    	
    }
	
}
