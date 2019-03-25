package je.dvs.echo.printerservice.Service;

import je.dvs.echo.printerservice.Domain.PrintObject;
import je.dvs.echo.printerservice.Repository.PrintMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class PrinterService {

    @Autowired
    PrintMongoRepository mongoRepository;

    public void savePrintObject(String Body)
    {
        PrintObject print = new PrintObject();
        print.setPrintString(Body);
        print.setUserid("0");
        print.setCreatedDate(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond());
        print.setPrintedDate(0L);

        mongoRepository.save(print);
    }
}
