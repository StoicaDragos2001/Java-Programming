package Instances;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class City {
    private Map<Intersection, List<String>> cityMap;

    public City() {
        cityMap = new HashMap<>();
    }

    public void setStreetForIntersection(Intersection intersection,List<String>streetList) {
        cityMap.put(intersection,streetList);
    }
    public void displayCity(){
        System.out.println(cityMap);
    }
    public Map<Intersection, List<String>> returnMap(){
        return cityMap;
    }

}
