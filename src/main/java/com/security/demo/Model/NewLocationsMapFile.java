package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class NewLocationsMapFile implements Map<Integer,Location> , ApplicationListener<ContextRefreshedEvent> {
    public static Map<Integer,Location> locationsMap=new HashMap<>();
    private static Map<Integer,IndexRecord> index=new HashMap<>();
    private static RandomAccessFile ra;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)  {
        try(RandomAccessFile raf=new RandomAccessFile("locations_rand.dat","rwd")){
            raf.writeInt(locationsMap.size());
            int indexSize= locationsMap.size()*3*Integer.BYTES;
            int locationStart=(int) (indexSize+raf.getFilePointer()+Integer.BYTES);
            raf.writeInt(locationStart);
            long indexStart=raf.getFilePointer();
            int startPointer=locationStart;
            raf.seek(startPointer);
            for(Location location:locationsMap.values()){
                raf.writeInt(location.getLocationID());
                raf.writeUTF(location.getDescription());
                StringBuilder stringBuilder=new StringBuilder();
                for(String direction:location.getExits().keySet()){
                    stringBuilder.append(direction);
                    stringBuilder.append(",");
                    stringBuilder.append(location.getExits().get(direction));
                    stringBuilder.append(",");
                }
                raf.writeUTF(stringBuilder.toString());
                IndexRecord record=new IndexRecord(startPointer,(int)(raf.getFilePointer()-startPointer));
                index.put(location.getLocationID(),record);
                startPointer=(int) raf.getFilePointer();
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            getLocation(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static{
        try{
            ra=new RandomAccessFile("locations_rand.dat","rwd");
            int numLocations=ra.readInt();
            long locationStartPoint=ra.readInt();

            while(ra.getFilePointer()<locationStartPoint){
                int locationId=ra.readInt();
                int locationStart=ra.readInt();
                int locationLenght=ra.readInt();
                IndexRecord record=new IndexRecord(locationStart,locationLenght);
                index.put(locationId,record);
            }

        }catch (IOException e){
            System.out.println("IOException in static initializer");
        }



//        try(ObjectInputStream locFile=new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations-object.dat")))){
//            boolean eof=false;
//            while(!eof){
//                try{
//                    Location location=(Location) locFile.readObject();
//                    System.out.println("Read location : "+ location.getLocationID()+","+location.getDescription());
//                    for(String exits:location.getExits().keySet()){
//                        System.out.println("Exits: "+exits+","+location.getExits().get(exits));
//                    }
//                    locationsMap.put(location.getLocationID(),location);
//                }catch (EOFException e){
//                    System.out.println("dosya okunamadı :"+e.getMessage() );
//                    eof=true;
//                }
//            }
//        }catch (InvalidClassException e){
//            System.out.println("geçeris sınıf : "+e.getMessage());
//        }catch(IOException e){
//            System.out.println("dosya yazılamadı : "+e.getMessage());
//        }catch (ClassNotFoundException e){
//            System.out.println("sınıf bulunamadı : "+e.getMessage());
//        }
    }
    //adım adım location'ı buluyor
    public Location getLocation(int locationID) throws IOException{
        IndexRecord record=index.get(locationID);
        ra.seek(record.getStartByte());
        int id=ra.readInt();
        String descrip=ra.readUTF();
        String exits=ra.readUTF();
        String [] exitsPart=exits.split(",");

        Location location=new Location(locationID,descrip,null);
        if(locationID!=0){
            for(int i=0;i<exitsPart.length;i++){
                System.out.println("exitPart= "+exitsPart[i]);
                System.out.println("exitPart[+1]= "+exitsPart[i+1]);
                String direction=exitsPart[i];
                int destination=Integer.parseInt(exitsPart[++i]);
                location.addExit(direction,destination);
            }
        }
        return location;
    }


    @Override
    public int size() {
        return locationsMap.size();
    }

    @Override
    public boolean isEmpty() {
        return locationsMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locationsMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locationsMap.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locationsMap.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locationsMap.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        return locationsMap.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        locationsMap.putAll(m);
    }

    @Override
    public void clear() {
        locationsMap.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locationsMap.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locationsMap.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locationsMap.entrySet();
    }



    public void close() throws IOException{
        ra.close();
    }


}
