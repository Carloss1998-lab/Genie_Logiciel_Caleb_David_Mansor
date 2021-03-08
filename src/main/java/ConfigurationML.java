package main.java;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConfigurationML {
	
	//private path;
	private String file_path; // dataset
	private String target; // targeted feature (column name)
	private String separator;// get separator
	private String targetLanguage;
	private float train_size;
	private JSONArray metrics;
	private JSONArray predictive_Variables ;
	
	
	
	// TODO
	
	
	
		/*public void Extract_information(path) throws IOException
		{		
			
			JSONObject obj = new JSONObject(this.path);
			JSONObject dataset = (JSONObject)obj.get("dataset");
			this.file_name = dataset.getString("filename");
			this.separator = dataset.getString("separator"); 
			this.target_variable = obj.getString("target_variable"); 
			this.training_size = obj.getFloat("train_size"); 
			this.language = obj.getString("targetLanguage");
			this.metrics = obj.getJSONArray("metrics");
			this.predictive_Variables = obj.getJSONArray("predictive_Variables");		
		}
			*/
		
	
	public ConfigurationML(String path){
		
		this.file_path = path;
		JSONObject obj = new JSONObject(this.file_path);
		JSONObject dataset = (JSONObject) obj.get("dataset");
		
		this.file_path = dataset.getString("filename");
		this.target = obj.getString("target_variable"); 
		this.separator = dataset.getString("separator"); 
		this.targetLanguage = obj.getString("targetLanguage");
		this.train_size = obj.getFloat("train_size"); 
		this.metrics =  obj.getJSONArray("metrics");
		this.predictive_Variables = obj.getJSONArray("predictive_Variables");
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
