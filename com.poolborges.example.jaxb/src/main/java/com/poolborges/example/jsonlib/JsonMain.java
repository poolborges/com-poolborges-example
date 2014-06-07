/*
 * http://sourceforge.net/projects/json-lib/files/json-lib/.
 * JSON-lib is a java library for transforming beans, maps, collections, java arrays and XML to JSON and back again to beans and DynaBeans.
 * 
 * 
 */
package com.poolborges.example.jsonlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
//import net.sf.json.JSONObject;
 
public class JsonMain {
    public static void main(String[] args) {
         
        Map<String, Long> map = new HashMap<String, Long>();
        map.put("A", 10L);
        map.put("B", 20L);
        map.put("C", 30L);
         
       // JSONObject json = new JSONObject();
        //json.accumulateAll(map);
         
        //System.out.println(json.toString());
 
         
        List<String> list = new ArrayList<String>();
        list.add("Sunday");
        list.add("Monday");
        list.add("Tuesday");
         
        //json.accumulate("weekdays", list);
        //System.out.println(json.toString());
    }
}
