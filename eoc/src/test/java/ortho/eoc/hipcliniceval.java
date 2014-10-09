package ortho.eoc;

import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class hipcliniceval {
DataProviderAdd datap = new DataProviderAdd();
	
	private WebDriver driver = new FirefoxDriver();
	
	  
    @BeforeTest
    public void setup() throws InterruptedException
    {
    	driver.get("http://192.168.1.246/eoc_mahesh/main");
       	driver.manage().window().maximize();
    	
    	driver.findElement(By.id("username")).clear();
  	  	driver.findElement(By.id("username")).sendKeys("admin");
  	  	driver.findElement(By.id("password")).clear();
  	  	driver.findElement(By.id("password")).sendKeys("a");
  	  	driver.findElement(By.id("btLogin")).click();
  	  	Thread.sleep(2000);
  	  	
  	  	
  	  driver.findElement(By.className("StudyText")).click();
  	  
  	  Thread.sleep(2000);
  	
  	
   }
  	 
 	@DataProvider(name = "data-provider", parallel = false)
 	public Object[][] data() throws Exception {
 		Object[][] retObjArr=datap.getTableArray("D:\\Renuka\\testeoc.xls",1);
        return(retObjArr);
         
 	}
  @Test(dataProvider="data-provider")	
  public void search(String ptname,String trname,String revname,String weight,String height,String galtlimp,String date,String fixR,String fixL,String flexR,String flexL,String abductR,String abductL,String adductR,String adductL,String introtR,String introtL,String extrotR,String extrotL,String comment,String rightside,String leftside,String lurch1,String limblength,String discrep,String measuremethod,String othermeasure)throws InterruptedException, BiffException, IOException {
	  
	 // driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[2]/div[10]/a/img")).click();
	  driver.findElement(By.className("cls_header_patient")).click();
	  	
	  	Thread.sleep(3000);
	 // driver.findElement(By.id("SearchBox")).clear();
	  	 driver.findElement(By.id("SearchBox")).sendKeys("t");
	  	driver.findElement(By.id("btn_global_search")).click();
	  	Thread.sleep(2000);
	  	
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
	     	        	Thread.sleep(5000);
	     	        	String rvform = "//input[contains(@class,'leftmenuBox') and contains(@value,'Hip Clinical Evaluation')]";
	     			   
	     				 WebElement selfyes = driver.findElement(By.xpath(rvform));
	     				 selfyes.click();
	     				  Thread.sleep(3000);	
	     				  driver.findElement(By.id("weight")).sendKeys(weight);
	     				  driver.findElement(By.id("height")).sendKeys(height);
	     				  Select s=new Select(driver.findElement(By.id("galt_limp")));
	     			      s.selectByVisibleText(galtlimp);
	     			      driver.findElement(By.id("examination_date")).sendKeys(date);
	     			      driver.findElement(By.id("fixed_flexionR")).sendKeys(fixR);
	     			      driver.findElement(By.id("fixed_flexionL")).sendKeys(fixL);
	     			      driver.findElement(By.id("flexionR")).sendKeys(flexR);
	     			      driver.findElement(By.id("flexionL")).sendKeys(flexL);
	     			      driver.findElement(By.id("abductionR")).sendKeys(abductR);
	     			      driver.findElement(By.id("abductionL")).sendKeys(abductL);
	     			      driver.findElement(By.id("adductionR")).sendKeys(adductR);
	     			      driver.findElement(By.id("adductionL")).sendKeys(adductL);
	     			      driver.findElement(By.id("internal_rotationR")).sendKeys(introtR);
	     			      driver.findElement(By.id("internal_rotationL")).sendKeys(introtL);
	     			      driver.findElement(By.id("external_rotationR")).sendKeys(extrotR);
	     			      driver.findElement(By.id("external_rotationR")).sendKeys(extrotL);
	     			      driver.findElement(By.id("comments")).sendKeys(comment);
	     			      Select s1=new Select(driver.findElement(By.id("sign_right")));
	     			      s1.selectByVisibleText(rightside);
	     			      Select s2=new Select(driver.findElement(By.id("sign_left")));
	     			      s2.selectByVisibleText(leftside);
	     			     
	     			      Select s3=new Select(driver.findElement(By.id("lurch")));
	     			      s3.selectByVisibleText(lurch1);
	     			      
	     			      Select s4=new Select(driver.findElement(By.id("limb_length")));
	     			      s4.selectByVisibleText(limblength);
	     			      driver.findElement(By.id("lemb_length_specify")).sendKeys(discrep);
	     			      Select s5=new Select(driver.findElement(By.id("measurement_method")));
	     			      s5.selectByVisibleText(measuremethod);
	     			      
	     			      //Select s6=new Select(driver.findElement(By.id("other_measurement")));
	     			      //s6.selectByVisibleText(othermeasure);
	     			      Thread.sleep(2000);
	     			      driver.findElement(By.id("hip_clinical_evaluation_save")).click();
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