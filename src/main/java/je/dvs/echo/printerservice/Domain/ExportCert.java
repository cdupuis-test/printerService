package je.dvs.echo.printerservice.Domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ExportCert implements Serializable {

    public String Date;
    public String RegistrationNumber;
    public String ReferenceNo;
    public String VinChassisFrame;
    public String EngineNo;
    public String Make;
    public String Model;
    public String BodyType;
    public String Seats;
    public String CC;
    public String TypeOfFuel;
    public String Colour;
    public String Weight;
    public String TypeApproval;
    public String CO2;
    public String FirstReg;
    public String Name;
    public String Address;
    public String RegDate;
    public String Status;
    public String Notes;

    public ExportCert(){};



}
