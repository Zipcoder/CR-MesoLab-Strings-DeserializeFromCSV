package com.zipcode.stringslab;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by vidyachandasekhar on 5/21/17.
 */
public class DriversLicenseTest {

    private static DateFormat df =  new SimpleDateFormat("MM/dd/yyyy");
    @Test
    public void serializeToCSV() throws Exception {
        //given (we create an instance of the DriversLicense class with all the fields,and this method is supposed
        //to return all the fields in VSV format.

         DriversLicense dl = new DriversLicense();

        dl.setLastName("Reeves");
        dl.setFirstName("Keanu");
        dl.setAddress("876 Zion Dr");
        dl.setState("NY");
        dl.setLicenseNumber("L234252352391");
        dl.setDateOfBirth("6/6/1955");
        dl.setDateOfIssue("6/9/2005");
        dl.setDateOfExpiry("6/9/2010");
        dl.setGender("M");
        dl.setEyeColor("GRN");
        dl.setHeight("5'11");
        dl.setOrganDonor("YES");
        dl.setLicenseClass("D");

        //when
       String expected= "Reeves,Keanu,876 Zion Dr,NY,L234252352391,6/6/1955,6/9/2005,6/9/2010,M,GRN,5'11,YES,D";

        //then
        Assert.assertEquals("Both strings are matching ",expected,dl.serializeToCSV());
    }

    @Test
    public void getCSVHeader() throws Exception {
        //given(as this is a Static method, we are creating a new instance of the main class)

        //when
       String actual ="LAST_NAME,FIRST_NAME,ADDRESS,STATE,LICENSE_NUMBER,DATE_OF_BIRTH,DATE_OF_ISSUE,DATE_OF_EXPIRY," +
                "GENDER,EYES_COLOR,HEIGHT,ORGAN_DONOR,LICENSE_CLASS";
        //then
        Assert.assertEquals("Both strings are matching ",DriversLicense.getCSVHeader(), actual);
    }

    @Test
    public void deserializeFromCSV() throws Exception {
        //given
        DriversLicense driversLicense = new DriversLicense();
        //when
        String csvString = "LAST_NAME,FIRST_NAME,ADDRESS,STATE,LICENSE_NUMBER,DATE_OF_BIRTH,DATE_OF_ISSUE,DATE_OF_EXPIRY," +
                "GENDER,EYES_COLOR,HEIGHT,ORGAN_DONOR,LICENSE_CLASS\n"
                + "Cage,Nick,362 Fancy St,CA,L809239899490,02/02/1970,02/02/2000,02/02/2006,M,BRO,6'0\",YES,D\n"
                +"Zach,Leon,1234 BadAtSmash Ln,DE,L101234107890,1/2/3456,3/3/2000,5/19/2107,M,BRO,4'3,NO,D\n"
                +"Utah,Johnny,932 PointBreak Rd,CA,L223523438497,2/5/1988,4/4/2000,4/4/2010,M,BRO,5'11,NO,D\n";
        List<DriversLicense> returnList =  driversLicense.deserializeFromCSV(csvString);


        //then
        Assert.assertNotNull(returnList);
        Assert.assertEquals(3, returnList.size());

        DriversLicense dl1 = returnList.get(0);
        Assert.assertEquals("Cage", dl1.getLastName());
        Assert.assertEquals("Nick", dl1.getFirstName());
        Assert.assertEquals("362 Fancy St", dl1.getAddress());
        Assert.assertEquals("CA", dl1.getState());
        Assert.assertEquals("L809239899490", dl1.getLicenseNumber());
        Assert.assertEquals("02/02/1970", dl1.getDateOfBirth());
        Assert.assertEquals("02/02/2000", dl1.getDateOfIssue());
        Assert.assertEquals("02/02/2006", dl1.getDateOfExpiry());
        Assert.assertEquals("M", dl1.getGender());
        Assert.assertEquals("BRO", dl1.getEyeColor());
        Assert.assertEquals("6'0\"", dl1.getHeight());
        Assert.assertEquals("YES", dl1.getOrganDonor());
        Assert.assertEquals("D", dl1.getLicenseClass());


    }

}