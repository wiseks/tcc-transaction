package org.tcc.transaction.dubbo.capital.main;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class TccCapitalStart 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/local/appcontext-*.xml","tcc-transaction.xml","tcc-transaction-dubbo.xml");
//        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("config/spring/local/appcontext-service-dao.xml","config/spring/local/appcontext-service-datasource.xml");
        
        ctx.refresh();
		ctx.start();
		Scanner scan = new Scanner(System.in);
		System.out.println("service started");
		Boolean wait = true;
		while (wait) {
			String result = scan.nextLine();
			while (!result.equals("stop")) {
				System.out.println("service continue");
				result = scan.nextLine();
			}
			System.out.println("are you sure stop services?");
			result = scan.nextLine();
			if (!result.equals("y")) {
				System.out.println("service continue");
				continue;
			}
			wait = false;
		}
		System.out.println("service end");
		ctx.close();
		scan.close();
    }
}
