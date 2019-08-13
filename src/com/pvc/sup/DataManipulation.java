package com.pvc.sup;

import java.util.*;
import java.util.stream.Collectors;

public class DataManipulation {

    public static void main(String[] args) {
      //  List<String> st = {""}
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        List<Map<String,Object>> data = new ArrayList<>();
        List<String> issBinLits = Arrays.asList("100", "101", "102");


    Map<String,String> e = new HashMap<>();
    e.put("frd_us_tran_amt","10.2");
    e.put("issr_bin","100");
        Map<String,String> e1 = new HashMap<>();
        e1.put("frd_us_tran_amt","9.2");
        e1.put("issr_bin","100");
        Map<String,String> e2 = new HashMap<>();
        e2.put("frd_us_tran_amt","10.2");
        e2.put("issr_bin","101");

        map.put("1",new HashMap<>(e));
        map1.put("2",new HashMap<>(e1));
        map2.put("3",new HashMap<>(e2));
        data.add(map);
        data.add(map1);
        data.add(map2);

        //Converting All Data to List
        List<Map<String,String>> dataListMap = new ArrayList<>();
        for(int i=1;i<=data.size();i++){
            dataListMap.add((Map<String, String>) data.get(i-1).get(i+""));
        }

        // Forming issrAndAvgMap
        Map<String, Double> issrAndAvgMap = dataListMap.stream().collect(
                Collectors.groupingBy(customMap->{
                    return customMap.get("issr_bin");
                        },
                        Collectors.averagingDouble(customMap->{
                            return Double.valueOf(customMap.get("frd_us_tran_amt"));
                        })));

        for(int i=1;i<=data.size();i++){
            Map<String,String> dataMap =  (Map<String, String>) data.get(i-1).get(i+"");
           dataMap.put("frd_us_tran_amt",issrAndAvgMap.get(dataMap.get("issr_bin"))+"");
        }



        System.out.println(data);
    }
}
