package main.java;

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
	
	public ConfigurationML(JsonExtractor json_extractor) {
		this.file_path = json_extractor.file_name;
		this.target = json_extractor.target_variable;
		this.separator = json_extractor.separator;
		this.targetLanguage = json_extractor.language;
		this.train_size = json_extractor.training_size;
		this.metrics =  json_extractor.metrics;
		this.predictive_Variables = json_extractor.predictive_Variables;
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
