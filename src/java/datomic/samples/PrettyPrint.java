package datomic.samples;

import clojure.java.api.Clojure;
import clojure.lang.IFn;
import java.text.NumberFormat;
import java.text.DecimalFormat;

public class PrettyPrint {
    public static final IFn prettyPrint = Clojure.var("clojure.pprint", "pprint");
    public static void print(Object o) {

    	if(o instanceof java.lang.Double) {
    		System.out.printf("%f\n", o);	
    	} else {
    		System.out.println(o);	
    	}
    }
}
