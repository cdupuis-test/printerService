package je.dvs.echo.printerservice.Config;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RabbitMQ {


    public final String PRINT_VRD1 = CreateRabbitMQQueue("printVRD1", "printVRD1");
    public final String EXPORT_CERT = CreateRabbitMQQueue("printExportCert", "printExportCert");
    public final String ERROR_QUEUE = CreateRabbitMQQueue("errorQueue", "camel");
    private final static String localPort = "5672";

    public static String CreateRabbitMQQueue(String QueueName, String RoutingKey)
    {
        String hostv;
        String portv;
        String username;
        String password;

        try {
            hostv = System.getenv("V_RABBIT_HOST");
            portv = localPort;
            username = System.getenv("V_RABBIT_USERNAME");
            password = System.getenv("V_RABBIT_PASSWORD");

            UriComponentsBuilder uriBuilder = UriComponentsBuilder
                    .fromPath("/")
                    .scheme("rabbitmq")
                    .host(hostv)
                    .port(portv)
                    .path("/" + QueueName)
                    .queryParam("username", username)
                    .queryParam("password", password)
                    .queryParam("routingKey", RoutingKey)
                    .queryParam("queue",  QueueName);


            System.out.println(uriBuilder.toUriString());
            return uriBuilder.toUriString();
        } catch (Exception e) {

            // Returning a default builder if there is an error.
            return "";
        }
    }
}

