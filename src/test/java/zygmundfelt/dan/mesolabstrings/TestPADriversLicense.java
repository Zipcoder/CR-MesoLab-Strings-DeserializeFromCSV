package zygmundfelt.dan.mesolabstrings;

import org.junit.*;

public class TestPADriversLicense {

    @Test
    public void getCSVHeaderTest() {
        String expected = "licenseNumber,lastName,firstName,middleName,address,city,state,zipCode,dateOfBirth,issued,expires,sex,eyes,height,organDonor,licenseClass";

        String actual = PADriversLicense.getCSVHeader();

        Assert.assertEquals(expected, actual);
    }

    

}
