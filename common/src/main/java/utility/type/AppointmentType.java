package utility.type;

/**
 * Created by raj on 11/6/2020.
 */
public enum AppointmentType {
    NEW_APP("New Appointment", 0), OLD_APP("Old Appointment", 1),
    REPORT("Report", 2), FREE("Free", 3), FAMILY("Family", 4);

    private String shortName;
    private int intValue;

    AppointmentType(String name, int value){
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
