package main.java;
import java.nio.file.Files;
import java.nio.file.Paths;



public class MMLMain {


	public static void main(String[] args) throws Exception {
		
		
		//Reading the path of the configuration file. If no file is given when executing the code, the
	   //configuration file to use is to be set here.
	   String path = null;

		if(args.length == 0){
			path = Files.readString(Paths.get("mml2.json"));

		}
		else{
			path = Files.readString(Paths.get(args[0]));
		}
		
						
		//Building an executor according to the specified configuration file and generating the code		
		
	    /*ExecutorBuilder executorBuilder = new ExecutorBuilder(path);
		executorBuilder.build();
		MLExecutor executor = executorBuilder.executor;
	    executor.generateCode();*/
		
		
	    //The results are displayed	in the terminal   
		//System.out.print(executor.run().getStringResult());
		
		
		new Benchmarks("benchmarks/").launchBenchmarks(5);
		
		
		
		//To use SPARKJAVA 	
		//String htmlResult = executor.run().getStringHtml();
		//get("/results", (req, res) -> htmlResult);
				  
		
	}

}
