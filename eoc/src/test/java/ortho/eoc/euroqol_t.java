package ortho.eoc;

import java.io.IOException;
import java.util.List;

import junit.framework.Assert;
import jxl.read.biff.BiffException;

import org.openqa.selenium.Alert;
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

public class euroqol_t {
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
 		Object[][] retObjArr=datap.getTableArray("D:\\Renuka\\PatientDetails.xls",9);
        return(retObjArr);
         
 	}
  @Test(dataProvider="data-provider")	
  public void search(String ptname,String trname,String revname, String evdat,String mob,String self,String usual,String pain,String anxd,String healt,String comm)throws InterruptedException, BiffException, IOException {
	  
	 // driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[1]/div[2]/div[10]/a/img")).click();
	  driver.findElement(By.className("cls_header_patient")).click();
	  	
	  	Thread.sleep(3000);
	 // driver.findElement(By.id("SearchBox")).clear();
	  	 driver.findElement(By.id("SearchBox")).sendKeys("test");
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
	     	        String rvname=tlist3.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr/td[3]/div")).getText();
	     	        System.out.println("Review name="+rvname);
	     	        if(rvname.matches(revname)){
	     	        	Action doubleClick3 = action1.doubleClick(element3).build();
	     		    	doubleClick3.perform();
	     	        	Thread.sleep(2000);
	     	        	search2(evdat,mob,self,usual,pain,anxd,healt,comm);
	     	        	Thread.sleep(3000);
	     	        	driver.findElement(By.className("StudyName")).click();
	     	        	Thread.sleep(3000);
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
	    
	     
			}
  }
	        		
  
  public void search2(String evdate,String mobility,String selfcare,String usualact,String paindis,String anxdep,String health,String comments)throws InterruptedException, BiffException, IOException {      	
        	
	     	        	//driver.findElement(By.className("leftmenuBox")).click();
	     	        	String rvform11 = "//input[contains(@class, 'leftmenuBox') and contains(@value,'Euro QOL EQ5D')]";
				    	 WebElement selfyes = driver.findElement(By.xpath(rvform11));
						  selfyes.click();
						  Thread.sleep(3000);
						  driver.findElement(By.id("evaluation_date")).sendKeys(evdate);
						  driver.findElement(By.id("mobility"+mobility)).click();
						  System.out.println("selfcare="+selfcare);
						  String rvform1 = "//input[contains(@id, 'self_care') and contains(@value,"+selfcare+")]";
					    	 WebElement self = driver.findElement(By.xpath(rvform1));
							  self.click();
							  String rvform2 = "//input[contains(@id, 'usual_activities') and contains(@value,"+ usualact+")]";
						    	 WebElement selusal = driver.findElement(By.xpath(rvform2));
								  selusal.click();
								  String rvform3 = "//input[contains(@id, 'pain_discomfort') and contains(@value,"+ paindis+")]";
							    	 WebElement painds = driver.findElement(By.xpath(rvform3));
							    	 painds.click();
							    	 String rvform4 = "//input[contains(@id, 'anxiety_depression') and contains(@value,"+ anxdep+")]";
							    	 WebElement axdp = driver.findElement(By.xpath(rvform4));
							    	 axdp.click();
							    	
						  /*driver.findElement(By.id("self_care"+selfcare)).click();
						  driver.findElement(By.id("usual_activities"+usualact)).click();
						  driver.findElement(By.id("pain_discomfort"+paindis)).click();
						  driver.findElement(By.id("anxiety_depression"+anxdep)).click();*/
						  driver.findElement(By.id("health_state")).clear();
						  driver.findElement(By.id("health_state")).sendKeys(health);
						  driver.findElement(By.id("comments")).sendKeys(comments);
						  driver.findElement(By.id("cmd_eq5d_save")).click();
						  Thread.sleep(5000);
						  driver.findElement(By.id("cmd_eq5d_delete")).click();
						  driver.findElement(By.id("btn-ok")).click();
						  
						  Alert alert = driver.switchTo().alert();
					        String AlertText = alert.getText();
					        System.out.println(AlertText);
					        Assert.assertEquals("EuroQol Details deleted successfully", AlertText);
					         alert.accept();
	     	        	Thread.sleep(2000);
						  
	     	        
						
 }
  public void f() {
  }
}
