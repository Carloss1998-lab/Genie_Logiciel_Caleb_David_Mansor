package main.java;


import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.common.graph.ElementOrder.Type;

import org.checkerframework.common.reflection.qual.GetClass;
import org.json.JSONArray;
import org.json.JSONObject;

public class MMLMain {


	public static void main(String[] args) throws Exception {
		
		// variation points
		// dataset : not only iris.csv
		// training / testing split: not only 0.7 / 0.3
		// predictive variables/target: all except "variety"
		// ML metric: not only accuracy 
		
		//System.err.println(args[0]);
		// System.err.println(args[1]);
		//System.out.println(args.length);

		String str = null;
		if(args.length== 0){
			str = Files.readString(Paths.get("mml1.json"));
		}
		else{
			str = Files.readString(Paths.get(args[0]));
		}
		//String str = Files.readString(Paths.get("mml.json"));
		
		
		
		// String str = "{ \"file_path\": \"iris.csv\", \"target\": 'variety' }";
		
		/*
		String str = "{\n"
				+ " \"dataset\": {\n"
				+ "   \"filename\" : \"iris.csv\",\n"
				+ "   \"separator\" : \",\"\n"
				+ " },\n"
				+ " \"training\": 70,\n"
				+ " \"testing\": 30, \n"
				+ " \"target_variable\": \"species\",\n"
				+ " \"metrics\" : [\"accuracy\", \"precision\"]\n"
				+ "  \n"
				+ "}";
				*/
		
		JSONObject obj = new JSONObject(str);
		JSONObject d = (JSONObject) obj.get("dataset");
		String filename = d.getString("filename");
		String separator = d.getString("separator"); // 
		String target_variable = obj.getString("target_variable"); // args[1]
		float training_size = obj.getFloat("train_size"); // 
		String language = obj.getString("targetLanguage");
		JSONArray metrics = obj.getJSONArray("metrics");
		JSONArray predictive_Variables = obj.getJSONArray("predictive_Variables");
		ConfigurationML configuration = new ConfigurationML(filename, 
				target_variable,separator,language, training_size, metrics, 
				predictive_Variables);
		String target_langage = language; //

		System.out.println("Target langage: "+ target_langage);
		System.out.println("Dataset: "+filename);
		System.out.println("Predictive variables: "+ predictive_Variables);
		System.out.println("Target variable: "+ target_variable);

		// TODO: instead of command line arguments, we will use JSON files to configure the compilers
		// YAML, JSON, XML, etc.
		//ConfigurationML configuration = new ConfigurationML(args[0], args[1]);
		MLExecutor ex = null;
		
		if (target_langage.equals("PYTHON")) {			
			ex = new PythonMLExecutor(configuration);				
		}		
		else if (target_langage.equals("R")) {			
			ex = new RLanguageMLExecutor(configuration);			
		}
		
		else if (target_langage.equals("JULIA")) {
			// ex = new JuliaMLExecutor();
			System.err.println("Unsupported target language (TODO)");
			// TODO
			
		}
		else {
			System.err.println("Unrecognized target language");
			// TODO 
		}		
		ex.generateCode();
		System.out.print(ex.run().getStringResult());	
		
	}

}
