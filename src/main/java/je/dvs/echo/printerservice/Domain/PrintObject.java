package je.dvs.echo.printerservice.Domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Getter
@Setter
@Document(collection = "printQueue")
public class PrintObject {

    @Id
    UUID docUUID;
    String printString;
    String userid;
    Long createdDate;
    Long printedDate;

    public PrintObject(UUID docUUID, String printString, String userid, Long createdDate, Long printedDate) {
        this.docUUID = docUUID;
        this.printString = printString;
        this.userid = userid;
        this.createdDate = createdDate;
        this.printedDate = printedDate;
    }

    public PrintObject(){};
}
