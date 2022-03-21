package Instances;
/**
 * class City
 * @author Petrea Daniela
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    private Map<Intersection, List<String>> cityMap;

    public City() {
        cityMap = new HashMap<>();
    }

    /**
     *
     * @param intersection whose type is Intersection
     * @param streetList which represent the list with the streets whose intersection is the first parameter
     */
    public void setStreetForIntersection(Intersection intersection,List<String>streetList) {
        cityMap.put(intersection,streetList);
    }

    /**
     * display the map of the city
     */
    public void displayCity(){
        System.out.println(cityMap);
    }
    public Map<Intersection, List<String>> returnMap(){
        return cityMap;
    }

}
