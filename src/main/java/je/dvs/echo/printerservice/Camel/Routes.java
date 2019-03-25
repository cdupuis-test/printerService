package je.dvs.echo.printerservice.Camel;

import je.dvs.echo.printerservice.Config.RabbitMQ;
import je.dvs.echo.printerservice.Service.PdfGeneratorUtil;
import je.dvs.echo.printerservice.Service.PrinterService;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import(RabbitMQ.class)
public class Routes extends RouteBuilder {

    @Value("#{rabbitMQ.PRINT_VRD1}")
    private String PRINT_VRD1;

    @Value("#{rabbitMQ.EXPORT_CERT}")
    private String EXPORT_CERT;

    public String LOGGER_QUEUE = "log:?level=INFO&showBody=true&showHeaders=true&showExchangeId=true&multiline=true&showProperties=true";


    @Override
    public void configure() throws Exception {

        from(PRINT_VRD1)
         .to(LOGGER_QUEUE)
         .bean(PdfGeneratorUtil.class, "createPdf(${body}, VRD1)")
         .bean(PrinterService.class, "savePrintObject(${body})");



    }
}
