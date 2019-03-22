package je.dvs.echo.printerservice.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VRD1 {

    String RegistrationMark;
    String DocUUID;
    String DocSeq;
    String DateofIssue;
    String Fullname;
    String Address1;
    String Address2;
    String Address3;
    String Postcode;
    String Make;
    String Model;
    String BodyType;
    String VehicleCategory;
    String Colour;
    String SeatingCapacity;
    String VINChassis;
    String EngineNo;
    String TypeApprovalNo;
    String CylinderCapacity;
    String C02g;
    String TypeOfFuel;
    String Registered;
    String DateRegInJersey;

    String PreviousCountry;
    String DatePreviouslyReg;
    String PreviousRegNo;
    String OdometerReading;
    String Width;
    String Length;
    String Weight;
    String LastKeeper;
    String FormerKeeper;
    String FirstEverReg;
    String Comments;
}
