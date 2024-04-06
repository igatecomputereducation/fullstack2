package com.igate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
public class Demo {
	public static void main(String[] args) {
		Logger log = LogManager.getLogger();
		
		log.info("*******Beginning of Demo execution ************");
		log.info("Creating scanner object");
		Scanner sc=new Scanner(System.in);
		
		try {
				log.info("Accepted numerator");
				System.out.println("Num:");
				int num=sc.nextInt();
				
				log.info("Accepted denominator");
				System.out.println("den:");
				int den=sc.nextInt();
				
				log.info("Calculating and printing division");
				System.out.println("Division:"+num/den);
				
				log.info("Operation success");
		
		}catch(Exception e) {
				System.out.println("Can't divide by zero");
			    log.error("problem "+e.getMessage());
		}
		
		log.info("*******end of Demo execution ************");
		
		
		
		
		
	}

}
