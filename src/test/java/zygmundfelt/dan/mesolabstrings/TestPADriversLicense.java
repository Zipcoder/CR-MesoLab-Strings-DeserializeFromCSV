package zygmundfelt.dan.mesolabstrings;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class TestPADriversLicense {

    @Test
    public void getCSVHeaderTest() {
        String expected = "licenseNumber,lastName,firstName,middleName,address,city,state,zipCode,dateOfBirth,issued,expires,sex,eyes,height,organDonor,licenseClass,";

        String actual = PADriversLicense.getCSVHeader();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void serializeToCSVSingleRecordTest() {
        List<PADriversLicense> list = new ArrayList<PADriversLicense>();
        list.add(new PADriversLicense("001","Zygmund-Felt","Dan","C","123 Skidoo Ln","philadelphia","PA","19020","09/09/2009","12/12/2012", "12/12/2018","M","Brown","5'8","Yes", "D"));
        String expected = "licenseNumber,lastName,firstName,middleName,address,city,state,zipCode,dateOfBirth,issued,expires,sex,eyes,height,organDonor,licenseClass,001,Zygmund-Felt,Dan,C,123 Skidoo Ln,philadelphia,PA,19020,09/09/2009,12/12/2012,12/12/2018,M,Brown,5'8,Yes,D";

        String actual = PADriversLicense.serializeToCSV(list);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deserializeTest() {

    }
}
