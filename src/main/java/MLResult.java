package main.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// results of an execution (in Python, R or Julia...)
public class MLResult {
	
	private String result;
	private ConfigurationML configuration;
	private String html_bef;
	private String html_aft;
	private String html_conf;
	

	public MLResult(String result, ConfigurationML configuration) {
		this.result = result;
		this.configuration = configuration;		
		this.html_conf = "      <div class=\"col-md-15\">\r\n" + 
        		"        <div class=\"card mb-3\">\r\n" + 
        		"          <div class=\"card text-white bg-dark mb-9\" style=\"max-width: 40rem;\">\r\n" + 
        		"\r\n" + 
        		"            <div class=\"card-header\">\r\n" + 
        		"              <h1>  <span> Configurations </span></h1>\r\n" + 
        		"            </div>\r\n" + 
        		"          </div>\r\n" + 
        		"\r\n" + 
        		"          <div class=\"card-body\">\r\n" + 
        		"            <form action=\"mml_form.php\" method=\"post\">\r\n" + 
        		"\r\n" ;
	    
		
		//Extracting Target language from and creating the html code for it
		
		String pattern_string_t_l = "Target\\slangage:\\s([a-zA-Z]*)";
		Pattern pattern_t_l = Pattern.compile(pattern_string_t_l);
		Matcher matcher_t_l = pattern_t_l.matcher(configuration.getConfigurationDisplay());
		matcher_t_l.find();
		String t_l = matcher_t_l.group(1);		
		this.html_conf = this.html_conf + "              <div class=\"row\">\r\n" + 
				"                      <div class=\"col-sm-0\">\r\n" + 
				"                        <h6 class=\"mb-0\">Taget language : </h6>\r\n" + 
				"                      </div>\r\n" + 
				"                      <div class=\"col-sm-9 text-secondary\">\r\n" + 
				"\r\n" + 
				"                         <div class=\"input-group\">\r\n" + 
				"                             <span class=\"input-group-btn\">\r\n" + 
				"                              <div>"+
				t_l+
				"</div>\r\n" + 
				"                             </span>\r\n" + 
				"                         </div><!-- /input-group -->\r\n" + 
				"                      </div><!-- /.col-lg-6 -->\r\n" + 
				"              </div><!-- /.row -->\r\n" + 
				"              <hr>\r\n" + 
				"\r\n";
		
		//Extracting Data set from and creating the html code for it
		
	    String pattern_string_data_set = "Dataset:\\s([a-zA-Z]*['.']?[a-zA-Z]*)";
		Pattern pattern_data_set = Pattern.compile(pattern_string_data_set);
		Matcher matcher_data_set = pattern_data_set.matcher(configuration.getConfigurationDisplay());
		matcher_data_set.find();
		String data_set = matcher_data_set.group(1);		
		this.html_conf = this.html_conf +  "              <div class=\"row\">\r\n" + 
				"                      <div class=\"col-sm-0\">\r\n" + 
				"                        <h6 class=\"mb-0\">Dataset : </h6>\r\n" + 
				"                      </div>\r\n" + 
				"                      <div class=\"col-sm-9 text-secondary\">\r\n" + 
				"\r\n" + 
				"                         <div class=\"input-group\">\r\n" + 
				"                             <span class=\"input-group-btn\">\r\n" + 
				"                              <div>"+
				data_set+
				"</div>\r\n" + 
				"                             </span>\r\n" + 
				"                         </div><!-- /input-group -->\r\n" + 
				"                      </div><!-- /.col-lg-6 -->\r\n" + 
				"              </div><!-- /.row -->\r\n" + 
				"              <hr>\r\n" + 
				"\r\n";
		

		//Extracting Target variable from and creating the html code for it


	    String pattern_string_t_var = "Target\\svariable:\\s([a-zA-Z]*)";
        Pattern pattern_t_var = Pattern.compile(pattern_string_t_var);
		Matcher matcher_t_var = pattern_t_var.matcher(configuration.getConfigurationDisplay());
		matcher_t_var.find();
		String t_var = matcher_t_var.group(1);		
		this.html_conf = this.html_conf +  "              <div class=\"row\">\r\n" + 
				"                      <div class=\"col-sm-0\">\r\n" + 
				"                        <h6 class=\"mb-0\">Target variable : </h6>\r\n" + 
				"                      </div>\r\n" + 
				"                      <div class=\"col-sm-9 text-secondary\">\r\n" + 
				"\r\n" + 
				"                         <div class=\"input-group\">\r\n" + 
				"                             <span class=\"input-group-btn\">\r\n" + 
				"                              <div>"+
				t_var+
				"</div>\r\n" + 
				"                             </span>\r\n" + 
				"                         </div><!-- /input-group -->\r\n" + 
				"                      </div><!-- /.col-lg-6 -->\r\n" + 
				"              </div><!-- /.row -->\r\n" + 
				"              <hr>\r\n" + 
				"\r\n";
		
		
		//Extracting Train data proportion from and creating the html code for it

	    String pattern_string_t_d_p = "Train\\sdata\\sproportion:\\s([0-9]*['.']?[0-9]*)";
		Pattern pattern_t_d_p  = Pattern.compile(pattern_string_t_d_p );
		Matcher matcher_t_d_p = pattern_t_d_p.matcher(configuration.getConfigurationDisplay());
		matcher_t_d_p.find();
		String t_d_p  = matcher_t_d_p .group(1);
		
		this.html_conf = this.html_conf +  "              <div class=\"row\">\r\n" + 
				"                      <div class=\"col-sm-0\">\r\n" + 
				"                        <h6 class=\"mb-0\">Train data proportion : </h6>\r\n" + 
				"                      </div>\r\n" + 
				"                      <div class=\"col-sm-9 text-secondary\">\r\n" + 
				"\r\n" + 
				"                         <div class=\"input-group\">\r\n" + 
				"                             <span class=\"input-group-btn\">\r\n" + 
				"                              <div>"+
				t_d_p+
				"</div>\r\n" + 
				"                             </span>\r\n" + 
				"                         </div><!-- /input-group -->\r\n" + 
				"                      </div><!-- /.col-lg-6 -->\r\n" + 
				"              </div><!-- /.row -->\r\n" + 
				"              <hr>\r\n" + 
				"\r\n";

		
		this.html_conf = this.html_conf +   
				"          </form>\r\n" + 
        		"        </div> \r\n" + 
        		"      </div>\r\n" + 
        		"    </div>\r\n" + 
        		"  </div>\r\n" + 
        		"  </div>\r\n" ;
    }
	
	
	public String getStringResult() {
		System.out.print(configuration.getConfigurationDisplay());
		return result;
	}
	
	
	public String getStringHtml() {
		
		html_bef = "<!DOCTYPE html>\r\n" + 
				"<html lang=\"pt-br\">\r\n" + 
				"<head>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"   <link rel=\"icon\" type=\"image/png\" href=\"images/deep1.png\" />\r\n" + 
				"   <link href=\"http://netdna.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
				"   <meta charset=\"utf-8\">\r\n" + 
				"   <link href=\"https://fonts.googleapis.com/css?family=Permanent+Marker\" rel=\"stylesheet\">\r\n" + 
				"   <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\r\n" + 
				"   <script src=\"//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js\"></script>\r\n" + 
				"   <script src=\"//netdna.bootstrapcdn.com/bootstrap/4.1.1-beta/js/bootstrap.min.js\"></script>\r\n" + 
				"   <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js\" integrity=\"sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh\" crossorigin=\"anonymous\"></script>\r\n" + 
				"   <link rel=\"stylesheet\" href=\"https://res.cloudinary.com/dxfq3iotg/raw/upload/v1569006288/BBBootstrap/choices.min.css?version=7.0.0\">\r\n" + 
				"   <script src=\"https://res.cloudinary.com/dxfq3iotg/raw/upload/v1569006273/BBBootstrap/choices.min.js?version=7.0.0\"></script>\r\n" + 
				"   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"   <link rel=\"icon\" type=\"image/png\" href=\"images/deep1.png\" />\r\n" + 
				"   <script type=\"text/javascript\">\r\n" + 
				"$(document).ready(function() {\r\n" + 
				"  $(window).scroll(function() {\r\n" + 
				"    if ($(window).scrollTop() > 10) {\r\n" + 
				"      $(\".navbar\").addClass(\"bg-dark\");\r\n" + 
				"    } else {\r\n" + 
				"      $(\".navbar\").removeClass(\"bg-dark\");\r\n" + 
				"    }\r\n" + 
				"  });\r\n" + 
				"  // If Mobile, add background color when toggler is clicked\r\n" + 
				"  $(\".navbar-toggler\").click(function() {\r\n" + 
				"    if (!$(\".navbar-collapse\").hasClass(\"show\")) {\r\n" + 
				"      $(\".navbar\").addClass(\"bg-dark\");\r\n" + 
				"    } else {\r\n" + 
				"      if ($(window).scrollTop() < 10) {\r\n" + 
				"        $(\".navbar\").removeClass(\"bg-dark\");\r\n" + 
				"      } else {\r\n" + 
				"      }\r\n" + 
				"    }\r\n" + 
				"  });\r\n" + 
				"});\r\n" + 
				"</script>\r\n" + 
				"   <link href=\"https://fonts.googleapis.com/css?family=Permanent+Marker\" rel=\"stylesheet\">\r\n" + 
				"   <style>\r\n" + 
				"  nav ul li a {color: #FFFFFF;\r\n" + 
				"font-weight: lighter;\r\n" + 
				"   font-family: 'Poppins', san}\r\n" + 
				"  nav ul li a:hover {color: #000000;\r\n" + 
				"   background: #fff;}\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"\r\n" + 
				"   <title> Deep </title>\r\n" + 
				"   <style>\r\n" + 
				"          .carousel-item {\r\n" + 
				"          height: 150vh;\r\n" + 
				"          min-height: 350px;\r\n" + 
				"          background: no-repeat center center scroll;\r\n" + 
				"          -webkit-background-size: cover;\r\n" + 
				"          -moz-background-size: cover;\r\n" + 
				"          -o-background-size: cover;\r\n" + 
				"          background-size: cover;}\r\n" + 
				"\r\n" + 
				"          .select-algo-class {\r\n" + 
				"            position: r;\r\n" + 
				"            width: 600px;\r\n" + 
				"            height: 100px;\r\n" + 
				"            margin: 11% 30%;\r\n" + 
				"            text-align: center;\r\n" + 
				"          }\r\n" + 
				"          .select-algo-class h1 {\r\n" + 
				"            text-align: center;\r\n" + 
				"            color: #fff;\r\n" + 
				"            text-transform: uppercase;\r\n" + 
				"            font-size: 40px;\r\n" + 
				"          }\r\n" + 
				"          .select-algo-class h1 span {\r\n" + 
				"            color: #00fecb;\r\n" + 
				"          }\r\n" + 
				"\r\n" + 
				"          nav ul li a {color: #FFFFFF;\r\n" + 
				"          font-weight: lighter;\r\n" + 
				"            font-family: 'Poppins', san}\r\n" + 
				"          nav ul li a:hover {color: #000000;\r\n" + 
				"            background: #fff;}\r\n" + 
				"          }\r\n" + 
				"      </style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<nav class=\"navbar navbar-expand-lg fixed-top navbar-light \">\r\n" + 
				"   <a class=\"navbar-brand\" href=\"#\">\r\n" + 
				"      <img src=\"deep.png\" class=\"d-inline-block align-top\" alt=\"\" loading=\"lazy\">\r\n" + 
				"   </a>\r\n" + 
				"   <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
				"      <span class=\"navbar-toggler-icon\"></span>\r\n" + 
				"   </button>\r\n" + 
				"   <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n" + 
				"      <ul class=\"navbar-nav mr-auto\">\r\n" + 
				"      </ul>\r\n" + 
				"      <ul class=\"nav justify-content-end\">\r\n" + 
				"         <li class=\"nav-item active\">\r\n" + 
				"            <a class=\"nav-link\" href=\"http://localhost:8090/mml-web/Accueil.php\">Home <span class=\"sr-only\">(current)</span></a>\r\n" + 
				"         </li>\r\n" + 
				"         <li class=\"nav-item\">\r\n" + 
				"            <a class=\"nav-link\" href=\"http://localhost:8090/mml-web/MML.php\">Multi Machine Learning</a>\r\n" + 
				"         </li>\r\n" + 
				"         <li class=\"nav-item\"><a class=\"nav-link\"\r\n" + 
				"                           href=\"mailto:davidoubda@gmail.com\">Contact</a></li>\r\n" + 
				"      </ul>\r\n" + 
				"   </div>\r\n" + 
				"</nav>" + 
        		
        		"  <div class=\"carousel-item active\" style=\"background-image: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)),  url('https://www.getsmarter.com/disk/public/sBBGDTboLgihDAZHFNC7aFHj/mit_sloan_csail_machine_learning_course_page_large_header_banner.jpg')\">\r\n" + 
        		"\r\n" + 
        		"    <div class=\"select-algo-class\">\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"      <div class=\"col-md-15\">\r\n" + 
        		"        <div class=\"card mb-3\">\r\n" + 
        		"          <div class=\"card text-white bg-dark mb-9\" style=\"max-width: 40rem;\">\r\n" + 
        		"\r\n" + 
        		"            <div class=\"card-header\">\r\n" + 
        		"              <h1>  <span> Results</span></h1>\r\n" + 
        		"            </div>\r\n" + 
        		"          </div>\r\n" + 
        		"\r\n" + 
        		"          <div class=\"card-body\">\r\n" + 
        		"            <form action=\"mml_form.php\" method=\"post\">\r\n" + 
        		"\r\n" ;
		
		html_aft =         		        		"          </form>\r\n" + 
        		"        </div> \r\n" + 
        		"      </div>\r\n" + 
        		"    </div>\r\n" + 
        		"  </div>\r\n" + 
        		"  </div>\r\n" + 
        		"\r\n" + 
        		"\r\n" + 
        		"   </body>\r\n" + 
        		"</html>\r\n" + 
        		"";

		String final_html = "";
		if (configuration.getTargetLanguage().equals("PYTHON")){
	    String pattern_string_acc = "Accuracy\\s:\\s([0-9]*['.']?[0-9]*)";
	    String pattern_string_prec = "precision:\\s([0-9]*['.']?[0-9]*)";
	    String pattern_string_rec = "recall:\\s([0-9]*['.']?[0-9]*)";
	    String pattern_string_f1 = "F1_score\\s:\\s([0-9]*['.']?[0-9]*)";

	    
	    //accuracy 	    
		Pattern pattern_acc = Pattern.compile(pattern_string_acc);
		Matcher matcher_acc = pattern_acc.matcher(result);
		matcher_acc.find();
		String acc = matcher_acc.group(1);		
		
		String html_acc = "              <div class=\"row\">\r\n" + 
				"                      <div class=\"col-sm-0\">\r\n" + 
				"                        <h6 class=\"mb-0\">ACCURACY : </h6>\r\n" + 
				"                      </div>\r\n" + 
				"                      <div class=\"col-sm-9 text-secondary\">\r\n" + 
				"\r\n" + 
				"                         <div class=\"input-group\">\r\n" + 
				"                             <span class=\"input-group-btn\">\r\n" + 
				"                              <div>"+
				acc+
				"</div>\r\n" + 
				"                             </span>\r\n" + 
				"                         </div><!-- /input-group -->\r\n" + 
				"                      </div><!-- /.col-lg-6 -->\r\n" + 
				"              </div><!-- /.row -->\r\n" + 
				"              <hr>\r\n" + 
				"\r\n";
		
		// Precicion
		Pattern pattern_prec = Pattern.compile(pattern_string_prec);
		Matcher matcher_prec = pattern_prec.matcher(result);
		matcher_prec.find();
		String prec = matcher_prec.group(1);
		
		String html_prec = "              <div class=\"row\">\r\n" + 
				"                      <div class=\"col-sm-0\">\r\n" + 
				"                        <h6 class=\"mb-0\">PRECISION : </h6>\r\n" + 
				"                      </div>\r\n" + 
				"                      <div class=\"col-sm-9 text-secondary\">\r\n" + 
				"\r\n" + 
				"                         <div class=\"input-group\">\r\n" + 
				"                             <span class=\"input-group-btn\">\r\n" + 
				"                              <div>"+
				prec+
				"</div>\r\n" + 
				"                             </span>\r\n" + 
				"                         </div><!-- /input-group -->\r\n" + 
				"                      </div><!-- /.col-lg-6 -->\r\n" + 
				"              </div><!-- /.row -->\r\n" + 
				"              <hr>\r\n" + 
				"\r\n";
		
		// F1-score
		Pattern pattern_f1 = Pattern.compile(pattern_string_f1);
		Matcher matcher_f1 = pattern_f1.matcher(result);
		matcher_f1.find();
		String f1 = matcher_f1.group(1);
		
		String html_f1 = "              <div class=\"row\">\r\n" + 
				"                      <div class=\"col-sm-0\">\r\n" + 
				"                        <h6 class=\"mb-0\">F1_SCORE : </h6>\r\n" + 
				"                      </div>\r\n" + 
				"                      <div class=\"col-sm-9 text-secondary\">\r\n" + 
				"\r\n" + 
				"                         <div class=\"input-group\">\r\n" + 
				"                             <span class=\"input-group-btn\">\r\n" + 
				"                              <div>"+
				f1+
				"</div>\r\n" + 
				"                             </span>\r\n" + 
				"                         </div><!-- /input-group -->\r\n" + 
				"                      </div><!-- /.col-lg-6 -->\r\n" + 
				"              </div><!-- /.row -->\r\n" + 
				"              <hr>\r\n" + 
				"\r\n";

		// Recall
		Pattern pattern_rec = Pattern.compile(pattern_string_rec);
		Matcher matcher_rec  = pattern_rec .matcher(result);
		matcher_rec .find();
		String rec  = matcher_rec.group(1);
		
		
		String html_rec = "              <div class=\"row\">\r\n" + 
				"                      <div class=\"col-sm-0\">\r\n" + 
				"                        <h6 class=\"mb-0\">RECALL : </h6>\r\n" + 
				"                      </div>\r\n" + 
				"                      <div class=\"col-sm-9 text-secondary\">\r\n" + 
				"\r\n" + 
				"                         <div class=\"input-group\">\r\n" + 
				"                             <span class=\"input-group-btn\">\r\n" + 
				"                              <div>"+
				rec+
				"</div>\r\n" + 
				"                             </span>\r\n" + 
				"                         </div><!-- /input-group -->\r\n" + 
				"                      </div><!-- /.col-lg-6 -->\r\n" + 
				"              </div><!-- /.row -->\r\n" + 
				"              <hr>\r\n" + 
				"\r\n";
	    final_html = html_bef+html_acc+html_prec+html_rec+html_f1+html_conf+html_aft;
	}
		
		else if (configuration.getTargetLanguage().equals("R")){
		    String pattern_string_acc = "Accuracy\\s:\\s([0-9]*['.']?[0-9]*)";
		    

		    
		    //accuracy 
		    
			Pattern pattern_acc = Pattern.compile(pattern_string_acc);
			Matcher matcher_acc = pattern_acc.matcher(result);
			matcher_acc.find();
			String acc = matcher_acc.group(1);
			
			
			String html_acc = "              <div class=\"row\">\r\n" + 
					"                      <div class=\"col-sm-0\">\r\n" + 
					"                        <h6 class=\"mb-0\">ACCURACY : </h6>\r\n" + 
					"                      </div>\r\n" + 
					"                      <div class=\"col-sm-9 text-secondary\">\r\n" + 
					"\r\n" + 
					"                         <div class=\"input-group\">\r\n" + 
					"                             <span class=\"input-group-btn\">\r\n" + 
					"                              <div>"+
					acc+
					"</div>\r\n" + 
					"                             </span>\r\n" + 
					"                         </div><!-- /input-group -->\r\n" + 
					"                      </div><!-- /.col-lg-6 -->\r\n" + 
					"              </div><!-- /.row -->\r\n" + 
					"              <hr>\r\n" + 
					"\r\n";
			
		    final_html = html_bef+html_acc+html_conf+html_aft;
		}

		
		else if (configuration.getTargetLanguage().equals("JULIA")){

		    String pattern_string_acc = "Accuracy\\s:\\s([0-9]*['.']?[0-9]*)";
		    

		    
		    //accuracy 		    
			Pattern pattern_acc = Pattern.compile(pattern_string_acc);
			Matcher matcher_acc = pattern_acc.matcher(result);
			matcher_acc.find();
			String acc = matcher_acc.group(1);
			
			
			String html_acc = "              <div class=\"row\">\r\n" + 
					"                      <div class=\"col-sm-0\">\r\n" + 
					"                        <h6 class=\"mb-0\">ACCURACY : </h6>\r\n" + 
					"                      </div>\r\n" + 
					"                      <div class=\"col-sm-9 text-secondary\">\r\n" + 
					"\r\n" + 
					"                         <div class=\"input-group\">\r\n" + 
					"                             <span class=\"input-group-btn\">\r\n" + 
					"                              <div>"+
					acc+
					"</div>\r\n" + 
					"                             </span>\r\n" + 
					"                         </div><!-- /input-group -->\r\n" + 
					"                      </div><!-- /.col-lg-6 -->\r\n" + 
					"              </div><!-- /.row -->\r\n" + 
					"              <hr>\r\n" + 
					"\r\n";
			
			

			
			
			
		    final_html = html_bef+html_acc+this.html_conf+html_aft;
		}


		return final_html;

	}

}

