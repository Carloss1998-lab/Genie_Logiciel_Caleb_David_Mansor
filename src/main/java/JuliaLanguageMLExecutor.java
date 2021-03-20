package main.java;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.common.io.Files;
//import java.util.regex.*;
import org.json.JSONArray;

public class JuliaLanguageMLExecutor extends MLExecutor {

	private static final String JULIA_OUTPUT = "foofile.jl";
		
	public JuliaLanguageMLExecutor(ConfigurationML configuration) {
		this.configuration = configuration;
	}

	public void generateCode() throws IOException {
		
		String file_path = configuration.getFilePath();
		String target = configuration.getTarget();
		JSONArray predictive_Varies = configuration.getPredictiveVariables();

		// R code 
		String Juliacode = "using Pkg\n" + "using DataFrames \n" + "using DecisionTree \n" + "using CSV \n"
				+ "using ScikitLearn\n" + "\n" + "\n" + abl"# the dataset\n"
				+ "df = CSV.read(\""+ file_path +"\""+", DataFrame; header = 1)\n"
				+ "# Spliting dataset between features (X) and label (y)\n" + "\n"
				+ "X = convert(Array, df[:, "+ predictive_Variables.toString()+"]);\n"
				+ "y = convert(Array, df[:, \""+target+"\"]);\n" + "\n" + "model = DecisionTreeClassifier(max_depth=2)\n"
				+ "fit!(model, X, y)\n" + "\n" + "using ScikitLearn.CrossValidation: cross_val_score\n"
				+ "accuracy = cross_val_score(model, X, y, cv=3)\n"
				+ "println(\"Accuracy : \",accuracy[3])\n";
		
		// serialize code into Python filename
		
		Files.write(Juliacode.getBytes(), new File(JULIA_OUTPUT));



	}

	public MLResult run() throws IOException {
		// execute the generated Julia code
		Process p = Runtime.getRuntime().exec("julia " + JULIA_OUTPUT);
		

		// output
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

		// error
		BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

		String result = "";

		String o;
		while ((o = stdInput.readLine()) != null) {

			result += "\n";
			result += o;
		}

		String err;
		while ((err = stdError.readLine()) != null) {
			result += err;
		}

		result = "\n\n\n################################\n##########  RESULTS  ###########\n################################\n\n" + result;
		return new MLResult(result,configuration);

	}

}
