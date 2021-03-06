package je.dvs.echo.printerservice.Controller;

import je.dvs.echo.printerservice.Service.PdfGeneratorUtil;
import org.apache.camel.json.simple.JsonObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.net.URLDecoder;
import java.util.UUID;

@RestController
@RequestMapping("/print")
@CrossOrigin(origins = "*")
public class PrintController {

    @Autowired
    PdfGeneratorUtil pdfGeneratorUtil;


    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, path="/VRD1")
    public String printVRD1(@RequestBody  String VRD1Data) throws Exception {

        String RegistrationData = URLDecoder.decode(VRD1Data, "UTF-8");

        return  pdfGeneratorUtil.createPdf(RegistrationData,"VRD1");
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, path="/TradeLicense")
    public String printTRADE(@RequestBody  String TRADEData) throws Exception {

        String TradeData = URLDecoder.decode(TRADEData, "UTF-8");

        return  pdfGeneratorUtil.createPdf(TradeData,"FinalTradeLicense");
    }

    @CrossOrigin("*")
    @RequestMapping(method = RequestMethod.POST, path="/ExportCert")
    public String printExportCert(@RequestBody String VehicleData) throws Exception {

        String ExportData = URLDecoder.decode(VehicleData, "UTF-8");

        JSONObject ExportObj = new JSONObject(ExportData);
        String RefNo =  ExportObj.getString("ReferenceNo");
        String NewRefNo = RefNo.substring(0,6);
        NewRefNo = "COE -" + NewRefNo;

        ExportObj.put("ReferenceNo", NewRefNo);

        return pdfGeneratorUtil.createPdf(ExportObj.toString(), "ExportCert");
    }

    @Bean
    CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}
