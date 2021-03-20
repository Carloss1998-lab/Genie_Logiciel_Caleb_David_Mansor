package main.java;


public class MLResult2 {
	private final String dataset;
	private final String target_variable;
	private final String metrics;
	private final double train_size;
	private  final  String targetLanguage;
	private  final  String predictive_Variables;;

	//	"dataset": {
	//	"filename": "kyphosis.csv",
	//			"separator": ","

	  public MLResult2(final String dataset, final double train_size, final String target_variable, final String metrics
			  ,final  String predictive_Variables, final String targetLanguage) {
	    super();
		  this.target_variable = target_variable;
		  this.metrics = metrics;
		  this.train_size = train_size;
		  this.predictive_Variables = predictive_Variables;
		  this.dataset = dataset;
		  this.targetLanguage = targetLanguage;
	  }
	  

	  @Override
	  public String toString() {
	    return "ML Results [targetLanguage=" + this.targetLanguage +"]";
	  }

}
