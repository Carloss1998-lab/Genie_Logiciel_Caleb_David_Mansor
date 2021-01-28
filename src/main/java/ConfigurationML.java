package main.java;

public class ConfigurationML {
	
	private String file_path; // dataset
	private String target; // targeted feature (column name)
	private String separator;// get separator
	private String targetLanguage;
	private float train_size;
	// TODO
	private DataSet data;
	
	public ConfigurationML(String file_path, String target, String separator, String targetLanguage, float train_size) {
		this.file_path = file_path;
		this.target = target;
		this.separator = separator;
		this.targetLanguage = targetLanguage;
		this.train_size = train_size;
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
}
