package main.java;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonExtractor {

	public String path; 
	public String file_name;
	public String separator;
	public String target_variable;
	public float training_size;
	public String language;
	public JSONArray metrics;
	public JSONArray predictive_Variables;
	


	public JsonExtractor(String path) {
		this.path = path;
	}
	
	public void Extract_information() throws IOException
	{
		
		JSONObject obj = new JSONObject(this.path);
		JSONObject dataset = (JSONObject) obj.get("dataset");
		this.file_name = dataset.getString("filename");
		this.separator = dataset.getString("separator"); 
		this.target_variable = obj.getString("target_variable"); 
		this.training_size = obj.getFloat("train_size"); 
		this.language = obj.getString("targetLanguage");
		this.metrics = obj.getJSONArray("metrics");
		this.predictive_Variables = obj.getJSONArray("predictive_Variables");		
	}
			
}
