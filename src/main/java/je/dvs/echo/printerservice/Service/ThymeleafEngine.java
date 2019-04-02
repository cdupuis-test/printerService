package je.dvs.echo.printerservice.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import je.dvs.echo.printerservice.Domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

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

        List<Object> contexth = objectMapper.readValue(json, List.class);

        context.setVariable("Data", contexth);

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
