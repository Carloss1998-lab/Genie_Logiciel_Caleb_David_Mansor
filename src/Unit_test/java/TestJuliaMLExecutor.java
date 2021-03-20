package Unit_test.java;
import org.junit.Test;

import main.java.ExecutorBuilder;
import main.java.MLExecutor;
import main.java.ConfigurationML;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestJuliaMLExecutor {
	String path;
	String foofile;

	@Test
	public void TestGenerateCode() throws IOException {
		// TODO Auto-generated constructor stub
		String JuliaCode= "using Pkg\n"
				+ "using DataFrames \n"
				+ "using DecisionTree \n"
				+ "using CSV \n"
				+ "using ScikitLearn\n"
				+ "\n"
				+ "\n"
				+ "# the dataset\n"
				+ "df = CSV.read(\"kyphosis.csv\", DataFrame; header = 1)\n"
				+ "# Spliting dataset between features (X) and label (y)\n"
				+ "\n"
				+ "X = convert(Array, df[:, [\"Age\",\"Number\",\"Start\"]]);\n"
				+ "y = convert(Array, df[:, \"Kyphosis\"]);\n"
				+ "\n"
				+ "model = DecisionTreeClassifier(max_depth=2)\n"
				+ "fit!(model, X, y)\n"
				+ "\n"
				+ "using ScikitLearn.CrossValidation: cross_val_score\n"
				+ "accuracy = cross_val_score(model, X, y, cv=3)\n"
				+ "println(\"accuracy : \",accuracy)\n"
				+ "";
		try {
			path= Files.readString(Paths.get("mml1.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MLExecutor executor = new ExecutorBuilder().build(path);

		executor.generateCode();
	   foofile = Files.readString(Paths.get("foofile.jl"));		
	   
	    assertEquals(foofile,JuliaCode);
	}
	
	
	@Test
	public void TestRun() {
		
	}
	

}


