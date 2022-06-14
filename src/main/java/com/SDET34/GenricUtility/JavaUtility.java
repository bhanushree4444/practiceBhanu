
package com.SDET34.GenricUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;
/**
 * This class is used to store the all java utility
 * @author CHANDAN KUMARa
 *
 */

public class JavaUtility {
	/**
	 * This method use to convert string to long datatype
	 * @param value
	 * @return
	 */

	public long stringToLong(String value) {
		return Long.parseLong(value);

	}
	/**
	 * This method use to get the random Number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		Random ran = new Random();
		return ran.nextInt(limit);
	}
	/**
	 * this method use to print the data
	 * @param statement
	 */
	public void prinStatement(String statement) {
		System.out.println(statement);
	}

	/**
	 * if else condition
	 * @param actualResult
	 * @param expectedResult
	 * @param testCaseName
	 */
	public void  assertionThroughIfCondition(String actualResult,String expectedResult,String testCaseName ) {

		if(actualResult.contains(expectedResult)) {
			System.out.println(testCaseName+"Created succesfully");
			System.out.println("TC pass");
		}
	}
	/**
	 * this method use to customWait
	 * @param element
	 * @param duratin
	 * @param polingTime
	 * @throws InterruptedException
	 */
	public void customWait(WebElement element,int duratin,long polingTime) throws InterruptedException {
		int count = 0;
		while(count<=duratin) {

			try {
				element.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(polingTime);
				count++;
			}
		}

	}
	/**
	 * This method use to get Date
	 * @return
	 */
	public  String getDateFormat(){
		
		return (new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()));
		
	
		
	}




}
