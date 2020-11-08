package utility.type;

/**
 * Created by raj on 11/6/2020.
 */
public enum AppointmentStatusType {

    NEW("New", 0), VISITED("Visited", 1),
    CANCELLED("Cancelled", 2), FREE("Free", 3), FAMILY("Family", 4);

    private String shortName;
    private int intValue;

    AppointmentStatusType(String name, int value){
        this.setShortName(name);
        this.setIntValue(value);
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }
}
