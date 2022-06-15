package com.SDET34.GenricUtility;
/**
 * This interface consists the path of the external files
 * @author CHANDAN KUMARa
 *
 */
public interface IconstantPath {
	String PROPERTYFILEPATH="./src/test/resources/commonData.properties";
    String EXCELPATH="./src/test/resources/TestData.xlsx";
    String MSQLPATH="jdbc:mysql://localhost:3306/";
    String CHROMEKEY="webdriver.chrome.driver";
    String CHROMEVALUE="./src/main/resources/chromedriver.exe";
    String GECKOKEY="webdriver.chrome.driver";
    String GECKOVALUE="./src/main/resources/geckodriver.exe";
}
