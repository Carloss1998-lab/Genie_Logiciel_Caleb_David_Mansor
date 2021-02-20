package main.java;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.common.io.Files;
import java.util.regex.*;

public class RLanguageMLExecutor extends MLExecutor {

	private static final String R_OUTPUT = "foofile.R";
		
	public RLanguageMLExecutor(ConfigurationML configuration) {
		this.configuration = configuration;
	}

	public void generateCode() throws IOException {
		
		String file_path = configuration.getFilePath();
		String target = configuration.getTarget();
		String separator = configuration.getSeparator();
		float train_size = configuration.getTrainSize();

		// R code 
		String Rcode = "library(rpart)\n"
				+ "\n"
				+ "dataset = read.csv('"+ file_path +"',sep=\"" + separator+ "\")\n"
				+ "\n"
				+ "# Spliting dataset into training set and test set\n"
				+ "train_ind = sample(1:nrow(dataset), size = nrow(dataset)*" + Float.toString(train_size)+ ")\n"
				+ "\n"
				+ "train = dataset[train_ind, ]\n"
				+ "X_test = dataset[-train_ind, -which(colnames(dataset) ==\""+target+"\")]\n"
				+ "y_test = as.factor(dataset[-train_ind, which(colnames(dataset) ==\""+target+"\")])\n"
				+ "\n"
				+ "model = rpart(formula = "+target+"~., data = train)\n"
				+ "\n"
				+ "pred = predict(model, X_test, type = 'class')\n"
				+ "\n"
				+ "acc = sum(pred == y_test)/length(y_test)\n"
				+ "print(acc)\n"
				+ "";
		
		// serialize code into Python filename
		
		Files.write(Rcode.getBytes(), new File(R_OUTPUT));



	}

	public MLResult run() throws IOException {
		// execute the generated Python code
		// roughly: exec "python foofile.py"
		Process p = Runtime.getRuntime().exec("R -f " + R_OUTPUT);
	
		// output
		BufferedReader stdInput = new BufferedReader(new 
				InputStreamReader(p.getInputStream()));
	
		// error
		BufferedReader stdError = new BufferedReader(new 
				InputStreamReader(p.getErrorStream()));
	
		String result = "";
		
		String o;
		while ((o = stdInput.readLine()) != null) {
			result += o;
			// System.out.println(o);
		}
	
		String err; 
		while ((err = stdError.readLine()) != null) {
			result += err;
			// System.out.println(err);
		}
		
		
	
		//print\\(acc\\)\\[1\\]\t([0-9]*['.']?[0-9]*)
	    String pattern_string = "print\\(acc\\)\\[1\\]\\s([0-9]*['.']?[0-9]*)";
	    //System.out.print(result);
	    
	    //String chaine = 
		Pattern pattern = Pattern.compile(pattern_string);
	    
	    //String chaine = "Test <b>regexé</b> <i>Java</i> pour <b>Wikibooks</b> francophone.";
		//Pattern pattern = Pattern.compile(pattern_string);
		Matcher matcher = pattern.matcher(result);
		
		matcher.find();
		String acc = matcher.group(1);
	   
		return new MLResult("ACCURACY :" + acc);

	}

}

