package zygmundfelt.dan.mesolabstrings;


public class Name {

    private String firstName;
    private String lastName;
    private String middleName;

    Name(String last, String first, String middle) {
        lastName = last;
        firstName = first;
        middleName = middle;
    }

    public String toStringForCSV() {
        return lastName + "," + firstName + "," + middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
