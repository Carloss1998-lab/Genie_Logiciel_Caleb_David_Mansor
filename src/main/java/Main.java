package main.java;

import static spark.Spark.*;
import java.nio.file.Files;
import java.nio.file.Paths;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import spark.Request;
import spark.utils.IOUtils;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

public class Main {
    private static String Filename;
    //private static String input1;
    private static String targetLanguage;
    private static String targetVariable;
    private static String predictive;
    private static String Metrics;
    private static double trainsize;
    private static String separateur;

    public static void main(String[] args) {
    	//To host static contents locally create a folder called 'public' under 'src/main/resources' folder
    	staticFiles.location("/public");
        File uploadDir = new File("upload");
        uploadDir.mkdir(); // create the upload directory if it doesn't exist

        staticFiles.externalLocation("upload");

        get("/index", (req, res) -> {
        	res.redirect("index.html");
        	return null;
        });
        get("/test", (req, res) -> getMLResult());
        
        get("/resultat", (req,res) ->getML(args));
        
        post("/val", (req,res) ->
        {
            //this line is absolutely necessary, without this the form-data & multipart file html page wont get any values
            req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/tmp"));

            Path tempFile = Files.createTempFile(uploadDir.toPath(), "", "");
            //Get the uploaded file
            Part uploadedFile = null;
            try {
                uploadedFile = req.raw().getPart("myFile");
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
            Part filePart = req.raw().getPart("myFile");
            try (InputStream inputStream = filePart.getInputStream()) {
                OutputStream outputStream = new FileOutputStream(filePart.getSubmittedFileName());
                IOUtils.copy(inputStream, outputStream);
                outputStream.close();
            }
            Map<String, String[]> parameterMap = req.raw().getParameterMap();
            Set<String> parameterSet = parameterMap.keySet();
            System.out.println(parameterSet);
            parameterSet.stream().forEach(each -> {
                String join = String.join(",",parameterMap.get(each));
                System.out.println(each);
                if (each.equals("targetLanguage"))
                {
                    targetLanguage =join;
                }
                else if (each.equals("predictive"))
                {
                    predictive= join;
                }
                else if (each.equals("Metrics"))
                {
                    Metrics = join;
                }
                else if (each.equals("trainsize"))
                {
                    trainsize = Double.parseDouble(join);
                }
                else if(each.equals("separateur")){
                    separateur = join;
                }
                else {
                    targetVariable =join;
                }
               /*System.out.println("This is the key from parameter map: " + each);
              System.out.println("This is the value from parameter map: " + join);*/

            });
                Filename = logInfo(req, tempFile);

              //predictive = req.params("predictive");
             //Metrics = req.params("Metrics");
            //trainsize = 0.7;//Float.parseFloat(req.params("trainsize"));
           //separateur = req.params("separateur");
          //System.out.println(Filename);
         //System.out.println(input1);
            getMLResult();
            res.redirect("/resultat");
            return null;
        });
    }

    private static String getMLResult() throws IOException {
        final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        /*System.out.println(targetLanguage);
        System.out.println(predictive);
        System.out.println(Metrics);
        System.out.println(separateur);
        System.out.println(trainsize);*/

        //	"dataset": {
        //	"filename": "kyphosis.csv",
        //			"separator": ",

        final JsonParser parser = new JsonParser();
        //System.out.println(gson.toJson(jsonn));
        //System.out.println(gson.toJson(new TestResponse(jsonn)));

        final MLresult3 dataset = new MLresult3(Filename,separateur);
        final String json1 = gson.toJson(dataset);

       JsonElement json2 = parser.parse(json1);
       //System.out.println(gson.toJson(json2));

        final MLResult2 mlresult2 = new MLResult2(gson.toJson(json2),trainsize,targetVariable,Metrics,predictive,targetLanguage);
        final String json = gson.toJson(mlresult2);

        JsonElement json3 = parser.parse(json);
        System.out.println(gson.toJson(json3));
        //System.out.println(gson.toJson(new MLResult2(gson.toJson(json3))));

        String  mainJsonStr = gson.toJson(json3).replace("\\", ""); //replace the \
        //System.out.println(mainJsonStr);
        mainJsonStr = mainJsonStr.replace("\"[","[");
        //System.out.println(mainJsonStr);
        mainJsonStr = mainJsonStr.replace("]\"","]");
        //System.out.println(mainJsonStr);

        mainJsonStr = mainJsonStr.replace("\"{","{");
        //System.out.println(mainJsonStr);
        mainJsonStr = mainJsonStr.replace("}\"","}");
        //System.out.println(mainJsonStr);


        try(FileWriter writer = new FileWriter("mmlJSON.json")) {
            writer.append(mainJsonStr);
            System.out.println("Successfully serialized operators!");
        }catch (IOException ex) {
            System.err.format("An IO Exception was occurred: %s%n", ex);
            System.exit(-1);
        }

        return gson.toJson(json3);
    }
    public static class TestResponse {
        private final JsonElement response;

        public TestResponse(JsonElement response) {
            this.response = response;
        }
    }
    
    private static String getML(String[] args) throws IOException {
        
    	String path = null;
        if(args.length== 0){
            path = Files.readString(Paths.get("mmlJSON.json"));
        }
        else{
            path = Files.readString(Paths.get(args[0]));
        }


        MLExecutor executor = new ExecutorBuilder(path).executor;
	    executor.generateCode();

        System.out.println(executor.run().getStringResult());
        return  executor.run().getStringHtml();
    }



    private static String logInfo(Request req, Path tempFile) throws IOException, ServletException {
        System.out.println(getFileName(req.raw().getPart("myFile")));
        return getFileName(req.raw().getPart("myFile"));
    }

    private static String getFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}