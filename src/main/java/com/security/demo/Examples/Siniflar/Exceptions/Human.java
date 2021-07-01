package com.security.demo.Examples.Siniflar.Exceptions;

public class Human {
    //Bu durumda en özel exception Sneeze Annoyance'ı extends etmiştir, Annoyance ise Exception
    //sınıfını extends etmiştir handle ederken:
    public static void main(String[] args) {
        try{
            Sneeze sneeze=new Sneeze();
            throw sneeze;
        }catch (Sneeze e){

        } catch (Annoyance a){

        }
    }
}
class Annoyance extends Exception{

}

class Sneeze extends Annoyance{

}
