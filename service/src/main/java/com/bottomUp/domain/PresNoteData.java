package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

import java.util.List;

/**
 * Created by raj on 1/10/2021.
 */
public class PresNoteData extends BaseData{

    private String header;
    private List<String> noteList;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<String> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<String> noteList) {
        this.noteList = noteList;
    }
}
