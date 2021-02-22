package com.security.demo.LambdaExamples;

import org.springframework.security.core.parameters.P;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Example_11 {
    public static void main(String[] args) {
        Person p1=new Person("Jack",LocalDate.of(1988,7,9), Person.Cinsiyet.ERKEK,"jack@gmail.com");
        Person p2=new Person("Jane",LocalDate.of(1988,12,22), Person.Cinsiyet.KADIN,"jane@gmail.com");
        Person p3=new Person("Dom",LocalDate.of(1989,9,14), Person.Cinsiyet.ERKEK,"dom@gmail.com");
        Person p4=new Person("Fergie",LocalDate.of(2000,10,02), Person.Cinsiyet.KADIN,"fergie@gmail.com");
        Person p5=new Person("Terry",LocalDate.of(2000,9,14), Person.Cinsiyet.ERKEK,"dom@gmail.com");

        List<Person> calisanListesi=new ArrayList<>();
        calisanListesi.add(p1);
        calisanListesi.add(p2);
        calisanListesi.add(p3);
        calisanListesi.add(p4);
        calisanListesi.add(p5);

        printPersonOlderThan(calisanListesi,30);
        System.out.println();
        printPersonsWithinAgeRange(calisanListesi,20,32);

        System.out.println("Interface checkPerson");
        printPersons(calisanListesi,new checkPersonEligibleForSelectiveService());

        //Approach 4: Specify Search Criteria Code in an Anonymous Class
        System.out.println("Anonymous Class CheckPerson");
        printPersons(calisanListesi, new CheckPerson() {
            @Override
            public boolean testPerson(Person p) {
                return p.getCinsiyet()==Person.Cinsiyet.KADIN && p.getAge()>28;
            }
        });

        //Approach 5: Specify Search Criteria Code with a Lambda Expression
        //functional interface:
        System.out.println("functional interface and lambda implementation");
        printPersons(calisanListesi,(Person p)->p.getCinsiyet()== Person.Cinsiyet.ERKEK
                     && p.getAge()>25);

        //Approach 6: Use Standard Functional Interfaces with Lambda Expressions
        System.out.println("Predicate<T> is an example of a generic interface.");
        printPersonsWithPredicate(calisanListesi,(Person p)->p.getAge()>20);

        //Approach 7 The lambda expression used to print members is highlighted:
        System.out.println("approach 7:***");
        //processPerson metodunu uygularken abstract olarak verilen parametreleri ve uygulamaları somut olarak
        //burada uyguluyoruz.
        processPersons(calisanListesi,p-> p.getCinsiyet()==Person.Cinsiyet.KADIN && p.getAge()<30,p->p.printPerson());


        //Approach 7-1 abstract function implementation

        System.out.println("abstract function implementation");
        //kullanıcıları belirli bir kritere uyan personelin email adreslerini ekrana yazdıran program.
        processPersonsWithFunction(calisanListesi,person -> person.getCinsiyet()== Person.Cinsiyet.ERKEK &&
                                   person.getAge()<35, person -> person.getEmailAdress(),
                                   email -> System.out.println(email));
        //Bu fonksiyonda email adresini emailList listesine ekliyoruz.
        List<String> emailList=new ArrayList<>();
        processPersonsWithFunction(calisanListesi,person -> person.getCinsiyet()== Person.Cinsiyet.ERKEK &&
                        person.getAge()<35, person -> person.getEmailAdress(),
                email -> emailList.add(email));

        emailList.stream().forEach(p-> System.out.println("adress: "+p));

        //Approach - 8
        System.out.println("30 yaşından büyük kadın personel");
        //Note : Note: You can omit the data type of the parameters in a lambda expression.
        // In addition, you can omit the parentheses if there is only one parameter.
        // For example, the following lambda expression is also valid:
        System.out.println("Email adres: ");
        processElements(calisanListesi,(Person p)->p.getCinsiyet()== Person.Cinsiyet.KADIN,(Person p)->p.getEmailAdress(),email -> System.out.println(email));
        System.out.println("İsimler");
        processElements(calisanListesi,p-> p.getCinsiyet()== Person.Cinsiyet.KADIN && p.getAge()>30, p-> p.getName(),isim -> System.out.println(isim));


        //Approach 9: Use Aggregate Operations That Accept Lambda Expressions as Parameters
        //Yukarıda gerçekleştirdiğimiz bütün örnekleri method kullanmadan lambda kullanarak gerçekleştiriyoruz.
        System.out.println("LAMBDA EXPRESSIN : ****");
        calisanListesi.stream() //sourceFile -> List<Person> personList
                .filter(p-> p.getCinsiyet()== Person.Cinsiyet.ERKEK && p.getAge()>25) //Predicate
                .map(p->p.getEmailAdress()) //Function mapping
                .forEach(email -> System.out.println(email)); //Consumer

        //NOT NOT NOT
        //Aggregate operations process elements from a stream, not directly from a collection
        // (which is the reason why the first method invoked in this example is stream).
        // A pipeline is a sequence of stream operations, which in this example is filter- map-forEach.
        //In addition, aggregate operations typically accept lambda expressions as parameters, enabling you to customize how they behave.


        //NOT
        /*
        * A return statement is not an expression; in a lambda expression,
        * you must enclose statements in braces ({}). However,
        * you do not have to enclose a void method invocation in braces.
        * For example, the following is a valid lambda expression:
         */
    }

    //Approach 1: Create Methods That Search for Members That Match One Characteristic
    public static void printPersonOlderThan(List<Person> roster,int age){
        for(Person p:roster){
            if(p.getAge()>=age)
                p.printPerson();
        }
    }

    //Approach 2: Create More Generalized Search Methods
    public static void printPersonsWithinAgeRange (List<Person> roster,int minAge,int maxAge){
        for(Person p : roster){
            if(p.getAge()>=minAge && p.getAge()<maxAge){
                p.printPerson();
            }
        }
    }

    //Approach 3: Specify Search Criteria Code in a Local Class
    //We use interface for search criteria
    //we give method concrete CheckPerson interface instance
    public static void printPersons(List<Person> roster,CheckPerson checkPerson){
        for(Person p:roster){
            if (checkPerson.testPerson(p)){
                p.printPerson();
            }
        }
    }

    //Approach 6: implementation of Predicate interface
    public static void printPersonsWithPredicate(List<Person> personList,Predicate<Person> personPredicate){
        for(Person p:personList){
            if(personPredicate.test(p)){
                p.printPerson();
            }
        }
    }

    //Approach 7: Use Lambda Expressions Throughout Your Application
    public static void processPersons(List<Person> personList, Predicate<Person> personPredicate, Consumer<Person> personConsumer){
        for(Person p:personList){
            if(personPredicate.test(p)){
                personConsumer.accept(p);
            }
        }
    }

    //Approach 7 : In this case, you need a functional interface that contains an abstract method that returns a value.
    public static void processPersonsWithFunction(List<Person> personList, Predicate<Person> tester, Function<Person,String> mapper,Consumer<String> block){
        for(Person p:personList){
            if(tester.test(p)){
                //eğer test şartına uyan elemanlar varsa onlara ait property'ini mapper ile uyguluyoruz.
                String data=mapper.apply(p);
                //block.accept ile bulunan data String'ini lambda ile istediğimiz işlemi gerçekleştirebiliyoruz.
                block.accept(data);
            }
        }
    }

    //Approach 8: Use Generics More Extensively
    //X cinsinden
    public static <X,Y> void processElements(List<X> elemanList,Predicate<X> tester,Function<X,Y> mapper,Consumer<Y> block){
        for(X x:elemanList){
            if(tester.test(x)){
                Y data=mapper.apply(x);
                //burası yapılması istenen işlemi uyguluyor bu ekrana yazdırma olabilir ya da başka bir listeye
                //ekleme gibi bunu methodu implemente ederken lambda ile belirliyoruz.
                block.accept(data);
            }
        }
    }
}

class Person{
    public enum Cinsiyet{
        ERKEK,KADIN
    }

    private String name;
    private LocalDate birthday;
    private Cinsiyet cinsiyet;
    private String emailAdress;

    public Person(String name, LocalDate birthday, Cinsiyet cinsiyet, String emailAdress) {
        this.name = name;
        this.birthday = birthday;
        this.cinsiyet = cinsiyet;
        this.emailAdress = emailAdress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Cinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Cinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public int getAge(){
        return LocalDate.now().getYear()-this.birthday.getYear();
    }

    public void printPerson(){
        System.out.println("Name: "+name+" Age: "+getAge()+" Cinsiyeti: "+cinsiyet.toString()+" Email: "+emailAdress);
    }

    public static int compareByAge(Person a,Person b){
        return a.getBirthday().compareTo(b.getBirthday());
    }

    public static int compareByName(Person a,Person b){
        return a.getName().compareTo(b.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}



interface CheckPerson{
    boolean testPerson(Person p);
}

//CheckPerson interface implementation :
class checkPersonEligibleForSelectiveService implements CheckPerson{

    @Override
    public boolean testPerson(Person p) {
        return p.getCinsiyet()== Person.Cinsiyet.ERKEK && p.getAge()>=18 && p.getAge()<=25;
    }
}


//Approach 6: Use Standard Functional Interfaces with Lambda Expressions
//The interface Predicate<T> is an example of a generic interface.
interface Predicate<T> {
    boolean test(T t);
}