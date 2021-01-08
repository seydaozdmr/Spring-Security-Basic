package com.security.demo.Model;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//Writing file example
@Component
public class LocationBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private Map<Integer,Location> locationMap=new HashMap<>();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            //dataOutputStreamExample();
            dataInputStream();
            //dosyaYaz();
            //yonleriYaz();
            //dosyaOku();
            //dosyaOkuBuffered();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void legacyWrite(){
        Locations locations=new Locations();
        FileWriter locFile=null;
        //try içinde FileWriter nesnesi oluşturursak bu nesne try içinde kalır scope olarak.
        //Bundan dolayı nesneyi try dan önce oluşturuyoruz.
        try{
            locFile=new FileWriter("locations.txt");
            for(Location location:locations.values()){
                locFile.write(location.getLocationID()+","+location.getDescription()+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            System.out.println("işlem kapatılıyor...");
            try{
                if(locFile!=null) {
                    locFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public void dosyaYaz() throws IOException{
        Locations locations=new Locations();
        FileWriter fileWriter=null;

        try{
            fileWriter=new FileWriter("newLocations.txt");
            for(Location location:locations.values()){
                fileWriter.write(location.getLocationID()+ ","+ location.getDescription()+ "\n" );

            }
        }finally {
            System.out.println("işlem kapatılıyor.");
            if(fileWriter!=null){
                fileWriter.close();
            }
        }
    }

    public void yonleriYaz() throws IOException{
        Locations locations=new Locations();
        try(FileWriter fileWriter=new FileWriter("locations-1.txt");
            FileWriter directions=new FileWriter("directions.txt")){
            for(Location location:locations.values()){
                fileWriter.write(location.getLocationID()+","+location.getDescription()+"\n");
                for(String direction:location.getExits().keySet()){
                    directions.write(location.getLocationID()+","+direction+","+location.getExits().get(direction)+"\n");
                }
            }
        }
    }

    public void dosyaOku() throws IOException{

        try (Scanner scanner=new Scanner(new FileReader("locations_big.txt"))) {
            System.out.println("dosya okunuyor....");
            scanner.useDelimiter(",");
            int sayac=0;
            while(scanner.hasNextLine()){
                int loc=scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String place=scanner.nextLine();
                locationMap.put(sayac,new Location(loc,place,null));
                sayac++;
            }
            System.out.println("okuma işlemi başarılı...");
        }
        /*
        finally {
            if(scanner!=null){
                scanner.close();
            }
        }

         */

        for(Location location:locationMap.values()){
            System.out.println(location.getLocationID()+" , "+location.getDescription()+" \n ");
        }
    }

    public void dosyaOkuBuffered() throws IOException{
        //try(içerisinde oluşturmak istediğimiz nesneleri yaratıyoruz.)
        try(Scanner scanner=new Scanner(new BufferedReader(new FileReader("directions_big.txt")))) {

            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                int loc = Integer.parseInt(data[0]);
                String direc = data[1];
                int destination = Integer.parseInt(data[2]);

                locationMap.get(loc).addExit(direc, destination);
            }
        }
        /*
        finally {
            if(scanner!=null){
                scanner.close();
            }
        }

         */

        for(Location location:locationMap.values()){
            System.out.println(location.getLocationID()+" , "+location.getDescription());
            for(String directins:location.getExits().keySet()){
                System.out.println(directins+" , "+location.getExits().get(directins));
            }
        }
    }

    public void bufferReadExample() {
        try(BufferedReader bufferedReader=new BufferedReader(new FileReader("locations.txt"))){
            String input;
            while((input=bufferedReader.readLine())!=null){
                String [] data=input.split(",");
                int loc=Integer.parseInt(data[0]);
                String direction=data[1];
                int destination=Integer.parseInt(data[2]);

                Location location=locationMap.get(loc);
                location.addExit(direction,destination);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void dataOutputStreamExample() throws IOException{
        Locations locations=new Locations();
        try(DataOutputStream locFile=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("locations-2.dat")))){
            for(Location location:locations.values()){
                locFile.writeInt(location.getLocationID());
                locFile.writeUTF(location.getDescription());
                System.out.println("we are writing.."+location.getLocationID()+" : "+location.getDescription());
                System.out.println("writing :"+(location.getExits().size()-1) + "exits..");
                locFile.writeInt(location.getExits().size()-1);
                for(String direction:location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){
                        locFile.writeUTF(direction);
                        locFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
    }

    public void dataInputStream() throws IOException{
        try(DataInputStream locFile=new DataInputStream(new BufferedInputStream(new FileInputStream("locations-2.dat")))){
            boolean eof=false;
            while (!eof){
                try{
                    Map<String,Integer> exits=new HashMap<>();
                    int locId=locFile.readInt();
                    String description=locFile.readUTF();
                    int numExits=locFile.readInt();
                    System.out.println("Read locations: "+locId+" : "+ description);
                    System.out.println("Found "+numExits+" exits.");
                    for(int i=0;i<numExits;i++){
                        String direction=locFile.readUTF();
                        int destination=locFile.readInt();
                        exits.put(direction,destination);
                        System.out.println("\t\t" +direction+","+destination);
                    }
                    locationMap.put(locId,new Location(locId,description,exits));
                }catch (EOFException e){
                    eof=true;
                }

            }

        }
    }

}
