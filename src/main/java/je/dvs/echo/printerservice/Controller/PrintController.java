package je.dvs.echo.printerservice.Controller;

import je.dvs.echo.printerservice.Service.PdfGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;

@RestController
@RequestMapping("/print")
@CrossOrigin
public class PrintController {

    @Autowired
    PdfGeneratorUtil pdfGeneratorUtil;


    @RequestMapping(method = RequestMethod.POST, path="/VRD1")
    public String printVRD1(String VRD1Data) throws Exception {

        String RegistrationData = URLDecoder.decode(VRD1Data, "UTF-8");

        return  pdfGeneratorUtil.createPdf(RegistrationData,"VRD1");
    }
}
