package je.dvs.echo.printerservice.Domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ExportCert implements Serializable {

    public String Date;
    public String registrationNumber;
    public String referenceNo;
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

    public ExportCert(String date, String registrationNumber, String referenceNo, String vinChassisFrame, String engineNo, String make, String model, String bodyType, String seats, String CC, String typeOfFuel, String colour, String weight, String typeApproval, String CO2, String firstReg, String name, String address, String regDate, String status, String notes) {
        Date = date;
        this.registrationNumber = registrationNumber;
        this.referenceNo = referenceNo;
        VinChassisFrame = vinChassisFrame;
        EngineNo = engineNo;
        Make = make;
        Model = model;
        BodyType = bodyType;
        Seats = seats;
        this.CC = CC;
        TypeOfFuel = typeOfFuel;
        Colour = colour;
        Weight = weight;
        TypeApproval = typeApproval;
        this.CO2 = CO2;
        FirstReg = firstReg;
        Name = name;
        Address = address;
        RegDate = regDate;
        Status = status;
        Notes = notes;
    }


}
