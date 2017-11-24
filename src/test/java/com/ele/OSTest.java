package com.ele;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

/**
 * Created by zhangletian on 2017/11/15.
 */
public class OSTest extends OsWithComm {

    private static Logger Log = Logger.getLogger(OSTest.class.getName());

    @Test public void osInt(){
        int height = driver.manage().window().getSize().getHeight();
        int widht = driver.manage().window().getSize().getWidth();
        Log.info(height+","+widht);


        try{
            Thread.sleep(50000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
