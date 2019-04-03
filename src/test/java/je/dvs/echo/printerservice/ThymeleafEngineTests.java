package je.dvs.echo.printerservice;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import je.dvs.echo.printerservice.Domain.ExportCert;
import je.dvs.echo.printerservice.Domain.VRD1;
import je.dvs.echo.printerservice.Domain.trade;
import je.dvs.echo.printerservice.Service.PdfGeneratorUtil;
import je.dvs.echo.printerservice.Service.ThymeleafEngine;
import org.apache.camel.json.simple.JsonArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThymeleafEngineTests {

    @Autowired
    ThymeleafEngine thymeleafEngine;

    @Autowired
    PdfGeneratorUtil pdfGeneratorUtil;

    String RegistrationMark = "J23345";
    String DocUUID = "34555-55644-2222";
    String DocSeq = "3";
    String DateofIssue = "22/11/2009";
    String Fullname = "Sam Smith";
    String Address1 = "4";
    String Address2 = "Appletree Court";
    //String Address3 = "St.Helier";
    String Postcode = "JE4 6GH";
    String Make = "";
    String Model = "Micra";
    String BodyType = "3 door Hatchback";
    String VehicleCategory = "Car";
    String Colour = "Red";
    String SeatingCapacity = "5";
    String VINChassis = "333333222299999999";
    String EngineNo = "5858503038272";
    String TypeApprovalNo = "39494008400";
    String CylinderCapacity = "30000";
    String C02g = "300";
    String TypeOfFuel = "Petrol";
    String Registered = "yes";
    String DateRegInJersey = "22/11/1999";

    String PreviousCountry = "UK";
    String DatePreviouslyReg = "22/09/2001";
    String PreviousRegNo = "";
    String OdometerReading = "10";
    String Width = "1000";
    String Length = "2005";
    String Weight = "55";
    String LastKeeper = "";
    String FormerKeeper = "";
    String FirstEverReg = "31/12/1999";
    String Comments = "";
    String Fee = "100";
    String ExpiredDate = "12/12/2023";

   @Before
    public void SetUp()
    {
        VRD1 vrd1 = new VRD1();
        vrd1.setRegistrationMark(RegistrationMark);
        vrd1.setDocUUID(DocUUID);
        vrd1.setDocSeq(DocSeq);
        vrd1.setDateofIssue(DateofIssue);
        vrd1.setFullname(Fullname);
        vrd1.setAddress1(Address1);
        vrd1.setAddress2(Address2);
     //   vrd1.setAddress3(Address3);
        vrd1.setPostcode(Postcode);
       // vrd1.setMake(Make);
        vrd1.setModel(Model);
        vrd1.setBodyType(BodyType);
        vrd1.setVehicleCategory(VehicleCategory);
        vrd1.setColour(Colour);
        vrd1.setSeatingCapacity(SeatingCapacity);
        vrd1.setVINChassis(VINChassis);
        vrd1.setEngineNo(EngineNo);
        vrd1.setTypeApprovalNo(TypeApprovalNo);
        vrd1.setCylinderCapacity(CylinderCapacity);
        vrd1.setC02g(C02g);
        vrd1.setTypeOfFuel(TypeOfFuel);
        vrd1.setRegistered(Registered);
        vrd1.setDateRegInJersey(DateRegInJersey);
        vrd1.setPreviousCountry(PreviousCountry);
        vrd1.setDatePreviouslyReg(DatePreviouslyReg);
        vrd1.setPreviousRegNo(PreviousRegNo);
        vrd1.setOdometerReading(OdometerReading);
        vrd1.setWidth(Width);
        vrd1.setLength(Length);
        vrd1.setWeight(Weight);
        vrd1.setLastKeeper(LastKeeper);
        vrd1.setFormerKeeper(FormerKeeper);
        vrd1.setFirstEverReg(FirstEverReg);
        vrd1.setComments(Comments);



    }


    @Test
    public void TestThymeleafEngineDocumentTemplate_VariablesSwapName() throws Exception {
        //Setup object
        JSONObject defaultTemplateData = new JSONObject("{  \n" +
                "   \"docUUID\":\"3888d487-6604-48a2-8e3c-ef1ec145dd72\",\n" +
                "   \"miscellaneous\":{  \n" +
                "      \"receiptNoInspection\":\"__vue_devtool_undefined__\",\n" +
                "      \"receiptNoRegistration\":\"__vue_devtool_undefined__\",\n" +
                "      \"agentCode\":\"__vue_devtool_undefined__\",\n" +
                "      \"linkToOwner\":\"__vue_devtool_undefined__\",\n" +
                "      \"declNo\":\"__vue_devtool_undefined__\",\n" +
                "      \"dutyPaid\":\"__vue_devtool_undefined__\",\n" +
                "      \"dutyExemptionNo\":\"__vue_devtool_undefined__\",\n" +
                "      \"code\":\"__vue_devtool_undefined__\"\n" +
                "   },\n" +
                "   \"registration_details\":{  \n" +
                "      \"status\":\"__vue_devtool_undefined__\",\n" +
                "      \"firstEverRegDate\":\"30/10/1998\",\n" +
                "      \"dateRegInJersey\":\"22/03/2019\",\n" +
                "      \"prevRegNo\":\"__vue_devtool_undefined__\",\n" +
                "      \"prevRegNoDate\":\"\",\n" +
                "      \"prevRegCountry\":\"__vue_devtool_undefined__\"\n" +
                "   },\n" +
                "   \"owner_details\":{  \n" +
                "      \"title\":\"Mr\",\n" +
                "      \"initials\":\"__vue_devtool_undefined__\",\n" +
                "      \"forenames\":\"Clint\",\n" +
                "      \"surname\":\"kuberkubekue\",\n" +
                "      \"dob\":\"\",\n" +
                "      \"emailAddress\":\"__vue_devtool_undefined__\",\n" +
                "      \"mobilePhone\":\"__vue_devtool_undefined__\",\n" +
                "      \"homePhone\":\"__vue_devtool_undefined__\",\n" +
                "      \"address1\":\"18 Bel Royal Gardens\",\n" +
                "      \"address2\":\"La Route De St Aubin\",\n" +
                "      \"address3\":\"\",\n" +
                "      \"parish\":\"St. Lawrence\",\n" +
                "      \"postCode\":\"JE3 1JU\",\n" +
                "      \"licenseNo\":\"__vue_devtool_undefined__\",\n" +
                "      \"firstRegOnVrd1\":\"__vue_devtool_undefined__\",\n" +
                "      \"isForSale\":false,\n" +
                "      \"isForHire\":false\n" +
                "   },\n" +
                "   \"vehicle_details\":{  \n" +
                "      \"regNo\":\"J31811\",\n" +
                "      \"vehicleCategory\":\"Cars\",\n" +
                "      \"vehicleBodyType\":\"3-Door Hatchback\",\n" +
                "      \"vehicleMake\":\"Ford\",\n" +
                "      \"vehicleModel\":\"COUGAR V6\",\n" +
                "      \"vehicleManufactureDate\":\"__vue_devtool_undefined__\",\n" +
                "      \"vehicleWidth\":\"__vue_devtool_undefined__\",\n" +
                "      \"vehicleHeight\":\"__vue_devtool_undefined__\",\n" +
                "      \"vehicleLength\":\"__vue_devtool_undefined__\",\n" +
                "      \"primaryColour\":\"Silver\",\n" +
                "      \"secondaryColour\":\"__vue_devtool_undefined__\",\n" +
                "      \"cubicCapacity\":\"2544\",\n" +
                "      \"transmission\":\"M\",\n" +
                "      \"co2\":\"__vue_devtool_undefined__\",\n" +
                "      \"engineNo\":\"__vue_devtool_undefined__\",\n" +
                "      \"chassisNo\":\"WF0HT61L5X5201831\",\n" +
                "      \"weight\":\"__vue_devtool_undefined__\",\n" +
                "      \"unladenWeight\":\"__vue_devtool_undefined__\",\n" +
                "      \"fuelType\":\"Petrol\",\n" +
                "      \"doorNo\":\"__vue_devtool_undefined__\",\n" +
                "      \"isTypeApproved\":\"__vue_devtool_undefined__\",\n" +
                "      \"typeApprovalNo\":\"__vue_devtool_undefined__\",\n" +
                "      \"odometer\":\"29440\",\n" +
                "      \"seatCapacity\":\"4\",\n" +
                "      \"isOver25yrs\":\"__vue_devtool_undefined__\",\n" +
                "      \"isLeftHandDrive\":false,\n" +
                "      \"isModified\":\"__vue_devtool_undefined__\"\n" +
                "   },\n" +
                "   \"comments\":{  \n" +
                "      \"freeText\":\"__vue_devtool_undefined__\",\n" +
                "      \"hidden\":\"__vue_devtool_undefined__\",\n" +
                "      \"kitBuilt\":\"__vue_devtool_undefined__\",\n" +
                "      \"noV55NotNew\":\"__vue_devtool_undefined__\",\n" +
                "      \"p30\":\"__vue_devtool_undefined__\"\n" +
                "   }\n" +
                "}");




      String result =  pdfGeneratorUtil.createPdf(defaultTemplateData.toString(),"VRD1");

      System.out.println("Result:" + result);

    }

    @Test
    public void PrintTradeLicense() throws Exception {

        List<trade> TradeLicenseList = new ArrayList<trade>();

        trade trade1 = new trade();
        trade1.setRegistrationMark("J1");
        trade1.setFee("100");
        trade1.setExpiredDate("31/12/2020");

        trade trade2 = new trade();
        trade2.setRegistrationMark("J2");
        trade2.setFee("100");
        trade2.setExpiredDate("31/12/2020");

        trade trade3 = new trade();
        trade3.setRegistrationMark("J44343");
        trade3.setFee("95.00");
        trade3.setExpiredDate("31/12/2020");

        trade trade4 = new trade();
        trade4.setRegistrationMark("J0001");
        trade4.setFee("95.00");
        trade4.setExpiredDate("31/19/2020");

        TradeLicenseList.add(trade1);
        TradeLicenseList.add(trade2);
        TradeLicenseList.add(trade3);
        TradeLicenseList.add(trade4);

        String Trade = new ObjectMapper().writeValueAsString(TradeLicenseList);

        String result = pdfGeneratorUtil.createPdf(Trade,"FinalTradeLicense");

        System.out.println(result);

    }

    @Test
    public void PrintExportCert() throws Exception {

        ExportCert exportCert = new ExportCert();
        exportCert.Date = LocalDateTime.now().toLocalDate().toString();
        exportCert.registrationNumber = "J12345";
        exportCert.referenceNo = "CO-3434";
        exportCert.VinChassisFrame = "303030303003030";
        exportCert.EngineNo = "3902839505829";
        exportCert.Make="Nissan";
        exportCert.Model="Note 5DR 1.4 M VISA";
        exportCert.CC = "1386";
        exportCert.Seats="5";
        exportCert.Colour = "Silver";
        exportCert.TypeOfFuel="Petrol";
        exportCert.TypeApproval="E11*2001/116*0268*09";
        exportCert.CO2= "*";
        exportCert.FirstReg="19/02/2010";
        exportCert.Name="Joe Kuberkubekue";
        exportCert.Address="1 Apple Tree Court";
        exportCert.Status="REGISTERED";
        exportCert.Notes="";
        exportCert.RegDate = LocalDateTime.now().plusDays(1L).toLocalDate().toString();


        String json = new ObjectMapper().writeValueAsString(exportCert);

        String result =  pdfGeneratorUtil.createPdf(json,"ExportCert");

        System.out.println("Result:" + result);


    }

}

