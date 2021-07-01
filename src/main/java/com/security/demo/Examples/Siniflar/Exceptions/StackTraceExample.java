package com.security.demo.Examples.Siniflar.Exceptions;



public class StackTraceExample {

    //public static void main(String[] args) throws Throwable {
    public static void main(String[] args) {
        StackTraceExample example=new StackTraceExample();
        example.doThis();
    }

    public void doThis(){
        //bir alttaki metot throw ettiği için doThat() bu istisnayı yakalamak zorunda ya da throws
        //ile bir üstteki kullanıma bırakmak zorunda...
        //eğer hiç bir yerde (exception) handle edilmezse en sonunda jvm çalışmasını durdurur..
        try{
            doThat();
        }catch (Throwable t){
            System.out.println(t.getMessage());
        }
        //doThat();

    }

    public void doThat() throws Throwable{
        Throwable throwable=new Throwable("Just Kidding :)");
        throw throwable;
//        System.out.println();
//        printStackTraceForThrowable(throwable);
    }

    public void printStackTraceForThrowable(Throwable throwable){
        System.out.println("****Stack Trace ******");

        StackTraceElement [] traceElements=throwable.getStackTrace();
        for(StackTraceElement i:traceElements){
            System.out.println("New Stack info : ");
            System.out.println("File name : "+i.getFileName());
            System.out.println("Class name : "+i.getClassName());
            System.out.println("Method name : "+i.getMethodName());
            System.out.println("Line number : "+i.getLineNumber());
        }
        System.out.println();
    }

}
