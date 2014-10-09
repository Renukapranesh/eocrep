package ortho.eoc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriverException;
import org.testng.Reporter;
import org.testng.annotations.*;


public class NonarthScore {
	

	DataProviderAdd datap = new DataProviderAdd();
	
	private WebDriver driver = new FirefoxDriver();
    @BeforeTest
    public void setup() throws Exception,InterruptedException, BiffException, IOException,WebDriverException  {
    	System.out.println("Entered Login");
    	
    	driver.get("http://192.168.1.246/eoc_mahesh");
       	driver.manage().window().maximize();
    	Thread.sleep(2000);
  	  	    	 
  	  	driver.findElement(By.id("username")).clear();
  	  	driver.findElement(By.id("username")).sendKeys("admin");
  	  	driver.findElement(By.id("password")).clear();
  	  	driver.findElement(By.id("password")).sendKeys("a");
  	  	driver.findElement(By.id("btLogin")).click();
  	  	//Selecting Patients
  	  	driver.findElement(By.className("StudyText")).click();
  	  	Thread.sleep(2000);
    }
    @DataProvider(name = "data-provider", parallel = false)
 	public Object[][] data() throws Exception {
 		Object[][] retObjArr=datap.getTableArray("D:\\Renuka\\testeoc.xls",0);
        return(retObjArr);
         
 	}
    @Test(dataProvider="data-provider")
    public void search(String ptname,String trname,String revname,String date,String walking_flat,String updown_stairs,String night,String sit_lying,String stand_upright,String catch_lock,String hip_giving_put,String stiffness,String dec_motion,String des_stairs,String asc_stairs,String rising_sitting,String putonsocks,String rising_bed,String sprint_cut,String low_sports,String jogging,String walking,String heavy_duty,String low_duty)throws InterruptedException, BiffException, IOException {
    
  	  	//WebDriverWait wait = new WebDriverWait(driver,05);
  	  	//wait.until(ExpectedConditions.elementToBeClickable(By.className("cls_header_patient")));
  	  	driver.findElement(By.className("cls_header_patient")).click();
  	  	Thread.sleep(500);
  	  	driver.findElement(By.id("SearchBox")).click();
  	  	driver.findElement(By.id("SearchBox")).sendKeys("t");
  	  	driver.findElement(By.className("btnStudySearch")).click();
  	  	Thread.sleep(1000);
  	  WebElement ptlist = driver.findElement(By.className("flex_patient"));
	  	List<WebElement> tagname2 = ptlist.findElements(By.tagName("tr"));
	  	int j =1;    
		for(WebElement tlist1 : tagname2)
		{	    	 
  	 Thread.sleep(3000);
		 Actions action1 = new Actions(driver);
		 
  	 WebElement element1 = tlist1.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr["+j+"]/td[1]/div"));
  	 driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr["+j+"]/td[1]/div")).click();
  	 String pname=tlist1.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr["+j+"]/td[1]/div")).getText();
  	 System.out.println("Patient Name="+pname);
  	 		    	 
   if( pname.matches(ptname))
   {
  	Action doubleClick1 = action1.doubleClick(element1).build();
  	doubleClick1.perform();// After performing double click Map will load
  	Thread.sleep(3000);
  	driver.findElement(By.className("clsapp_pat_treatment")).click();
  	Thread.sleep(3000);
    	//driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div/div[7]/table/tbody/tr/td[3]/div")).click();
    	//Thread.sleep(3000);
    	//driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr/td[3]/div")).click();
  	 WebElement trlist= driver.findElement(By.className("flex_treatment"));
     List<WebElement> tagname1=trlist.findElements(By.tagName("tr"));
     int i=1;
     for(WebElement tlist2 : tagname1){
     	Thread.sleep(2000);
     	//Actions action1 = new Actions(driver);
     	WebElement element2 = tlist2.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div/div[7]/table/tbody/tr["+i+"]/td[3]/div"));
     	driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div/div[7]/table/tbody/tr["+i+"]/td[3]/div")).click();
     	String tname=tlist2.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div/div[7]/table/tbody/tr["+i+"]/td[3]/div")).getText();
     	System.out.println("Treatment name="+tname);
     	
     	if(tname.matches(trname))
     		              
     		{
     		Action doubleClick2 = action1.doubleClick(element2).build();
     		doubleClick2.perform();
     		Thread.sleep(2000);
     		
  	        	Thread.sleep(2000);
     	        	//search2(evdat,mob,self,usual,pain,anxd,healt,comm);
     	        	//Thread.sleep(3000);
     	        	//driver.findElement(By.className("StudyName")).click();
     	        	Thread.sleep(3000);
     	        	//Thread.sleep(2000);

     	           
     	       	 WebElement rvlist= driver.findElement(By.className("flex_treat_review"));
       	        List<WebElement> tagname3=rvlist.findElements(By.tagName("tr"));
       	        int k=1;
       	        for(WebElement tlist3 : tagname3){
       	        	Thread.sleep(2000);
       	        	WebElement element3=tlist3.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div"));
       	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).click();
       	        String rvname=tlist3.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getText();
       	        System.out.println("Review name="+rvname);
       	        if(rvname.matches(revname)){
       	        	Action doubleClick3 = action1.doubleClick(element3).build();
       		    	doubleClick3.perform();
       		    	Thread.sleep(2000);
       		    	String rvform = "//input[contains(@class,'leftmenuBox') and contains(@value,'Nonarthritic Score')]";
						   
        	       	 WebElement selfyes = driver.findElement(By.xpath(rvform));
        	       	 selfyes.click();
        	       	  Thread.sleep(3000);
     	       	  driver.findElement(By.id("edate")).sendKeys(date);
     	       	  //Select ohs1 = new Select(driver.findElement(By.id("ohs_pain_usually")));
     	       	 // ohs1.selectByVisibleText(pain);
     	             Select s=new Select(driver.findElement(By.id("score1")));
     	             s.selectByVisibleText(walking_flat);
     	             Select s1=new Select(driver.findElement(By.id("score2")));
     	             s1.selectByVisibleText(updown_stairs);
     	             Select s2=new Select(driver.findElement(By.id("score3")));
     	             s2.selectByVisibleText(night);
     	             Select s3=new Select(driver.findElement(By.id("score4")));
     	             s3.selectByVisibleText(sit_lying);	
     	             Select s4=new Select(driver.findElement(By.id("score5")));
     	             s4.selectByVisibleText(stand_upright);	
     	             Select s5=new Select(driver.findElement(By.id("score6")));
     	             s5.selectByVisibleText(catch_lock);
     	             Select s6=new Select(driver.findElement(By.id("score7")));
     	             s6.selectByVisibleText(hip_giving_put);
     	             Select s7=new Select(driver.findElement(By.id("score8")));
     	             s7.selectByVisibleText(stiffness);
     	             Select s8=new Select(driver.findElement(By.id("score9")));
     	             s8.selectByVisibleText(dec_motion);
     	             Select s9=new Select(driver.findElement(By.id("score10")));
     	             s9.selectByVisibleText(des_stairs);
     	             Select s10=new Select(driver.findElement(By.id("score11")));
     	             s10.selectByVisibleText(asc_stairs);
     	             Select s11=new Select(driver.findElement(By.id("score12")));
     	             s11.selectByVisibleText(rising_sitting);
     	             Select s12=new Select(driver.findElement(By.id("score13")));
     	             s12.selectByVisibleText(putonsocks);
     	             Select s13=new Select(driver.findElement(By.id("score14")));
     	             s13.selectByVisibleText(rising_bed);
     	             Select s14=new Select(driver.findElement(By.id("score15")));
     	             s14.selectByVisibleText(sprint_cut);
     	             Select s15=new Select(driver.findElement(By.id("score16")));
     	             s15.selectByVisibleText(low_sports);
     	             Select s16=new Select(driver.findElement(By.id("score17")));
     	             s16.selectByVisibleText(jogging);
     	             Select s17=new Select(driver.findElement(By.id("score18")));
     	             s17.selectByVisibleText(walking);
     	             Select s18=new Select(driver.findElement(By.id("score19")));
     	             s18.selectByVisibleText(heavy_duty);
     	             Select s19=new Select(driver.findElement(By.id("score20")));
     	             s19.selectByVisibleText(low_duty);
     	             Thread.sleep(2000);
     	             driver.findElement(By.id("btn_hip_nonarthritic_save")).click();
     	        	break;
     	        	
     	        }
     	        k++;
     	        }
     	        break;
        		}
     	i++;
        }
     break;
     }
    j++;
		}
		
    }   
  
}
