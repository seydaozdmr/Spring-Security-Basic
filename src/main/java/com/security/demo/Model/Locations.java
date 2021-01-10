package com.security.demo.Model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer,Location> locations=new HashMap<Integer,Location>();
    //bootstrapping data
    static{

        Map<String,Integer> tempExit=new HashMap<>();
        locations.put(0,new Location(0,"Bilgisarın önünde java öğreniyorsun",null));

        tempExit=new HashMap<String,Integer>();
        tempExit.put("W",2);
        tempExit.put("E",3);
        tempExit.put("S",4);
        tempExit.put("N",5);
        //Yeni bir yer ve bu yerin gidebileceği yönleri Map olarak atıyorum.
        locations.put(1,new Location(1,"Yolun başındasın",tempExit));

        tempExit=new HashMap<String,Integer>();
        //Buradan yalnızca kuzeye gidebilirsin
        tempExit.put("N",5);
        locations.put(2,new Location(2,"Artık tepedesin",tempExit));


        tempExit=new HashMap<String,Integer>();
        tempExit.put("W",1);
        locations.put(3,new Location(3,"Bir bina içerisindesin",tempExit));

        tempExit=new HashMap<String,Integer>();
        tempExit.put("N",1);
        tempExit.put("W",2);
        locations.put(4,new Location(4,"Bir nehrin yanındaki ovadasın",tempExit));

        tempExit=new HashMap<String,Integer>();
        tempExit.put("S",1);
        tempExit.put("W",2);
        locations.put(5,new Location(5,"Ormandasın",tempExit));

    }


    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
