package zygmundfelt.dan.mesolabstrings;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PADriversLicense {

    private String licenseNumber;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String dateOfBirth;
    private String issued;
    private String expires;
    private String sex;
    private String eyes;
    private String height;
    private String organDonor;
    private String licenseClass;

    public PADriversLicense(String licenseNumber, String lastName, String firstName, String middleName, String address, String city, String state, String zipCode, String dateOfBirth, String issued, String expires, String sex, String eyes, String height, String organDonor, String licenseClass) {
        this.licenseNumber = licenseNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.dateOfBirth = dateOfBirth;
        this.issued = issued;
        this.expires = expires;
        this.sex = sex;
        this.eyes = eyes;
        this.height = height;
        this.organDonor = organDonor;
        this.licenseClass = licenseClass;
    }

    private PADriversLicense(String[] arr) {
        licenseNumber = arr[0];
        lastName = arr[1];
        firstName = arr[2];
        middleName = arr[3];
        address = arr[4];
        city = arr[5];
        state = arr[6];
        zipCode = arr[7];
        dateOfBirth = arr[8];
        issued = arr[9];
        expires = arr[10];
        sex = arr[11];
        eyes = arr[12];
        height = arr[13];
        organDonor = arr[14];
        licenseNumber = arr[15];
    }

    /*
    Can be used for CSV or JSON.
     */
    public static String fileToString(File file) throws IOException {
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);
        String output = "";
        for (String line; (line = bReader.readLine()) != null; output += line + "\n");
        return output;
    }

    //TODO - check input to ensure valid header
    public static List<PADriversLicense> deserializeFromCSV(String string) {
        List<PADriversLicense> list = new ArrayList<PADriversLicense>();
        String[] lineBreaks = string.split("\n");
        for(int i = 1; i < lineBreaks.length; i++) {
            String[] arr = lineBreaks[i].split(",");
            list.add(new PADriversLicense(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[9],arr[10],arr[11],arr[12],arr[13],arr[14],arr[15]));
        }
        return list;
    }

    public static String getCSVHeader() {
        return "licenseNumber,lastName,firstName,middleName,address,city,state,zipCode,dateOfBirth,issued,expires,sex,eyes,height,organDonor,licenseClass\n";
    }

    public static String serializeToCSV(List<PADriversLicense> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(getCSVHeader());
        for(PADriversLicense license : list) {
            sb.append(license.toStringForCSV());
        }
        return sb.toString();
    }

    public String toStringForCSV() {
        return licenseNumber + ","
                + lastName + ","
                + firstName + ","
                + middleName + ","
                + address + ","
                + city + ","
                + state + ","
                + zipCode + ","
                + dateOfBirth + ","
                + issued + ","
                + expires + ","
                + sex + ","
                + eyes + ","
                + height + ","
                + organDonor + ","
                + licenseClass + "\n";
    }

    /*
    Split into individual records.
     */
    private static List<String> splitToIndividualRecords(String string) {
        Pattern pattern = Pattern.compile("\\{(\\s)+(\"[a-zA-Z0-9]+\": (\"([a-zA-Z0-9/' ]+)\"|\"\"),?\\s+)+}");
        Matcher m = pattern.matcher(string);
        ArrayList<String> matches = new ArrayList<String>();
        while(m.find()) {
            matches.add(m.group());
        }
        //for(String s : matches) System.out.println(s);
        return matches;
    }

    /*
    Put every field of an individual record into an array.
     */
    public static String[] individualRecordToArray(String string) {
        Pattern pattern = Pattern.compile("\"([a-zA-Z0-9/' ]*)\"");
        Matcher m = pattern.matcher(string);
        String[] individualRecord = new String[16];
        int i = 0;
        while(m.find()) {
            m.find();
            individualRecord[i] = m.group().replaceAll("\"","");
            i++;
        }
        return individualRecord;
    }


    public static List<PADriversLicense> deserializeFromJSON(String string) {
        List<PADriversLicense> list = new ArrayList<PADriversLicense>();
        List<String> stringList = splitToIndividualRecords(string);
        for(String record : stringList) {
            String[] fieldArray = individualRecordToArray(record);
            list.add(new PADriversLicense(fieldArray));
        }
        return list;
    }

    public static String serializeToJSON(List<PADriversLicense> list) {

        return null;
    }

    public static String toStringForJSON(PADriversLicense license) {
        return "{\n" +
                "    \"licenseNumber\": \"" + license.licenseNumber + "\",\n" +
                "    \"lastName\": \"" + license.lastName + "\",\n" +
                "    \"firstName\": \"" + license.firstName + "\",\n" +
                "    \"middleName\": \"" + license.middleName + "\",\n" +
                "    \"address\": \"" + license.address + "\",\n" +
                "    \"city\": \"" + license.city + "\",\n" +
                "    \"state\": \"" + license.state + "\",\n" +
                "    \"zipCode\": \"" + license.zipCode + "\",\n" +
                "    \"dateOfBirth\": \"" + license.dateOfBirth + "\",\n" +
                "    \"issued\": \"" + license.issued + "\",\n" +
                "    \"expires\": \"" + license.expires + "\",\n" +
                "    \"sex\": \"" + license.sex + "\",\n" +
                "    \"eyes\": \"" + license.eyes + "\",\n" +
                "    \"height\": \"" + license.height + "\",\n" +
                "    \"organDonor\": \"" + license.organDonor + "\",\n" +
                "    \"licenseClass\": \"" + license.licenseClass + "\"\n" +
                "  }";
    }

    public static void main(String[] args) {
        deserializeFromJSON("{\n" +
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
    }

}
