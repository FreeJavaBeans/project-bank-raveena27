package com.revature.log;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class Logging {

	public static final Logger log = Logger.getLogger("com.revature.BankApplication");

	public static void loggerInfo(String info) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("/Users/mothu/bankapplog.txt"));
			out.write(info);
			out.close();
			//System.out.println("File created successfully");
		} catch (IOException e) {
		}

	}
	public static void loggerWarn(String info) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("/Users/mothu/bankapplog.txt"));
			out.write(info);
			out.close();
			//System.out.println("File created successfully");
		} catch (IOException e) {
		}

	}
	public static void loggerError(String info) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("/Users/mothu/bankapplog.txt"));
			out.write(info);
			out.close();
			//System.out.println("File created successfully");
		} catch (IOException e) {
		}

	}

}
