package ortho.eoc;

import java.io.IOException;
import java.util.List;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaselineAssessmentKnee {
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
 		Object[][] retObjArr=datap.getTableArray("D:\\Renuka\\testeoc.xls",2);
        return(retObjArr);
     }
    @Test(dataProvider="data-provider")
    public void search(String ptname,String trname,String revname,String date,String helpfillques,String livingarrange,String kneeprob,String descr_pain,String washdry_pain,String pubtrans_pain,String walkbfpain,String standup_chair,String limp_walk,String kneel_down,String bed_night,String usual_work,String mightsuddenly,String household_shop,String climbflight,String comment,String mobility,String selfcare,String usualact,String paindis,String anxdep,String comment1,String height,String weight,String bmi,String asa,String pbm1,String pbm2,String pbm3,String pbm4,String pbm5,String pbm6,String pbm7,String pbm8,String pbm9,String pbm10,String pbm11,String pbm12,String date1,String prbm1,String prbm2,String prbm3,String prbm4,String prbm5,String prbm6,String prbm7,String prbm8,String prbm9,String prbm10,String prbm11,String prbm12,String prbm13,String med_conditions)throws InterruptedException, BiffException, IOException {
    
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
     	        	
     	        	Thread.sleep(3000);
     	    	 WebElement rvlist= driver.findElement(By.className("flex_treat_review"));
       	        List<WebElement> tagname3=rvlist.findElements(By.tagName("tr"));
       	        int k=1;
       	        for(WebElement tlist3 : tagname3){
       	        	Thread.sleep(2000);
       	        	WebElement element3=tlist3.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div"));
       	        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).click();
       	        String rvname=tlist3.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getText();
       	        System.out.println("Review name="+rvname);
      p 	        if(rvname.matches(revname)){
       	        	Action doubleClick3 = action1.doubleClick(element3).build();
       		    	doubleClick3.perform();
       		    	Thread.sleep(2000);
       		    	String rvform = "//input[contains(@class,'leftmenuBox') and contains(@value,'Baseline Knee Assessment')]";
						   
        	       	 WebElement selfyes = driver.findElement(By.xpath(rvform));
        	       	 selfyes.click();
        	       	 Thread.sleep(2000);
        	       	 
        	       	 driver.findElement(By.id("pre_assessment_date")).sendKeys(date);
        	       	 Thread.sleep(2000);
        	       	driver.findElement(By.id("pre_help_fill_questionnaire1")).click();
        	       	  	Thread.sleep(2000);
        	       	 if(driver.findElement(By.id("pre_help_fill_questionnaire1")).isSelected())
        	   	  {Select helpyes = new Select(driver.findElement(By.id("pre_yeshelp_fill_questionnaire")));
        	   	  helpyes.selectByVisibleText(helpfillques);
        	   	  }
        	       	
    	             Select s1=new Select(driver.findElement(By.id("living_arragements")));
    	             s1.selectByVisibleText(livingarrange);
    	             
    	             Select s2=new Select(driver.findElement(By.id("pre_how_long_knee_pbm")));
    	             s2.selectByVisibleText(kneeprob);
    	             //driver.findElement(By.cssSelector("input[value='Yes']")).click();
    	             driver.findElement(By.id("pre_prevoius_joint_replacement1")).click();
    	             Thread.sleep(2000);
    	             
    	             driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td[1]/ul/li[2]/a")).click();
    	             Select s3=new Select(driver.findElement(By.id("oks_pain_usually")));
    	             s3.selectByVisibleText(descr_pain);
    	             Select s4=new Select(driver.findElement(By.id("oks_washing_drying")));
    	             s4.selectByVisibleText(washdry_pain);
    	             Select s5=new Select(driver.findElement(By.id("oks_public_transport")));
    	             s5.selectByVisibleText(pubtrans_pain);
    	             Select s6=new Select(driver.findElement(By.id("oks_able_towalk")));
    	             s6.selectByVisibleText(walkbfpain);
    	             Select s7=new Select(driver.findElement(By.id("oks_standup_chair")));
    	             s7.selectByVisibleText(standup_chair);
    	             Select s8=new Select(driver.findElement(By.id("oks_limping_walking")));
    	             s8.selectByVisibleText(limp_walk);
    	             Select s9=new Select(driver.findElement(By.id("oks_kneel_down")));
    	             s9.selectByVisibleText(kneel_down);
    	             Select s10=new Select(driver.findElement(By.id("oks_bed_night")));
    	             s10.selectByVisibleText(bed_night);
    	             Select s11=new Select(driver.findElement(By.id("oks_usual_work")));
    	             s11.selectByVisibleText(usual_work);
    	             Select s12=new Select(driver.findElement(By.id("oks_might_suddenly")));
    	             s12.selectByVisibleText(mightsuddenly);
    	             Select s13=new Select(driver.findElement(By.id("oks_household_shopping")));
    	             s13.selectByVisibleText(household_shop);
    	             Select s14=new Select(driver.findElement(By.id("oks_climb_flight")));
    	             s14.selectByVisibleText(climbflight);
    	         	driver.findElement(By.id("oks_comments")).clear();
    	             driver.findElement(By.id("oks_comments")).sendKeys(comment);
    	             Thread.sleep(2000);
    	            
    	             driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td[1]/ul/li[3]/a")).click();
    	             //String rvform5 = "//input[contains(@id, 'mobility1') and contains(@value,"+mobility+")]";
			    	// WebElement mob = driver.findElement(By.xpath(rvform5));
					 // mob.click();
    	            driver.findElement(By.id("mobility1")).click();
					  System.out.println("selfcare="+selfcare);
					  String rvform1 = "//input[contains(@id, 'self_care') and contains(@value,"+selfcare+")]";
				    	 WebElement self = driver.findElement(By.xpath(rvform1));
						  self.click();
					  //String rvform1 = "//input[contains(@id, 'self_care') and contains(@value,"+selfcare+")]";
				    	// WebElement self = driver.findElement(By.xpath(rvform1));
						  //self.click();
						  String rvform2 = "//input[contains(@id, 'usual_activities') and contains(@value,"+usualact+")]";
					    	 WebElement selusal = driver.findElement(By.xpath(rvform2));
							  selusal.click();
							  String rvform3 = "//input[contains(@id, 'pain_discomfort') and contains(@value,"+paindis+")]";
						    	 WebElement painds = driver.findElement(By.xpath(rvform3));
						    	 painds.click();
						    	 String rvform4 = "//input[contains(@id, 'anxiety_depression') and contains(@value,"+ anxdep+")]";
						    	 WebElement axdp = driver.findElement(By.xpath(rvform4));
						    	 axdp.click();
						    	 driver.findElement(By.id("comments")).clear();
    	             driver.findElement(By.id("comments")).sendKeys(comment1);
    	             Thread.sleep(2000);
    	            
    	             driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td[1]/ul/li[4]/a")).click();
    	             driver.findElement(By.id("pre_pat_height")).clear();
    	             driver.findElement(By.id("pre_pat_height")).sendKeys(height);
    	             driver.findElement(By.id("pre_pat_weight")).clear();
    	             driver.findElement(By.id("pre_pat_weight")).sendKeys(weight);
    	             driver.findElement(By.id("pre_pat_bmi")).clear();
    	             driver.findElement(By.id("pre_pat_bmi")).sendKeys(bmi);
    	             driver.findElement(By.id("pre_pat_asa")).clear();
    	             driver.findElement(By.id("pre_pat_asa")).sendKeys(asa);
    	             /*if (study7.matches("Yes")&& !driver.findElement(By.id("chk_uc_study_7")).isSelected()) {
    	     			Thread.sleep(1000);
    	     			driver.findElement(By.id("chk_uc_study_7")).click();*/
    	     			
    	     			if(pbm1.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm1")).isSelected()){
    	     				Thread.sleep(1000);
        	     			driver.findElement(By.id("pre_doctor_told_pbm1")).click();}
        	     			 
    	     			if(pbm2.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm2")).isSelected()){
    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_doctor_told_pbm2")).click(); }
			                if(pbm3.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm3")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_doctor_told_pbm3")).click(); }
			                if(pbm4.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm4")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_doctor_told_pbm4")).click(); }
			                if(pbm5.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm5")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_doctor_told_pbm5")).click(); }
			                if(pbm6.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm6")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_doctor_told_pbm6")).click(); }
			                if(pbm7.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm7")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_doctor_told_pbm7")).click(); }
			                if(pbm8.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm8")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_doctor_told_pbm8")).click(); }
			                if(pbm9.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm9")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_doctor_told_pbm9")).click(); }
			                if(pbm10.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm10")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_doctor_told_pbm10")).click(); }
			                if(pbm11.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm11")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_doctor_told_pbm11")).click(); }
			                if(pbm12.matches("Yes")&& !driver.findElement(By.id("pre_doctor_told_pbm312")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_doctor_told_pbm312")).click(); }
			                driver.findElement(By.id("today_date")).clear();
			                driver.findElement(By.id("today_date")).sendKeys(date1);
			                driver.findElement(By.id("pre_pat_disability1")).click();
			                if(prbm1.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm1")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm1")).click(); }
			                if(prbm2.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm2")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm2")).click(); }
			                if(prbm3.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm3")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm3")).click(); }
			                if(prbm4.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm4")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm4")).click(); }
			                if(prbm5.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm5")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm5")).click(); }
			                if(prbm6.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm6")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm6")).click(); }
			                if(prbm7.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm7")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm7")).click(); }
			                if(prbm8.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm8")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm8")).click(); }
			                if(prbm9.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm9")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm9")).click(); }
			                if(prbm10.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm10")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm10")).click(); }
			                if(prbm11.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm11")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm11")).click(); }
			                if(prbm12.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm12")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm12")).click(); }
			                if(prbm13.matches("Yes")&& !driver.findElement(By.id("pre_pat_influenced_pbm13")).isSelected()){
	    	     				Thread.sleep(1000);
			                driver.findElement(By.id("pre_pat_influenced_pbm13")).click(); }
			                driver.findElement(By.id("pre_medical_conditions")).clear();
			                driver.findElement(By.id("pre_medical_conditions")).sendKeys(med_conditions);
			                driver.findElement(By.id("baseline_data_save")).click(); 
		    	             Thread.sleep(2000);
			                
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
    }}