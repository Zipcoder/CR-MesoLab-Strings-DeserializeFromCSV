package com.zipcode.stringslab;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Create a DriversLicense class with fields found on a typical driver's license. Write a serializeToCSV method that
 * returns a string of comma separated values for the fields in the Driver's License, and a static getCSVHeader method
 * that produces the comma separated header for the CSV fields.
 * <p>
 * Created by vidyachandasekhar on 5/21/17.
 */


public class DriversLicense {

    private String lastName;
    private String firstName;
    private String address;
    private String state;
    private String licenseNumber;
    private String dateOfBirth;
    private String dateOfIssue;
    private String dateOfExpiry;
    private String gender;
    private String eyeColor;
    private String height;
    private String organDonor;
    private String licenseClass;

    private static DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getOrganDonor() {
        return organDonor;
    }

    public void setOrganDonor(String organDonor) {
        this.organDonor = organDonor;
    }

    public String getLicenseClass() {
        return licenseClass;
    }

    public void setLicenseClass(String licenseClass) {
        this.licenseClass = licenseClass;
    }

    // a string of comma separated values for the fields in the Driver's License
    public String serializeToCSV() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(lastName);
        stringBuilder.append(',');
        stringBuilder.append(firstName);
        stringBuilder.append(',');
        stringBuilder.append(address);
        stringBuilder.append(',');
        stringBuilder.append(state);
        stringBuilder.append(',');
        stringBuilder.append(licenseNumber);
        stringBuilder.append(',');
        stringBuilder.append(dateOfBirth);
        stringBuilder.append(',');
        stringBuilder.append(dateOfIssue);
        stringBuilder.append(',');
        stringBuilder.append(dateOfExpiry);
        stringBuilder.append(',');
        stringBuilder.append(gender);
        stringBuilder.append(',');
        stringBuilder.append(eyeColor);
        stringBuilder.append(',');
        stringBuilder.append(height);
        stringBuilder.append(',');
        stringBuilder.append(organDonor);
        stringBuilder.append(',');
        stringBuilder.append(licenseClass);

        return stringBuilder.toString();
    }

    //produces the comma separated header for the CSV fields
    public static String getCSVHeader() {
        return "LAST_NAME,FIRST_NAME,ADDRESS,STATE,LICENSE_NUMBER,DATE_OF_BIRTH,DATE_OF_ISSUE,DATE_OF_EXPIRY," +
                "GENDER,EYES_COLOR,HEIGHT,ORGAN_DONOR,LICENSE_CLASS";
    }

    // takes a string representing the contents of a CSV file produced using getCSVHeader and serializeToCSV
    // and reproduces a List of Driver's License objects that match the contents of the file.
    public static List<DriversLicense> deserializeFromCSV(String licenseDataCSVString) {

        BufferedReader bufferedReader = new BufferedReader(new StringReader(licenseDataCSVString));
        List<DriversLicense> returnList = new ArrayList<>();
        try {
            String line = bufferedReader.readLine();
            boolean  isHeader = true;


            while (line != null) {

                if (isHeader){
                    isHeader=false;
                    line = bufferedReader.readLine();
                    continue;
                }

                // use comma as separator
                String[] licenseDataArray = line.split(",");

                DriversLicense driversLicense = new DriversLicense();
                driversLicense.setLastName(licenseDataArray[0]);
                driversLicense.setFirstName(licenseDataArray[1]);
                driversLicense.setAddress(licenseDataArray[2]);
                driversLicense.setState(licenseDataArray[3]);
                driversLicense.setLicenseNumber(licenseDataArray[4]);

                driversLicense.setDateOfBirth(licenseDataArray[5]);
                driversLicense.setDateOfIssue(licenseDataArray[6]);
                driversLicense.setDateOfExpiry(licenseDataArray[7]);

                driversLicense.setGender(licenseDataArray[8]);
                driversLicense.setEyeColor(licenseDataArray[9]);
                driversLicense.setHeight(licenseDataArray[10]);
                driversLicense.setOrganDonor(licenseDataArray[11]);
                driversLicense.setLicenseClass(licenseDataArray[12]);

                returnList.add(driversLicense);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred while processing the CSV file");
        }
        return returnList;

    }

}
