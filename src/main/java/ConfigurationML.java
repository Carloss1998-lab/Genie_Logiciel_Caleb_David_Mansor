package main.java;

import java.lang.reflect.Array;

import org.json.JSONArray;

public class ConfigurationML {
	
	private String file_path; // dataset
	private String target; // targeted feature (column name)
	private String separator;// get separator
	private String targetLanguage;
	private float train_size;
	private JSONArray metrics;
	private JSONArray predictive_Variables ;
	// TODO
	private DataSet data;
	
	public ConfigurationML(String file_path, String target, String separator, String targetLanguage, float train_size, 
			JSONArray metrics, JSONArray predictive_Variables) {
		this.file_path = file_path;
		this.target = target;
		this.separator = separator;
		this.targetLanguage = targetLanguage;
		this.train_size = train_size;
		this.metrics =  metrics;
		this.predictive_Variables = predictive_Variables;
	}
	
	
	public String getFilePath() {
		return file_path;
	}
	
	public String getTarget() {
		return target;
	}
	
	public String getSeparator() {
		return separator;
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public float getTrainSize() {
		return train_size;
	}
	
	public JSONArray getMetrics() {
		return metrics;
	}
	public JSONArray getPredictiveVariables(){
		return predictive_Variables;
	}
}
