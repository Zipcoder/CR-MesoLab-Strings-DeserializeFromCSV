package zygmundfelt.dan.mesolabstrings;

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
    private String sex;
    private String licenseClass;
    private String eyes;
    private String height;
    private String issued;
    private String expires;
    private String organDonor;

    public PADriversLicense(String licenseNumber, String lastName, String firstName, String middleName, String address, String city, String state, String zipCode, String dateOfBirth, String sex, String licenseClass, String eyes, String height, String issued, String expires, String organDonor) {
        this.licenseNumber = licenseNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.licenseClass = licenseClass;
        this.eyes = eyes;
        this.height = height;
        this.issued = issued;
        this.expires = expires;
        this.organDonor = organDonor;
    }

    //TODO
    public static List<PADriversLicense> deserialize(String input) {
        return null;
    }

    //TODO
    public static String getCSVHeader() {
        return "licenseNumber,lastName,firstName,middleName,address,city,state,zipCode,dateOfBirth,issued,expires,sex,eyes,height,organDonor,licenseClass";
    }

    //TODO
    public String serializeToCSV(List<PADriversLicense> list) {
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
