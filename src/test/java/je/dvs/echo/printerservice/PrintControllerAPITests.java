package je.dvs.echo.printerservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import je.dvs.echo.printerservice.Domain.VRD1;
import je.dvs.echo.printerservice.Service.PdfGeneratorUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@Ignore
public class PrintControllerAPITests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PdfGeneratorUtil pdfGeneratorUtil;

    String RegistrationMark = "J23345";
    String DocUUID = "34555-55644-2222";
    String DocSeq = "3";
    String DateofIssue = "22/11/2009";
    String Fullname = "Sam Smith";
    String Address1 = "4";
    String Address2 = "Appletree Court";
    String Address3 = "St.Helier";
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

    }

    @Test
    public void printVRD1() throws Exception {

        List<VRD1> listVRD1 = new ArrayList<>();




        VRD1 vrd1 = new VRD1();
        vrd1.setRegistrationMark(RegistrationMark);
        vrd1.setDocUUID(DocUUID);
        vrd1.setDocSeq(DocSeq);
        vrd1.setDateofIssue(DateofIssue);
        vrd1.setFullname(Fullname);
        vrd1.setAddress1(Address1);
        vrd1.setAddress2(Address2);
        vrd1.setAddress3(Address3);
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

        listVRD1.add(vrd1);

        String json = new ObjectMapper().writeValueAsString(listVRD1);

        String Result = pdfGeneratorUtil.createPdf(json, "VRD1");

        given(pdfGeneratorUtil.createPdf(json,"VRD1")).willReturn(new String("Test"));

        MvcResult result = this.mockMvc.perform(post("/print/VRD1").param("VRD1Data",json)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        assertTrue(content.equals("Test"));
    }



}
