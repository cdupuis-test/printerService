package je.dvs.echo.printerservice.Domain;

import org.springframework.stereotype.Component;

@Component
public class Address {


    public String departmentName;
    public String subDepartmentName;
    public String street;
    public String parish;
    public String island;
    public String postcode;

    public Address() {
        this.departmentName = "Growth, Housing and Environment";
        this.subDepartmentName = "Driver and Vehicle Standards";
        this.street="La Collette";
        this.parish="St.Helier";
        this.island="Jersey";
        this.postcode="JE1 3UE";
    }

}
