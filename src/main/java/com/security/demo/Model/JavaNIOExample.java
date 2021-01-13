package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
@Component
public class JavaNIOExample implements Map<Integer,Location> , ApplicationListener<ContextRefreshedEvent> {
    private static Map<Integer,Location> locations =new LinkedHashMap<>();


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
//        Path locPath= FileSystems.getDefault().getPath("locations_big2.txt");
//        Path dirPath=FileSystems.getDefault().getPath("directions_big2.txt");
//
//        try(BufferedWriter locFile= Files.newBufferedWriter(locPath); BufferedWriter dirFile=Files.newBufferedWriter(dirPath)){
//            for(Location location:locations.values()){
//                locFile.write(location.getLocationID()+","+location.getDescription()+"\n");
//                for(String direction:location.getExits().keySet()){
//                    dirFile.write(location.getLocationID()+","+direction+","+location.getExits().get(direction)+"\n");
//                }
//            }
//        }catch(IOException e){
//            System.out.println("dosyaya yazılamıyor. "+e.getMessage());
//        }
//        for(Location location:locations.values()){
//            System.out.println("location: "+location.getLocationID()+","+location.getDescription());
//            for(String destination:location.getExits().keySet()){
//                if(!destination.equalsIgnoreCase("Q")){
//                    System.out.println(destination+","+location.getExits().get(destination));
//                }
//
//            }
//        }

        //Object olarak dosyaya yazmak için...
//        Path locPath=FileSystems.getDefault().getPath("locations-nio.dat");
//        try(ObjectOutputStream locFile=new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))){
//            for(Location location:locations.values()){
//                locFile.writeObject(location);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }

    }
    //dosya bilgilerini okumak için Path kullanıyoruz...
    static {
        //Object olarak kaydedilmiş locations-object.dat dosyasını java nio kütüphanesi aracılığı ile okumak için:
        Path locPath=FileSystems.getDefault().getPath("locations-object.dat");
        try(ObjectInputStream locFile=new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))){
            boolean eof=false;

            while(!eof){
                try{
                    Location location=(Location) locFile.readObject();
                    locations.put(location.getLocationID(),location);
                }catch (EOFException e){
                    eof=true;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            System.out.println("sınıf bulunamadı : "+e.getMessage());
        }





        //locations_big.txt ve directions_big.txt dosyalarını java.nio kütüphanesi ile okumak için:
//        Path locPath= FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath=FileSystems.getDefault().getPath("directions_big.txt");
//        try(Scanner scanner=new Scanner(Files.newBufferedReader(locPath))){
//            scanner.useDelimiter(",");
//            while(scanner.hasNextLine()){
//                int loc=scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description=scanner.nextLine();
//                locations.put(loc,new Location(loc,description,null));
//            }
//        }catch (IOException e){
//            System.out.println("dosya okunamıyor "+e.getMessage());
//        }
//
//        try(BufferedReader dirFile=Files.newBufferedReader(dirPath)){
//            String input;
//            while((input=dirFile.readLine())!=null){
//                String [] data=input.split(",");
//                int loc=Integer.parseInt(data[0]);
//                String direction=data[1];
//                int destination=Integer.parseInt(data[2]);
//                //System.out.println(loc+": "+direction+": "+destination);
//                Location location=locations.get(loc);
//                if(!direction.equalsIgnoreCase("Q")){
//                    location.addExit(direction,destination);
//                }
//
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
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
