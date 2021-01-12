package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

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
        //locations-object.dat dosyasını ObjectInputStream ile açıyoruz ve içindeki nesneleri okuyup static locationMap Map nesnesine yazıyoruz.
        try(ObjectInputStream inputStream=new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations-object.dat")))){
            boolean eof=false;
            while(!eof){
                try{
                    Location location=(Location) inputStream.readObject();
                    //System.out.println("Read location : "+ location.getLocationID()+","+location.getDescription());
                    for(String exits:location.getExits().keySet()){
                        //System.out.println("Exits: "+exits+","+location.getExits().get(exits));
                    }
                    locationsMap.put(location.getLocationID(),location);
                }catch (EOFException e){
                    System.out.println("Eof excepiton "+e.getMessage());
                    eof=true;
                }
            }
        }catch (IOException e){
            System.out.println("dosya okunamadı.. "+e.getMessage());
        }catch (ClassNotFoundException e){
            System.out.println("sınıf bulunamadı.. "+e.getMessage());
        }

        //locationMap dosyasındaki nesneleri ve bilgileri locations_rand.dat dosyasına RandomAccessFile kullanarak yazıyoruz.
        try(RandomAccessFile raf=new RandomAccessFile("locations_rand.dat","rwd")){
            //ilk başta randomaccessfile 0 noktasında bulunuyor.
            System.out.println("ilk başta : "+raf.getFilePointer());
            raf.writeInt(locationsMap.size());
            //locationMap.size yazdıktan sonra 4 bytelık alan yazmıyş oluyor.
            System.out.println("locationMap.size() yazıldıktan sonra : "+raf.getFilePointer());
            System.out.println(locationsMap.size());
            int indexSize=locationsMap.size()*3* Integer.BYTES;
            System.out.println(indexSize);
            int locationStart=(int) (indexSize+ raf.getFilePointer()+ Integer.BYTES);
            System.out.println("locationStart: "+locationStart);
            raf.writeInt(locationStart);
            long indexStart=raf.getFilePointer();
            System.out.println("indexStart: "+indexStart);
            int startPointer=locationStart;
            raf.seek(startPointer);
            System.out.println("şuan bulunduğumuz nokta: "+raf.getFilePointer());
            for(Location location:locationsMap.values()){
                //1688 byte ileri gittikten sonra bu noktada dosyaya yazmaya başlıyoruz:
                raf.writeInt(location.getLocationID());
                raf.writeUTF(location.getDescription());
                StringBuilder stringBuilder=new StringBuilder();
                for(String direction:location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){
                        //çıkışları dosyaya yazdırıyoruz ...
                        stringBuilder.append(direction);
                        stringBuilder.append(",");
                        stringBuilder.append(location.getExits().get(direction));
                        stringBuilder.append(",");
                        //System.out.println(direction+","+location.getExits().get(direction));
                    }
                }
                raf.writeUTF(stringBuilder.toString());
                //Bulunduğumuz noktayı ve bilginin uzunluğunu IndexRecord'da tutuyoruz.
                IndexRecord record=new IndexRecord(startPointer,(int) (raf.getFilePointer()-startPointer));
                //yukarıdaki index map'ine bu bilgileri yazıyoruz. yani hangi location hangi noktadan başlıyor ve hangi uzunlukta.
                index.put(location.getLocationID(),record);
                //en son startPointer'i kaldığımız yerede bırakıyoruz.
                //System.out.println("ilk location'u yazdıktan sonra bulunduğum nokta: "+raf.getFilePointer());
                startPointer=(int)raf.getFilePointer();
            }
            //satırı yazdıktan sonra satır bilgilerini yani nerede başlayıp nerede bittiğini ve uzunluk bilgilerini satırın başına
            //IndexRecord'u kullanarak yazıyoruz.::
            System.out.println("indexStart: "+indexStart);
            raf.seek(indexStart);
            System.out.println("son nokta: "+raf.getFilePointer());
            for(Integer locationID:index.keySet()){
                raf.writeInt(locationID);
                raf.writeInt(index.get(locationID).getStartByte());
                raf.writeInt(index.get(locationID).getLenght());
            }
            System.out.println("bütün işlemler bittikten sonra bulnan nokta: "+raf.getFilePointer());
        }catch(IOException e){
            e.printStackTrace();
        }


        try {
            //dosyayı açıyorum ve getLocation'ile istediğim bir location'in değerlerini yazdırabiliyorum.
            ra=new RandomAccessFile("locations_rand.dat","rwd");
            System.out.println(index.size());
            for(int i=1;i<=index.size();i++){
                getLocation(i);
            }
//            getLocation(20);

        } catch (IOException e) {
            e.printStackTrace();
        }


//        try {
//            Location currentLocation=getLocation(12);
//            System.out.println(currentLocation.getLocationID()+","+currentLocation.getDescription());
//            for(String i:currentLocation.getExits().keySet()){
//                System.out.println(i+","+currentLocation.getExits().get(i));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    static{
//        try{
//            ra=new RandomAccessFile("locations_rand.dat","rwd");
//            int numLocations=ra.readInt();
//            System.out.println("kaç tane eleman olduğu: "+numLocations);
//            long locationStartPoint=ra.readInt();
//            System.out.println("okumaya başlanması gereken değer: "+locationStartPoint);
//            System.out.println("şu an okunan sıra: "+ra.getFilePointer());
//            while(ra.getFilePointer()<locationStartPoint){
//                int locationId=ra.readInt();
//                System.out.println("id'yi okuduktan sonra bulunduğu nokta : "+ra.getFilePointer());
//                int locationStart=ra.readInt();
//                System.out.println("location'un başladığı yeri okuduktan sonra sonra nokta : "+ra.getFilePointer());
//                int locationLenght=ra.readInt();
//                System.out.println("location'un uzunluğunu okuduktan sonra: "+ra.getFilePointer());
//
//                IndexRecord record=new IndexRecord(locationStart,locationLenght);
//                System.out.println(locationStart+","+locationLenght);
//                index.put(locationId,record);
//
//            }
//
//        }catch (IOException e){
//            System.out.println("IOException in static initializer");
//        }


      //ObjectInputStream example: locations-object.dat dosyasını okuyan ve locationsMap Map'ine bilgileri getiren try bloğu
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
        //IndexRecord nesnesi olarak kaydettiğimiz konumu Locations id vererek buluyoruz.
        IndexRecord record=index.get(locationID);
        //Bu noktanın nereden başladığını buluyoruz. ve o noktaya gidiyoruz.
        ra.seek(record.getStartByte());
        //Burada ilk okuduğumuz location'un id'si
        int id=ra.readInt();
        String descrip=ra.readUTF();
        String exits=ra.readUTF();
        String [] exitsPart=exits.split(",");
        System.out.println("location id:"+id+" , "+"description: "+descrip);
        Location location=new Location(locationID,descrip,null);
        //System.out.println(exitsPart.length);

        if(locationID!=0 && exitsPart.length>1){

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
