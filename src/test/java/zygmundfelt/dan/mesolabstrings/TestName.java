package zygmundfelt.dan.mesolabstrings;

import org.junit.*;

public class TestName {

    @Test
    public void toStringForCSVTest() {
        Name name = new Name("Zygmund-Felt", "Daniel", "C");
        String expected = "Zygmund-Felt,Daniel,C";

        String actual = name.toStringForCSV();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringForCSVNoMiddleTest() {
        Name name = new Name("Zygmund-Felt", "Daniel", "");
        String expected = "Zygmund-Felt,Daniel,";

        String actual = name.toStringForCSV();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringForCSVEmptyTest() {
        Name name = new Name("", "", "");
        String expected = ",,";

        String actual = name.toStringForCSV();

        Assert.assertEquals(expected, actual);
    }
}
