package com.od.eisgroup.ui.beans;

import lombok.Getter;
import lombok.Setter;
import org.primefaces.PrimeFaces;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * The class represents controller for location pop-up window.
 * @author Vadim Martsun
 * @version since 1.1
 */
@Controller
@SessionScope
@Getter
@Setter
public class LocationController {

    private List<String> locations;
    private String[] selectedLocations;

    private boolean isAllSelected = false;

    @PostConstruct
    public void init(){

        locations = new ArrayList<>();
        locations.add("ODS");
        locations.add("MNSK");
        locations.add("RIX");

        //By default Odessa and Minsk should be checked
        selectedLocations = new String[]{"ODS","MNSK"};
    }

    public void selectAll(){
        if(isAllSelected){
            selectedLocations = locations.toArray(selectedLocations);
        }else{
            selectedLocations = new String[]{};
        }
        updateSelectedValues();
    }

    private void updateSelectedValues(){
        PrimeFaces.current().ajax().update("locDialogForm");
    }
}
