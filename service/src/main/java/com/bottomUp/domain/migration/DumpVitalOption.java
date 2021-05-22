package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpVitalOption {

    private Integer id;
    private Integer vitalId;
    private String  name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVitalId() {
        return vitalId;
    }

    public void setVitalId(Integer vitalId) {
        this.vitalId = vitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
