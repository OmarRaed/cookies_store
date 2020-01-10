package view.backing;

import java.util.ArrayList;

import javax.annotation.Generated;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.team1.doses.dto.InjectionDto;

import java.util.LinkedHashMap;
import java.util.Map;

@ManagedBean(name = "backing_Ingection")
@RequestScoped
@Generated(value = "1Ingection.jsf", comments = "oracle-jdev-comment:managed-bean-jsp-link")
public class Ingection {
    private String selectedInjection;
    private static ArrayList<InjectionDto> injectionList = new ArrayList<InjectionDto>();

    private Integer weight;
    private String result;
    public static Map<String, String> injection_Names;
    static {
        InjectionDto ampicillin_sulbactam_150_Mg = new InjectionDto(150, 2, "Injection ampicillin_sulbactam_150_Mg");
        InjectionDto ceftriaxone_50_Mg = new InjectionDto(50, 2, "ceftriaxone_50_Mg");
        InjectionDto cefotaxime_100_Mg = new InjectionDto(100, 2, "cefotaxime_100_Mg");

        injectionList.add(ampicillin_sulbactam_150_Mg);
        injectionList.add(ceftriaxone_50_Mg);
        injectionList.add(cefotaxime_100_Mg);

        injection_Names = new LinkedHashMap<String, String>();
        for (int i = 0; i < injectionList.size(); i++) {
            injection_Names.put(injectionList.get(i).getName(), injectionList.get(i).getName());
        }
    }

    public Map<String, String> getInjection_NamesInMap() {
        return injection_Names;
    }


    public void setSelectedInjection(String selectedInjection) {
        this.selectedInjection = selectedInjection;
    }

    public String getSelectedInjection() {
        return selectedInjection;
    }

    public void setInjectionList(ArrayList<InjectionDto> injectionList) {
        this.injectionList = injectionList;
    }

    public ArrayList<InjectionDto> getInjectionList() {
        return injectionList;
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
        int doseResult;

        //String injectionSelected = getSelectedInjection();

        for (int i = 0; i < injectionList.size(); i++) {
            if (selectedInjection.equals(injectionList.get(i).getName())) {
                dosePerKg = injectionList.get(i).getDosePerKg();
                doseNumber = injectionList.get(i).getDoseNumber();

            }

        }

        //50
        //Get result from equation
        doseResult = Integer.valueOf(weight * dosePerKg / doseNumber);

        //set result to textView
        result = new String(" " + doseResult);

    }


    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public static void setInjection_Names(Map<String, String> injection_Names) {
        Ingection.injection_Names = injection_Names;
    }

    public static Map<String, String> getInjection_Names() {
        return injection_Names;
    }
}
