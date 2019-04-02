package je.dvs.echo.printerservice.Service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationFeature;
import je.dvs.echo.printerservice.Domain.Address;
import org.apache.camel.json.simple.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ThymeleafEngine {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SpringTemplateEngine templateEngine;


    public String process (String json, String templateName) throws Exception {

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);

        Context context =  new Context();

        Object jObj = objectMapper.readValue(json,Object.class);

        if(jObj instanceof List)
        {

            JavaType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, HashMap.class);
            List<JsonObject> contexth = objectMapper.readValue(json, collectionType);

            context.setVariable("Data",contexth);
        }
        else if(jObj instanceof HashMap)
        {
            HashMap<String,Object> contexth = objectMapper.readValue(json,HashMap.class);

            for(Map.Entry<String,Object> entry : contexth.entrySet()){

                context.setVariable(entry.getKey(),entry.getValue());
            }
        }



        if(templateName.equals("ExportCert")) {
            context.setVariable("address", new Address());
         //   context.setVariable("ListOfBoxes", contexth.get("ListOfBoxes"));
        }
        System.out.println("Model:" + context.getVariables());

        templateEngine.initialize();

        String html = templateEngine.process(templateName, context);

        return html;
    }




}
