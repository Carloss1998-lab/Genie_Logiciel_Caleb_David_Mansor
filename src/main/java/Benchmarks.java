package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Benchmarks {

	private String configurationsDirectoryPath;
	
	public Benchmarks(String path) {
		this.configurationsDirectoryPath = path;
	}
	
	public void launchBenchmarks(int nbSamples) throws IOException {
				
		File configurationsFolder = new File(this.configurationsDirectoryPath);
		File[] listOfFiles = configurationsFolder.listFiles();

		String benchResults = "Benchmark,Variant,Time(ms),Accuracy\n";

	    String pattern_string_acc = "Accuracy\\s:\\s([0-9]*['.'][0-9]*)";	    
		Pattern pattern = Pattern.compile(pattern_string_acc);
		String result = "";
		Float acc;
		String accString = "";
		Matcher matcher = null;
		long start;
		long end;
		
		long execTime;
		
		for (File file : listOfFiles) {
			
		    if (file.isFile()) {
		        System.out.println("\n"+file.getName());
				String path = Files.readString(Paths.get(this.configurationsDirectoryPath+file.getName()));
				ExecutorBuilder executorBuilder = new ExecutorBuilder(path);
				
				
				acc = (float) 0.0;
				
				//PYTHON

				executorBuilder.configuration.setTargetLanguage("PYTHON");
				executorBuilder.build();
				MLExecutor executorPy = executorBuilder.executor;	
				start = System.currentTimeMillis();
				for (int i = 0; i<nbSamples; i++) {
					result = executorPy.run().getStringResult();    
					matcher = pattern.matcher(result);
					matcher.find();	 
					acc = acc+Float.parseFloat(matcher.group(1));
				}
				end  = System.currentTimeMillis();
				execTime = (end-start)/nbSamples;
				acc = acc/nbSamples;
				accString = Float.toString(acc);
				benchResults = benchResults+file.getName()+",ScikitLearn,"+execTime+","+accString+"\n";
				
				
				//R
				
				executorBuilder.configuration.setTargetLanguage("R");
				executorBuilder.build();
				MLExecutor executorR = executorBuilder.executor;
				start = System.currentTimeMillis();
				for (int i = 0; i<nbSamples; i++) {
					result = executorR.run().getStringResult();    
					matcher = pattern.matcher(result);
					matcher.find();	 
					acc = acc+Float.parseFloat(matcher.group(1));
				}
				end  = System.currentTimeMillis();
				execTime = (end-start)/nbSamples;
				acc = acc/nbSamples;
				benchResults = benchResults+file.getName()+",R,"+execTime+","+accString+"\n";

				//JULIA
				executorBuilder.configuration.setTargetLanguage("JULIA");
				executorBuilder.build();
				MLExecutor executorJul = executorBuilder.executor;
				executorJul.generateCode();		
				start = System.currentTimeMillis();		
				for (int i = 0; i<nbSamples; i++) {
					result = executorJul.run().getStringResult();  
					String pattern_string_acc_jl = "([0-9]*['.'][0-9]*)";
					Pattern patternjl = Pattern.compile(pattern_string_acc_jl);
					matcher = patternjl.matcher(result);
					matcher.find();
					acc = acc+Float.parseFloat(matcher.group(1));
				}
				end  = System.currentTimeMillis();
				execTime = (end-start)/nbSamples;
				acc = acc/nbSamples;
				benchResults = benchResults+file.getName()+",JULIA"+","+execTime+","+acc+"\n";
								

		    }
		    
			
			try {
			      FileWriter myWriter = new FileWriter("benchresults.csv");
			      myWriter.write(benchResults);
			      myWriter.close();
			      System.out.println("\nSuccessfully wrote to the file.");
			    } catch (IOException e) {
			      System.out.println("\nAn error occurred.");
			      e.printStackTrace();
			    }

		}
		
		
	}

}
