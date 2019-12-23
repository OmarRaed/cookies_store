package view.backing;


import com.team1.doses.dto.AntipyreticDto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "backing_Antipyretic")
@RequestScoped
@Generated(value = "1Antipyretic.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Antipyretic {
    private String selectedAntipyretic;
    private static ArrayList<AntipyreticDto> antipyreticList = new ArrayList<AntipyreticDto>();

    private Integer weight;
    private String result;
    public static Map<String, String> antipyretic_Names;
    static {
        AntipyreticDto Ibuprofen_100_Mg_5ML = new AntipyreticDto(10 * 3, 100, 3, "Ibuprofen_100_Mg_5ML");
        AntipyreticDto Paracetamol_250_Mg_5ML = new AntipyreticDto(10 * 3, 250, 3, "Paracetamol_250_Mg_5ML");
        AntipyreticDto Declophenac_2_Mg_1ML = new AntipyreticDto(3, 2 * 5, 3, "Declophenac_2_Mg_1ML");

        antipyreticList.add(Ibuprofen_100_Mg_5ML);
        antipyreticList.add(Paracetamol_250_Mg_5ML);
        antipyreticList.add(Declophenac_2_Mg_1ML);

        antipyretic_Names = new LinkedHashMap<String, String>();
        for (int i = 0; i < antipyreticList.size(); i++) {
            antipyretic_Names.put(antipyreticList.get(i).getName(), antipyreticList.get(i).getName());
        }
    }

    public Map<String, String> getAntipyretic_NamesInMap() {
        return antipyretic_Names;
    }


    public void setSelectedAntipyretic(String selectedInjection) {
        this.selectedAntipyretic = selectedInjection;
    }

    public String getSelectedAntipyretic() {
        return selectedAntipyretic;
    }

    public void setAntipyreticList(ArrayList<AntipyreticDto> antipyreticList) {
        this.antipyreticList = antipyreticList;
    }

    public ArrayList<AntipyreticDto> getAntipyreticList() {
        return antipyreticList;
    }

    // this method to add injections to list dynamiclly but for no staticlly (intialization list)


    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    //method called when click on calculate button
    public void calculateDose() {
        int dosePerKg = 1;
        int doseNumber = 1;
        int concentration = 1;
        int doseResult;

        //String injectionSelected = getSelectedInjection();

        for (int i = 0; i < antipyreticList.size(); i++) {
            if (selectedAntipyretic.equals(antipyreticList.get(i).getName())) {
                dosePerKg = antipyreticList.get(i).getDosePerKg();
                doseNumber = antipyreticList.get(i).getDoseNumber();

            }

        }

        //50
        //Get result from equation
        doseResult = weight * dosePerKg * 5 / (concentration * doseNumber);


        //set result to textView
        result = new String(" " + doseResult);

    }


    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public static void setAntipyretic_Names(Map<String, String> antipyretic_Names) {
        Antipyretic.antipyretic_Names = antipyretic_Names;
    }

    public static Map<String, String> getAntipyretic_Names() {
        return antipyretic_Names;
    }

}
