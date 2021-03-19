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


public class TestRMLExecutor {
	String path;
	String foofile;
	
	@Test
	public void TestGenerateCode() throws IOException{
		
		String Rcode= "library(rpart)\n"
				+ "\n"
				+ "dataset = read.csv('iris.csv',sep=\",\")\n"
				+ "\n"
				+ "# Spliting dataset into training set and test set\n"
				+ "train_ind = sample(1:nrow(dataset), size = nrow(dataset)*0.7)\n"
				+ "\n"
				+ "train = dataset[train_ind, ]\n"
				+ "X_test = dataset[-train_ind, -which(colnames(dataset) ==\"variety\")]\n"
				+ "y_test = as.factor(dataset[-train_ind, which(colnames(dataset) ==\"variety\")])\n"
				+ "\n"
				+ "model = rpart(formula = variety~., data = train)\n"
				+ "\n"
				+ "pred = predict(model, X_test, type = 'class')\n"
				+ "\n"
				+ "acc = sum(pred == y_test)/length(y_test)\n"
				+ "print(acc)\n"
				+ "";
		// TODO Auto-generated constructor stub

		try {
			path= Files.readString(Paths.get("mml.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MLExecutor executor = new ExecutorBuilder().build(path);

		executor.generateCode();
	   foofile = Files.readString(Paths.get("foofile.R"));		
	   
	    assertEquals(foofile,Rcode);
	}
	@Test
	public void TestRun() {
		
	}
	

}
