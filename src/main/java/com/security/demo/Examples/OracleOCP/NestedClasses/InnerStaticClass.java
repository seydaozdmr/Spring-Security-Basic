package com.security.demo.Examples.OracleOCP.NestedClasses;

public class InnerStaticClass {

    //InnerStaticClass sinif=new InnerStaticClass();

    public static void createInstance(String description){
        new StaticContext(description);
    }

    public static int compareText(String a,String b){
        return a.compareTo(b);
    }

    public static class StaticContext{
        private String description;
        public StaticContext(String description){
            this.description=description;
        }

        public String getDescription() {
            return description;
        }
    }
}


