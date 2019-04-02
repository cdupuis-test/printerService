package je.dvs.echo.printerservice.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import je.dvs.echo.printerservice.Domain.Address;
import je.dvs.echo.printerservice.Domain.trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.util.List;

@Component
public class ThymeleafEngine {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SpringTemplateEngine templateEngine;



    public String process (String json, String templateName) throws Exception {

        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);

        Context context =  new Context();

        List<trade> contexth = objectMapper.readValue(json, List.class);

        context.setVariable("TradeLicenseList", contexth);

        if(templateName.equals("ExportCert")) {
            context.setVariable("address", new Address());
            //   context.setVariable("ListOfBoxes", contexth.get("ListOfBoxes"));
        }

        String html = templateEngine.process(templateName, context);

        return html;
    }




}
