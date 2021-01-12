package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
@Component
public class JavaNIOExample implements Map<Integer,Location> , ApplicationListener<ContextRefreshedEvent> {
    private static Map<Integer,Location> locations =new LinkedHashMap<>();


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Path locPath= FileSystems.getDefault().getPath("locations_big2.txt");
        Path dirPath=FileSystems.getDefault().getPath("directions_big2.txt");

        try(BufferedWriter locFile= Files.newBufferedWriter(locPath); BufferedWriter dirFile=Files.newBufferedWriter(dirPath)){
            for(Location location:locations.values()){
                locFile.write(location.getLocationID()+","+location.getDescription()+"\n");
                for(String direction:location.getExits().keySet()){
                    dirFile.write(location.getLocationID()+","+direction+","+location.getExits().get(direction)+"\n");
                }
            }
        }catch(IOException e){
            System.out.println("dosyaya yazılamıyor. "+e.getMessage());
        }

    }

    static {
        Path locPath= FileSystems.getDefault().getPath("locations_big.txt");
        Path dirPath=FileSystems.getDefault().getPath("directions_big.txt");
        try(Scanner scanner=new Scanner(Files.newBufferedReader(locPath))){
            scanner.useDelimiter(",");
            while(scanner.hasNextLine()){
                int loc=scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String description=scanner.nextLine();
                locations.put(loc,new Location(loc,description,null));
            }
        }catch (IOException e){
            System.out.println("dosya okunamıyor "+e.getMessage());
        }
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
