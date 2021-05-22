package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpHistoryOption {

    private Integer id;
    private Integer historyID;
    private String optionName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHistoryID() {
        return historyID;
    }

    public void setHistoryID(Integer historyID) {
        this.historyID = historyID;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
