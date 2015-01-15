package cz.uhk.raidplanner.service;

import java.beans.PropertyEditorSupport;

import cz.uhk.raidplanner.entity.EventTemplate;
import cz.uhk.raidplanner.entity.MyCharacter;

public class EditorCharacter extends PropertyEditorSupport {

    private final MyCharacterService ets;

    public EditorCharacter(MyCharacterService ets){
        this.ets=ets;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        MyCharacter et=ets.findOne(Integer.parseInt(text));
        setValue(et);
    }
}
