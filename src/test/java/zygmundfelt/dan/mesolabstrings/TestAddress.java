package zygmundfelt.dan.mesolabstrings;

import org.junit.*;

public class TestAddress {

    @Test
    public void toStringForCSVTest() {
        Address address = new Address("100 Emoji Blvd", "Philadelphia", "PA", "19100");
        String expected = "100 Emoji Blvd,Philadelphia,PA,19100";

        String actual = address.toStringForCSV();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringForCSVEmptyTest() {
        Address address = new Address("", "", "", "");
        String expected = ",,,";

        String actual = address.toStringForCSV();

        Assert.assertEquals(expected, actual);
    }
}
