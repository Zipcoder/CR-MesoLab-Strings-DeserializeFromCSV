package zygmundfelt.dan.mesolabstrings;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class TestPADriversLicense {

    @Test
    public void getCSVHeaderTest() {
        String expected = "licenseNumber,lastName,firstName,middleName,address,city,state,zipCode,dateOfBirth,issued,expires,sex,eyes,height,organDonor,licenseClass\n";

        String actual = PADriversLicense.getCSVHeader();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringForCSVTest() {
        PADriversLicense dan = new PADriversLicense("001","Zygmund-Felt","Dan","C","123 Skidoo Ln","philadelphia","PA","19020","09/09/2009","12/12/2012", "12/12/2018","M","Brown","5'8","Yes", "D");
        String expected = "001,Zygmund-Felt,Dan,C,123 Skidoo Ln,philadelphia,PA,19020,09/09/2009,12/12/2012,12/12/2018,M,Brown,5'8,Yes,D\n";
    }

    @Test
    public void serializeToCSVSingleRecordTest() {
        List<PADriversLicense> list = new ArrayList<PADriversLicense>();
        list.add(new PADriversLicense("001","Zygmund-Felt","Dan","C","123 Skidoo Ln","philadelphia","PA","19020","09/09/2009","12/12/2012", "12/12/2018","M","Brown","5'8","Yes", "D"));
        String expected = "licenseNumber,lastName,firstName,middleName,address,city,state,zipCode,dateOfBirth,issued,expires,sex,eyes,height,organDonor,licenseClass\n" +
                "001,Zygmund-Felt,Dan,C,123 Skidoo Ln,philadelphia,PA,19020,09/09/2009,12/12/2012,12/12/2018,M,Brown,5'8,Yes,D\n";

        String actual = PADriversLicense.serializeToCSV(list);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deserializeTest() {
        String string = "licenseNumber,lastName,firstName,middleName,address,city,state,zipCode,dateOfBirth,issued,expires,sex,eyes,height,organDonor,licenseClass\n" +
                "L098886498494,Lomax,Kevin,,9234 High St,Wilmington,MI,11111,9/3/1940,8/8/2008,8/8/2018,M,BRO,6'0'',YES,D\n" +
                "L234234598495,Wick,John,Dogshead,2190 Badass Alley,Brooklyn,NY ,12321,6/6/1977,3/3/2000,1/1/2010,M,GRN,6'0'',YES,D\n" +
                "L234235236253,Wyler,Alex,,234 Lake House St,Oswego,NY,32123,7/8/2000,4/8/2017,4/8/2027,M,BRO,5'11,YES,D\n" +
                "L223523438497,Utah,Johnny,Salt,932 PointBreak Rd,Encino,CA,65456,2/5/1988,4/4/2000,4/4/2010,M,BRO,5'11,NO,D\n" +
                "L101234101010,Starr,Patrick,,101 UnderTheSea Ct,Wilmington,HI,77777,10/07/1987,02-30-2010,02/30/2010,M,BRO,6'1,NO,D\n" +
                "L101234107890,Zach,Leon,L,1234 BadAtSmash Ln,Wilmington,DE,99909,1/2/3456,3/3/2000,5/19/2107,M,BRO,4'3,NO,D";
        int expected = 6;

        List<PADriversLicense> list = PADriversLicense.deserializeFromCSV(string);
        int actual = list.size();

        Assert.assertEquals(expected, actual);
    }

}
