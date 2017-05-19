package zygmundfelt.dan.mesolabstrings;


import java.lang.reflect.Field;

public abstract class DriversLicense {
//this would be problematic because the order is indeterminate.
    public String getHeaders() {
        StringBuilder sb = new StringBuilder();
        for(Field field : this.getClass().getFields()) {
            sb.append(field.getName());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
