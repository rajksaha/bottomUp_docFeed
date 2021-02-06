package utility.type;

/**
 * Created by raj on 2/6/2021.
 */
public enum PresContentDetailType {
    DRUG("DRUG", "presDrugID"),
    COMPLAIN("COMPLAIN", "complainID"),
    ADVICE("ADVICE", "presAdviceID"),
    INV("INV", "presInvID"),
    DIAGNOSIS("DIAGNOSIS", "diagnosisID"),
    DIET("DIET", "contentDetailID"),
    OLD_DRUG("OLD_DRUG", "contentDetailID"),
    CURR_DRUG("CURR_DRUG", "contentDetailID"),
    COMMENT("COMMENT", "contentDetailID"),
    HISTORY("HISTORY", "presHistoryID"),
    FAMILY_HISTORY("FAMILY_HISTORY", "presFamilyDiseaseID"),
    PAST_HISTORY("PAST_HISTORY", "presPastDiseaseID"),
    ;

    private String shortName;
    private String idName;

    PresContentDetailType(String shortName, String id){
        this.setShortName(shortName);
        this.setIdName(id);
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }
}
