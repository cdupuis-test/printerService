package je.dvs.echo.printerservice.Controller;

import je.dvs.echo.printerservice.Service.PdfGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.net.URLDecoder;

@RestController
@RequestMapping("/print")
@CrossOrigin(origins = "*")
public class PrintController {

    @Autowired
    PdfGeneratorUtil pdfGeneratorUtil;


    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, path="/VRD1")
    public String printVRD1(@RequestBody  String VRD1Data) throws Exception {

        String RegistrationData = URLDecoder.decode(VRD1Data, "UTF-8");

        return  pdfGeneratorUtil.createPdf(RegistrationData,"VRD1");
    }

    @Bean
    CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}
