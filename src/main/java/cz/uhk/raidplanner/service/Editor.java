package cz.uhk.raidplanner.service;

import java.beans.PropertyEditorSupport;

import cz.uhk.raidplanner.entity.EventTemplate;

public class Editor extends PropertyEditorSupport {

    private final EventTemplateService ets;

    public Editor(EventTemplateService ets){
        this.ets=ets;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        EventTemplate et=ets.findOne(Integer.parseInt(text));
        setValue(et);
    }
}
