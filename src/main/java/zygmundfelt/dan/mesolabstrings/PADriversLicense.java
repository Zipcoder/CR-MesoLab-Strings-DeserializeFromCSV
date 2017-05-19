package zygmundfelt.dan.mesolabstrings;

import java.util.ArrayList;
import java.util.List;

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

    //TODO - check input to ensure valid header
    public static List<PADriversLicense> deserialize(String input) {
        String[] arr = input.split(",");
        List<PADriversLicense> list = new ArrayList<PADriversLicense>();
        for(int i = 1; i < arr.length / 16; i++) {
            list.add(new PADriversLicense(arr[i*16],arr[i*16 + 1],arr[i*16 + 2],arr[i*16+3],arr[i*16+4],arr[i*16+5],arr[i*16 + 6],arr[i*16 + 7],arr[i*16 + 8],arr[i*16 + 9],arr[i*16 + 10],arr[i*16 + 11],arr[i*16 + 12],arr[i*16 + 13],arr[i*16 + 14],arr[i*16 + 15]));
        }
        return list;
    }

    public static String getCSVHeader() {
        return "licenseNumber,lastName,firstName,middleName,address,city,state,zipCode,dateOfBirth,issued,expires,sex,eyes,height,organDonor,licenseClass,";
    }

    public static String serializeToCSV(List<PADriversLicense> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(getCSVHeader());
        for(PADriversLicense license : list) {
            sb.append(license.toStringForCSV());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
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
                + licenseClass;
    }

}
