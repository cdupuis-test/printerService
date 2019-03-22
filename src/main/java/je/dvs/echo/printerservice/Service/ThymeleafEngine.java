package je.dvs.echo.printerservice.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.HashMap;
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

        HashMap<String,Object> contexth = objectMapper.readValue(json,HashMap.class);

        for(Map.Entry<String,Object> entry : contexth.entrySet()){

            context.setVariable(entry.getKey(),entry.getValue());
        }

        String html = templateEngine.process(templateName, context);

        return html;
    }




}
