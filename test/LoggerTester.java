
import logger.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prashant Prakash
 */
public class LoggerTester {
    
    public static void main(String args[]) throws InterruptedException{
        Logger error = Logger.getInstance(Logger.ERROR);
        Logger warning = Logger.getInstance(Logger.WARNING);
        Logger info = Logger.getInstance(Logger.INFO);
        //System.out.println(error.status + " " + warning.status + " " + info.status);
        int i = 10;
        while(i-->0){
            error.writeLog("Error Log Text:" + i);
            warning.writeLog("Warning Log Text:" + i);
            info.writeLog("Info Log Text:" + i);
            Thread.sleep(1000);
        }
    }
    
}
