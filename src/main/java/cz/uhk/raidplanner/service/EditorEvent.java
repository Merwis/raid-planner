package cz.uhk.raidplanner.service;

import java.beans.PropertyEditorSupport;

import cz.uhk.raidplanner.entity.Event;
import cz.uhk.raidplanner.entity.EventTemplate;
import cz.uhk.raidplanner.entity.MyCharacter;

public class EditorEvent extends PropertyEditorSupport {

    private final EventService ets;

    public EditorEvent(EventService ets){
        this.ets=ets;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        Event et=ets.findOne(Integer.parseInt(text));
        setValue(et);
    }
}
