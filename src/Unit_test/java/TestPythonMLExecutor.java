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

public class TestPythonMLExecutor {
	String path ;
	String foofile;

	
	String pythonCode ="import pandas as pd\n"
			+ "from sklearn.model_selection import train_test_split\n"
			+ "from sklearn import tree\n"
			+ "from sklearn.metrics import accuracy_score\n"
			+ "\n"
			+ "# Using pandas to import the dataset\n"
			+ "df = pd.read_csv(\"kyphosis.csv\",sep=\",\" )\n"
			+ "\n"
			+ "# Learn more on pandas read_csv :\n"
			+ "#     https://pandas.pydata.org/pandas-docs/stable/reference/api/pandas.read_csv.html\n"
			+ "# pandas input in general :\n"
			+ "#     https://pandas.pydata.org/pandas-docs/stable/reference/io.html\n"
			+ "\n"
			+ "\n"
			+ "# Spliting dataset between features (X) and label (y)\n"
			+ "X = df.loc[:,[\"Age\",\"Number\",\"Start\"]]\n"
			+ "y = df[\"Kyphosis\"]\n"
			+ "\n"
			+ "# pandas dataframe operations :\n"
			+ "#     https://pandas.pydata.org/pandas-docs/stable/reference/frame.html\n"
			+ "\n"
			+ "\n"
			+ "# Spliting dataset into training set and test set\n"
			+ "test_size = 0.3\n"
			+ "X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=test_size)\n"
			+ "\n"
			+ "# scikit-learn train_test_split :\n"
			+ "#     https://scikit-learn.org/stable/modules/generated/sklearn.model_selection.train_test_split.html\n"
			+ "# Other model selection functions :\n"
			+ "#     https://scikit-learn.org/stable/modules/classes.html#module-sklearn.model_selection\n"
			+ "\n"
			+ "\n"
			+ "# Set algorithm to use\n"
			+ "clf = tree.DecisionTreeClassifier()\n"
			+ "\n"
			+ "# scikit-learn DecisionTreeClassifier :\n"
			+ "#     https://scikit-learn.org/stable/modules/generated/sklearn.tree.DecisionTreeClassifier.html#sklearn.tree.DecisionTreeClassifier\n"
			+ "# Other scikit-learn tree algorithms :\n"
			+ "#     https://scikit-learn.org/stable/modules/classes.html#module-sklearn.tree\n"
			+ "\n"
			+ "# Use the algorithm to create a model with the training set\n"
			+ "clf.fit(X_train, y_train)\n"
			+ "\n"
			+ "# Compute and display the accuracy\n"
			+ "accuracy = accuracy_score(y_test, clf.predict(X_test))\n"
			+ "\n"
			+ "metrics = [\"accuracy\",\"precision\",\"recall\",\"f1\"]\n"
			+ "for i in metrics:\n"
			+ "	exec(\"from sklearn.metrics import \" + i +\"_score\")\n"
			+ "	if i ==\"accuracy\":\n"
			+ "		print(\"Accuracy : \"  +str(accuracy_score(y_test, clf.predict(X_test)))+\"\\n\")\n"
			+ "	elif i ==\"f1\":\n"
			+ "		print(\"F1_score : \"  +str(f1_score(y_test, clf.predict(X_test),average = \"macro\"))+\"\\n\")\n"
			+ "	else:\n"
			+ "		score = eval(i+\"_score(y_test, clf.predict(X_test),average = \\\"macro\\\"  )\")\n"
			+ "		print(i +\": \"+str(score)+\"\\n\")	# scikit-learn accuracy_score :\n"
			+ "#     https://scikit-learn.org/stable/modules/generated/sklearn.metrics.accuracy_score.html\n"
			+ "# Other scikit-learn metrics :\n"
			+ "#     https://scikit-learn.org/stable/modules/classes.html#module-sklearn.metrics\n"
			+ "" ;
	
	@Test

	public void TestGenerateCode() throws IOException {
		// TODO Auto-generated constructor stub
		

			try {
				path= Files.readString(Paths.get("mml1.json"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MLExecutor executor = new ExecutorBuilder().build(path);

			executor.generateCode();
			
		   foofile = Files.readString(Paths.get("foofile.py"));		;
		    assertEquals(foofile,pythonCode);
		
		
		
	}
	@Test
	public void TestRun() {
		
	}
	
}
