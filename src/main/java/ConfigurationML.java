package main.java;
import org.json.JSONArray;
import org.json.JSONObject;


public class ConfigurationML {
	
	private String filePath;
	private String target;
	private String separator;
	private String targetLanguage;
	private float trainSize;
	private JSONArray metrics;
	private JSONArray predictiveVariables;
	private String configurationDisplay;
	
	
	public ConfigurationML(String path){
		
		this.filePath = path;
		JSONObject obj = new JSONObject(this.filePath);
		JSONObject dataset = (JSONObject) obj.get("dataset");		
		this.filePath = dataset.getString("filename");
		this.target = obj.getString("target_variable"); 
		this.separator = dataset.getString("separator"); 
		this.targetLanguage = obj.getString("targetLanguage");
		this.trainSize = obj.getFloat("train_size"); 
		this.metrics =  obj.getJSONArray("metrics");
		this.predictiveVariables = obj.getJSONArray("predictive_Variables");
		this.configurationDisplay = "################################\n#########Configurations#########\n################################\n\n"
                +"Target langage: "+targetLanguage
                +"\n"
                +"Dataset: "+filePath
                +"\n"
                +"Predictive variables: "+predictiveVariables
                +"\n"
                +"Target variable: "+target
                +"\n"
                +"Train data proportion: " + trainSize+"\n";		
	}
	
	
	public String getFilePath() {
		return filePath;
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
	
	public void setTargetLanguage(String language) {
		this.targetLanguage = language;
	}

	public float getTrainSize() {
		return trainSize;
	}
	
	public JSONArray getMetrics() {
		return metrics;
	}
	public JSONArray getPredictiveVariables(){
		return predictiveVariables;
	}


	public String getConfigurationDisplay() {
		return configurationDisplay;
	}
}
