package zygmundfelt.dan.mesolabstrings;

import org.junit.*;

import java.io.File;
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
    public void deserializeFromCSVTest() {
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

    @Test
    public void individualRecordToArrayForJSONTest() {
        String string = "{\n" +
                "    \"licenseNumber\": \"L234252352391\",\n" +
                "    \"lastName\": \"Reeves\",\n" +
                "    \"firstName\": \"Keanu\",\n" +
                "    \"middleName\": \"\",\n" +
                "    \"address\": \"876 Zion Dr\",\n" +
                "    \"city\": \"White Plains\",\n" +
                "    \"state\": \"NY\",\n" +
                "    \"zipCode\": \"44444\",\n" +
                "    \"dateOfBirth\": \"6/6/1955\",\n" +
                "    \"issued\": \"6/9/2005\",\n" +
                "    \"expires\": \"6/9/2010\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"GRN\",\n" +
                "    \"height\": \"5'11\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  }";
        String[] expected = {"L234252352391","Reeves","Keanu","","876 Zion Dr","White Plains","NY","44444","6/6/1955","6/9/2005","6/9/2010","M","GRN","5'11","YES","D"};

        String[] actual = PADriversLicense.individualRecordToArray(string);

        for(int i = 0; i < 16; i++) {
            Assert.assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void toStringForJSONTest() {
        PADriversLicense dan = new PADriversLicense("001","Zygmund-Felt","Dan","C","123 Skidoo Ln","philadelphia","PA","19020","09/09/2009","12/12/2012", "12/12/2018","M","Brown","5'8","Yes", "D");
        String expected = "  {\n" +
                "    \"licenseNumber\": \"001\",\n" +
                "    \"lastName\": \"Zygmund-Felt\",\n" +
                "    \"firstName\": \"Dan\",\n" +
                "    \"middleName\": \"C\",\n" +
                "    \"address\": \"123 Skidoo Ln\",\n" +
                "    \"city\": \"philadelphia\",\n" +
                "    \"state\": \"PA\",\n" +
                "    \"zipCode\": \"19020\",\n" +
                "    \"dateOfBirth\": \"09/09/2009\",\n" +
                "    \"issued\": \"12/12/2012\",\n" +
                "    \"expires\": \"12/12/2018\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"Brown\",\n" +
                "    \"height\": \"5'8\",\n" +
                "    \"organDonor\": \"Yes\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n";

        String actual = PADriversLicense.toStringForJSON(dan);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deserializeFromJSONTest() {
        List<PADriversLicense> list = PADriversLicense.deserializeFromJSON("{\n" +
                "    \"licenseNumber\": \"L364856498487\",\n" +
                "    \"lastName\": \"Long\",\n" +
                "    \"firstName\": \"Aaron\",\n" +
                "    \"middleName\": \"C\",\n" +
                "    \"address\": \"456 Street Dr\",\n" +
                "    \"city\": \"Wilmington\",\n" +
                "    \"state\": \"NJ\",\n" +
                "    \"zipCode\": \"12345\",\n" +
                "    \"dateOfBirth\": \"06/17/1993\",\n" +
                "    \"issued\": \"06/17/2014\",\n" +
                "    \"expires\": \"06/30/2018\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"GRN\",\n" +
                "    \"height\": \"6'2\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L364856423452\",\n" +
                "    \"lastName\": \"Kim\",\n" +
                "    \"firstName\": \"Chris\",\n" +
                "    \"middleName\": \"\",\n" +
                "    \"address\": \"820 District Dr\",\n" +
                "    \"city\": \"Wilmington\",\n" +
                "    \"state\": \"DE\",\n" +
                "    \"zipCode\": \"54321\",\n" +
                "    \"dateOfBirth\": \"12/11/1980\",\n" +
                "    \"issued\": \"08/12/2013\",\n" +
                "    \"expires\": \"12/11/2018\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"BRO\",\n" +
                "    \"height\": \"6'5\",\n" +
                "    \"organDonor\": \"NO\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L363345398489\",\n" +
                "    \"lastName\": \"Stamatelos\",\n" +
                "    \"firstName\": \"Jarryd\",\n" +
                "    \"middleName\": \"\",\n" +
                "    \"address\": \"123 Main St\",\n" +
                "    \"city\": \"Wilmington\",\n" +
                "    \"state\": \"NJ\",\n" +
                "    \"zipCode\": \"21334\",\n" +
                "    \"dateOfBirth\": \"3/17/1988\",\n" +
                "    \"issued\": \"3/17/2016\",\n" +
                "    \"expires\": \"3/20/2020\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"BRO\",\n" +
                "    \"height\": \"7'0''\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L809239899490\",\n" +
                "    \"lastName\": \"Cage\",\n" +
                "    \"firstName\": \"Nick\",\n" +
                "    \"middleName\": \"Treasure\",\n" +
                "    \"address\": \"362 Fancy St\",\n" +
                "    \"city\": \"Los Angeles\",\n" +
                "    \"state\": \"CA\",\n" +
                "    \"zipCode\": \"55555\",\n" +
                "    \"dateOfBirth\": \"02/02/1970\",\n" +
                "    \"issued\": \"02/02/2000\",\n" +
                "    \"expires\": \"02/02/2006\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"BRO\",\n" +
                "    \"height\": \"6'0''\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L234252352391\",\n" +
                "    \"lastName\": \"Reeves\",\n" +
                "    \"firstName\": \"Keanu\",\n" +
                "    \"middleName\": \"\",\n" +
                "    \"address\": \"876 Zion Dr\",\n" +
                "    \"city\": \"White Plains\",\n" +
                "    \"state\": \"NY\",\n" +
                "    \"zipCode\": \"44444\",\n" +
                "    \"dateOfBirth\": \"6/6/1955\",\n" +
                "    \"issued\": \"6/9/2005\",\n" +
                "    \"expires\": \"6/9/2010\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"GRN\",\n" +
                "    \"height\": \"5'11\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  }");
        int expected = 5;

        int actual = list.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void serializeToJSONTest() {
        List<PADriversLicense> list = PADriversLicense.deserializeFromJSON("{\n" +
                "    \"licenseNumber\": \"L364856498487\",\n" +
                "    \"lastName\": \"Long\",\n" +
                "    \"firstName\": \"Aaron\",\n" +
                "    \"middleName\": \"C\",\n" +
                "    \"address\": \"456 Street Dr\",\n" +
                "    \"city\": \"Wilmington\",\n" +
                "    \"state\": \"NJ\",\n" +
                "    \"zipCode\": \"12345\",\n" +
                "    \"dateOfBirth\": \"06/17/1993\",\n" +
                "    \"issued\": \"06/17/2014\",\n" +
                "    \"expires\": \"06/30/2018\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"GRN\",\n" +
                "    \"height\": \"6'2\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L364856423452\",\n" +
                "    \"lastName\": \"Kim\",\n" +
                "    \"firstName\": \"Chris\",\n" +
                "    \"middleName\": \"\",\n" +
                "    \"address\": \"820 District Dr\",\n" +
                "    \"city\": \"Wilmington\",\n" +
                "    \"state\": \"DE\",\n" +
                "    \"zipCode\": \"54321\",\n" +
                "    \"dateOfBirth\": \"12/11/1980\",\n" +
                "    \"issued\": \"08/12/2013\",\n" +
                "    \"expires\": \"12/11/2018\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"BRO\",\n" +
                "    \"height\": \"6'5\",\n" +
                "    \"organDonor\": \"NO\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L363345398489\",\n" +
                "    \"lastName\": \"Stamatelos\",\n" +
                "    \"firstName\": \"Jarryd\",\n" +
                "    \"middleName\": \"\",\n" +
                "    \"address\": \"123 Main St\",\n" +
                "    \"city\": \"Wilmington\",\n" +
                "    \"state\": \"NJ\",\n" +
                "    \"zipCode\": \"21334\",\n" +
                "    \"dateOfBirth\": \"3/17/1988\",\n" +
                "    \"issued\": \"3/17/2016\",\n" +
                "    \"expires\": \"3/20/2020\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"BRO\",\n" +
                "    \"height\": \"7'0''\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L809239899490\",\n" +
                "    \"lastName\": \"Cage\",\n" +
                "    \"firstName\": \"Nick\",\n" +
                "    \"middleName\": \"Treasure\",\n" +
                "    \"address\": \"362 Fancy St\",\n" +
                "    \"city\": \"Los Angeles\",\n" +
                "    \"state\": \"CA\",\n" +
                "    \"zipCode\": \"55555\",\n" +
                "    \"dateOfBirth\": \"02/02/1970\",\n" +
                "    \"issued\": \"02/02/2000\",\n" +
                "    \"expires\": \"02/02/2006\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"BRO\",\n" +
                "    \"height\": \"6'0''\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L234252352391\",\n" +
                "    \"lastName\": \"Reeves\",\n" +
                "    \"firstName\": \"Keanu\",\n" +
                "    \"middleName\": \"\",\n" +
                "    \"address\": \"876 Zion Dr\",\n" +
                "    \"city\": \"White Plains\",\n" +
                "    \"state\": \"NY\",\n" +
                "    \"zipCode\": \"44444\",\n" +
                "    \"dateOfBirth\": \"6/6/1955\",\n" +
                "    \"issued\": \"6/9/2005\",\n" +
                "    \"expires\": \"6/9/2010\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"GRN\",\n" +
                "    \"height\": \"5'11\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  }");
        String expected = "[\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L364856498487\",\n" +
                "    \"lastName\": \"Long\",\n" +
                "    \"firstName\": \"Aaron\",\n" +
                "    \"middleName\": \"C\",\n" +
                "    \"address\": \"456 Street Dr\",\n" +
                "    \"city\": \"Wilmington\",\n" +
                "    \"state\": \"NJ\",\n" +
                "    \"zipCode\": \"12345\",\n" +
                "    \"dateOfBirth\": \"06/17/1993\",\n" +
                "    \"issued\": \"06/17/2014\",\n" +
                "    \"expires\": \"06/30/2018\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"GRN\",\n" +
                "    \"height\": \"6'2\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L364856423452\",\n" +
                "    \"lastName\": \"Kim\",\n" +
                "    \"firstName\": \"Chris\",\n" +
                "    \"middleName\": \"\",\n" +
                "    \"address\": \"820 District Dr\",\n" +
                "    \"city\": \"Wilmington\",\n" +
                "    \"state\": \"DE\",\n" +
                "    \"zipCode\": \"54321\",\n" +
                "    \"dateOfBirth\": \"12/11/1980\",\n" +
                "    \"issued\": \"08/12/2013\",\n" +
                "    \"expires\": \"12/11/2018\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"BRO\",\n" +
                "    \"height\": \"6'5\",\n" +
                "    \"organDonor\": \"NO\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L363345398489\",\n" +
                "    \"lastName\": \"Stamatelos\",\n" +
                "    \"firstName\": \"Jarryd\",\n" +
                "    \"middleName\": \"\",\n" +
                "    \"address\": \"123 Main St\",\n" +
                "    \"city\": \"Wilmington\",\n" +
                "    \"state\": \"NJ\",\n" +
                "    \"zipCode\": \"21334\",\n" +
                "    \"dateOfBirth\": \"3/17/1988\",\n" +
                "    \"issued\": \"3/17/2016\",\n" +
                "    \"expires\": \"3/20/2020\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"BRO\",\n" +
                "    \"height\": \"7'0''\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L809239899490\",\n" +
                "    \"lastName\": \"Cage\",\n" +
                "    \"firstName\": \"Nick\",\n" +
                "    \"middleName\": \"Treasure\",\n" +
                "    \"address\": \"362 Fancy St\",\n" +
                "    \"city\": \"Los Angeles\",\n" +
                "    \"state\": \"CA\",\n" +
                "    \"zipCode\": \"55555\",\n" +
                "    \"dateOfBirth\": \"02/02/1970\",\n" +
                "    \"issued\": \"02/02/2000\",\n" +
                "    \"expires\": \"02/02/2006\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"BRO\",\n" +
                "    \"height\": \"6'0''\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"licenseNumber\": \"L234252352391\",\n" +
                "    \"lastName\": \"Reeves\",\n" +
                "    \"firstName\": \"Keanu\",\n" +
                "    \"middleName\": \"\",\n" +
                "    \"address\": \"876 Zion Dr\",\n" +
                "    \"city\": \"White Plains\",\n" +
                "    \"state\": \"NY\",\n" +
                "    \"zipCode\": \"44444\",\n" +
                "    \"dateOfBirth\": \"6/6/1955\",\n" +
                "    \"issued\": \"6/9/2005\",\n" +
                "    \"expires\": \"6/9/2010\",\n" +
                "    \"sex\": \"M\",\n" +
                "    \"eyes\": \"GRN\",\n" +
                "    \"height\": \"5'11\",\n" +
                "    \"organDonor\": \"YES\",\n" +
                "    \"licenseClass\": \"D\"\n" +
                "  }\n" +
                "]";

        String actual = PADriversLicense.serializeToJSON(list);

        Assert.assertEquals(expected, actual);
    }

    @Test (expected = FormatNotAcceptedException.class)
    public void deserializeNotAcceptedPDFTest() throws FormatNotAcceptedException {
        PADriversLicense.deserialize("thisisthetextfromafile","PDF");
    }

    @Test (expected = FormatNotAcceptedException.class)
    public void deserializeNotAcceptedCVSTest() throws FormatNotAcceptedException {
        PADriversLicense.deserialize("heyitssomemorefiletext","CVS");
    }

}
