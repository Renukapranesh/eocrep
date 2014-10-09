package ortho.eoc;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;                             //Inpatient
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class kneeOperationData {
WebDriver driver=new FirefoxDriver();
	
	WebDriverWait wait = new WebDriverWait(driver,10);
	
	Actions action = new Actions(driver);
	
	DataProviderAdd datap = new DataProviderAdd();
	
	@DataProvider(name = "DP1", parallel = false)
	public Object[][] createdata() throws Exception {
		Object[][] retObjArr=datap.getTableArray("D:\\Renuka\\KneeOperationData.xls",0);
        return(retObjArr);  
	}
	@BeforeTest
	 public void beforetest()throws Exception {
	  //To Maximize Browser Window
	  driver.manage().window().maximize();
	  //To Open URL In browser
	  driver.get(" http://192.168.1.246/eoc_mahesh/main");
	  driver.findElement(By.id("username")).clear();
	  driver.findElement(By.id("username")).sendKeys("super_admin");
	  Thread.sleep(1000);
	  driver.findElement(By.id("password")).clear();
	  driver.findElement(By.id("password")).sendKeys("a");
	  Thread.sleep(1000);
	  driver.findElement(By.name("btLogin")).click();
	  Thread.sleep(1000);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[3]")));
	  driver.findElement(By.xpath("/html/body/div[3]")).click();
	  Thread.sleep(1000);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/ul/li[1]")));
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/ul/li[1]")).click();
	  Thread.sleep(1000);	
	}
	@Test(priority=1)
	public void test_patientsearch()throws Exception {
		driver.findElement(By.id("SearchBox")).sendKeys("Carita");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/table[2]/tbody/tr/td/input[1]")).click();
		Thread.sleep(1000);
 	  	WebElement table = driver.findElement(By.className("flex_patient"));
 	  	List<WebElement> tagname1 = table.findElements(By.tagName("tr"));
		int i=1;
		for(WebElement tlist : tagname1)
		{
	    	 WebElement element = tlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr["+i+"]/td/div"));
	    	 String sd=tlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div[2]/div/div[7]/table/tbody/tr["+i+"]/td/div")).getText();
	    	 if(sd.matches("Carita"))
	    	 {
	    		 Thread.sleep(1000);
	    		 action.doubleClick(element).build().perform();
	    		 break;
	    	 }
	    	 i++;
		}
	}
	@Test(priority=2)
	public void treatment_select()throws Exception {
		 Thread.sleep(3000);
		 WebElement trmtlist = driver.findElement(By.className("flex_treatment"));
		 List<WebElement> tagname2 = trmtlist.findElements(By.tagName("tr"));
		 int j =1;    
		 for(WebElement tlist : tagname2)
			{
		    	 WebElement element1 = tlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div/div[7]/table/tbody/tr["+j+"]/td[3]/div"));
		    	 String tname=tlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div/div[7]/table/tbody/tr["+j+"]/td[3]/div")).getText();
		    	 String tdate=tlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div/div[7]/table/tbody/tr["+j+"]/td[2]/div")).getText();
		    	 if(tdate.matches("22-07-2014") && tname.matches("Right  Knee  Replacement"))
		    	 {
		    		Thread.sleep(1000);
		    		action.doubleClick(element1).build().perform();
			    	break;
		    	 }
		    	j++;
			}
		}

	@Test(priority=3)
	public void review_select()throws Exception{
		Thread.sleep(3000);
		WebElement revlist = driver.findElement(By.className("flex_treat_review"));
	  	List<WebElement> tagname3 = revlist.findElements(By.tagName("tr"));
	  	int k =1;    
	  	for(WebElement rlist : tagname3)
	  	 {
	    	 WebElement element2 = rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div"));
	    	 String rname=rlist.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div/div[7]/table/tbody/tr["+k+"]/td[3]/div")).getText();
	    	 if(rname.equals("In-Patient Stay"))
	    	 {
	    		 Thread.sleep(1000);
	    		 action.doubleClick(element2).build().perform();// After performing double click Map will load
		    	 break;
	    	 }
	    	 k++;	 
		}
	}
	@Test(dataProvider="DP1",priority=4)
	public void hipOperation(String date,String Operationdes,String Code,String OpIndication,String PatientPosition,String KneePosition,String Hospital,String Leadsurgeon,String Leadgrade,String secndlead,String secndndgrade,
			String fstasst,String secndasst,String fstaneasthetist,String secndaneasthetist,String antibiotics,String Tourniquet,String Surgicalapproach,String FatPad,String Dose,String PatellaPreparation,String Reduction,
			String Findings,String patellofemoraljoint,String medialtibfemjoint,String lateraltibfemjoint,String synovium,String Pcl,String Acl,String preopbloodloss,String Unitstransfusedperop,String PreopHb,String postopbloodloss,
			String Unitstransfusedpostop,String postophb,String Deeplayer,String Skin,String Subcutaneousfat,String Dressings,String Fascialata,
			String Suture,String Noofdrains,String Mobilise,String Checkxrays,String Removesutures,String Thromboname,String Thrombodose,
			String Thrombofreq,String Thromboduration,String AntibioticsName,String Antibioticsdose,String Antibioticsfreq,String Antibioticsduration,String Kneereplacementtype,String Manufacturer,
			String Femoralcomponentsize,String Femoralstem,String Femoralfixation,String Femoralstemdiameter,String femoralstemlength,String Femoralplugtype,String Femoralplugsize,String Tibialcomsize,String Tibialfixation,String Tibialplugtype,
			String Tibialinsert,String tibialscrews,String Tibialstem,String Tibialstemdiameter,String Tibialplugsize,String TibialStemLength,String Patellasurfaced,String Patellacomponentthickness,String Patcomponentsize,String Patellafixation,String Notess)throws Exception{
		
		Thread.sleep(1000);
      	String euroq = "//input[contains(@class, 'leftmenuBox') and contains(@value, 'Knee Operation Data')]";
    	WebElement euroyes = driver.findElement(By.xpath(euroq));
    	euroyes.click();
    	Thread.sleep(1000);
    	
        //Evaluation Date
		    driver.findElement(By.id("evaluation_date")).click();
		     driver.findElement(By.id("evaluation_date")).sendKeys(date);
		     driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li/a")).click(); 
	//Operation desc 
    driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(Operationdes);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[2]/td[2]/span")).click();	
	//Code
	driver.findElement(By.id("op_code")).sendKeys(Code);
	//Op indication
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(OpIndication);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[4]/td[2]/span")).click();
	//Patient Position
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[6]/td[2]/span/div/input")).sendKeys(PatientPosition);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[6]/td[2]/span")).click();
	//Knee position
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[7]/td[2]/span/div/input")).sendKeys(KneePosition);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div/table/tbody/tr[7]/td[2]/span")).click();
    //Operator
    driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[2]/a")).click();
	//Hospital
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(Hospital);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[2]/td[2]/span")).click();
	//Lead Surgeon
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(Leadsurgeon);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[3]/td[2]/span")).click();
	//Lead grade
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(Leadgrade);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[4]/td[2]/span")).click();
	//2nd lead
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[5]/td[2]/span/div/input")).sendKeys(secndlead);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[5]/td[2]/span")).click();
	//2nd grade
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[6]/td[2]/span/div/input")).sendKeys(secndndgrade);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[6]/td[2]/span")).click();
	//1st asst
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[8]/td[2]/span/div/input")).sendKeys(fstasst);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[8]/td[2]/span")).click();
	//2nd asst
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[9]/td[2]/span/div/input")).sendKeys(secndasst);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[9]/td[2]/span")).click();
	//1st aneasthetist
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[10]/td[2]/span/div/input")).sendKeys(fstaneasthetist);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[10]/td[2]/span")).click();
	//2nd aneasthetist
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[11]/td[2]/span/div/input")).sendKeys(secndaneasthetist);
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[2]/table/tbody/tr[11]/td[2]/span")).click();
	//Surgery
	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[3]/a")).click();
		//Pre-op antibiotics
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(antibiotics);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td[2]/span")).click();
		//Dose
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td[4]/span/div/input")).sendKeys(Dose);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[2]/td[4]/span")).click();
		driver.findElement(By.id("tourniquet_time")).sendKeys(Tourniquet);
		//Surgical Approach
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(Surgicalapproach);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td[2]/span")).click();
		//Patella preparation
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td[4]/span/div/input")).sendKeys(PatellaPreparation);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[4]/td[4]/span")).click();
		//Fat pad
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[5]/td[2]/span/div/input")).sendKeys(FatPad);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[5]/td[2]/span")).click();
		//Reduction
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[5]/td[4]/span/div/input")).sendKeys(Reduction);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[5]/td[4]/span")).click();
		//findings
			driver.findElement(By.id("findings")).sendKeys(Findings);
			//Condition of synovium
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[7]/td[3]/span/div/input")).sendKeys(synovium);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[7]/td[3]/span")).click();
			//Condition of patello-femoral joint
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td[2]/span/div/input")).sendKeys(patellofemoraljoint);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td[2]/span")).click();
			//Condition of medial tib-fem joint
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[9]/td[2]/span/div/input")).sendKeys(medialtibfemjoint);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[9]/td[2]/span")).click();
			//Condition of lateral tib-fem joint
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td[2]/span/div/input")).sendKeys(lateraltibfemjoint);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[10]/td[2]/span")).click();
			//Condition of PCL
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td[4]/span/div/input")).sendKeys(Pcl);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[8]/td[4]/span")).click();
			//Condition of ACL
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[9]/td[4]/span/div/input")).sendKeys(Acl);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[9]/td[4]/span")).click();
			

	driver.findElement(By.id("preop_blood")).sendKeys(preopbloodloss);
	Thread.sleep(1000);
	//Select perop = new Select(driver.findElement(By.id("perop_units")));
	//perop.selectByValue(peropunits);
	driver.findElement(By.id("preop_hb")).sendKeys(PreopHb);
	driver.findElement(By.id("postop_blood")).sendKeys(postopbloodloss);
	//Select postop = new Select(driver.findElement(By.id("postop_units")));
	//postop.selectByValue(postopunits);
	//postop.selectByVisibleText(postopunits);  
	driver.findElement(By.id("postop_hb")).sendKeys(postophb);
	//Deep layer
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[16]/td[2]/span/div/input")).sendKeys(Deeplayer);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[16]/td[2]/span")).click();
		//Suture
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[16]/td[4]/span/div/input")).sendKeys(Suture);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[16]/td[4]/span")).click();
		//Subcutaneous fat
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[17]/td[2]/span/div/input")).sendKeys(Subcutaneousfat);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[17]/td[2]/span")).click();
		//Noofdrains
		Select ndrains = new Select(driver.findElement(By.id("no_of_drains")));
		ndrains.selectByVisibleText(Noofdrains);
		//Skin
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[18]/td[2]/span/div/input")).sendKeys(Skin);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[18]/td[2]/span")).click();
		//Dressings
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[18]/td[4]/span/div/input")).sendKeys(Dressings);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[18]/td[4]/span")).click();
		//Patient catherised
	//	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[19]/td[3]/span/div/input")).sendKeys(Patientcatherised);
		//driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[19]/td[3]/span")).click();
		//Mobilise
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[20]/td[2]/span/div/input")).sendKeys(Mobilise);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[20]/td[2]/span")).click();
		//Check x-rays
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[21]/td[2]/span/div/input")).sendKeys(Checkxrays);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[21]/td[2]/span")).click();
		//Remove sutures
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[22]/td[2]/span/div/input")).sendKeys(Removesutures);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[22]/td[2]/span")).click();
		//Thrombo name
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(Thromboname);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[2]/span")).click();
		//Thrombo dose
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[3]/span/div/input")).sendKeys(Thrombodose);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[3]/span")).click();
		//Thrombo freq
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[4]/span/div/input")).sendKeys(Thrombofreq);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[4]/span")).click();
		//Thrombo duration
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[5]/span/div/input")).sendKeys(Thromboduration);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[2]/td[5]/span")).click();
		//Antibioctics name
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(AntibioticsName);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[2]/span")).click();
		//Antibioctics dose
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[3]/span/div/input")).sendKeys(Antibioticsdose);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[3]/span")).click();
		//Antibiotics freq
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[4]/span/div/input")).sendKeys(Antibioticsfreq);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[4]/span")).click();
		//Antibiotics duration
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[5]/span/div/input")).sendKeys(Antibioticsduration);
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[3]/table/tbody/tr[23]/td/table/tbody/tr[3]/td[5]/span")).click();
		//Implants tab
		driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[2]/td/ul/li[4]/a")).click();
		//Knee replacement type
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td[2]/span/div/input")).sendKeys(Kneereplacementtype);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td[2]/span")).click();
			//Manufacturer
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td[4]/span/div/input")).sendKeys(Manufacturer);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[2]/td[4]/span")).click();
			//Femoral component size
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[3]/td[2]/span/div/input")).sendKeys(Femoralcomponentsize);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[3]/td[2]/span")).click();
			//Femoral stem
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[3]/td[4]/span/div/input")).sendKeys(Femoralstem);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[3]/td[4]/span")).click();
			//Femoral fixation
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td[2]/span/div/input")).sendKeys(Femoralfixation);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td[2]/span")).click();
			//Femoral stem diameter
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td[4]/span/div/input")).sendKeys(Femoralstemdiameter);
      	driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[4]/td[4]/span")).click();
			//femoral stem length
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[5]/td[3]/span/div/input")).sendKeys(femoralstemlength);
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[5]/td[3]/span")).click();
			//Femoral plug type
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[6]/td[2]/span/div/input")).sendKeys(Femoralplugtype);
			//Femoral plug size
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[6]/td[4]/span/div/input")).sendKeys(Femoralplugsize);
			//Tibial com size
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[8]/td[2]/span/div/input")).sendKeys(Tibialcomsize);
			//Tibial fixation
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[9]/td[2]/span/div/input")).sendKeys(Tibialfixation);
			//Tibial plug type
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[10]/td[2]/span/div/input")).sendKeys(Tibialplugtype);
			//Tibial insert
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[11]/td[2]/span/div/input")).sendKeys(Tibialinsert);
			//tibial screws
			Select tscrews = new Select(driver.findElement(By.id("tibial_screws_no")));
			tscrews.selectByVisibleText(tibialscrews);
			//Tibial stem
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[8]/td[4]/span/div/input")).sendKeys(Tibialstem);
			//Tibial stem diameter
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[9]/td[4]/span/div/input")).sendKeys(Tibialstemdiameter);
			//Tibial plug size
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[10]/td[4]/span/div/input")).sendKeys(Tibialplugsize);
			//Tibial Stem Length
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[11]/td[4]/span/div/input")).sendKeys(TibialStemLength);
			//Patella surfaced
			driver.findElement(By.id("patella_resurfaced")).click();
			//Patella component thickness
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[14]/td[4]/span/div/input")).sendKeys(Patellacomponentthickness);
			//Pat component size
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[15]/td[2]/span/div/input")).sendKeys(Patcomponentsize);
			//Patella fixation
			driver.findElement(By.xpath("/html/body/div[67]/div[3]/div/div[2]/form/table/tbody/tr[3]/td/div/div/div[4]/table/tbody/tr[16]/td[2]/span/div/input")).sendKeys(Patellafixation);
			//Notes on TKR Preparation/implantation
			driver.findElement(By.id("tkr_preparation")).sendKeys(Notess);
			//save
			driver.findElement(By.id("knee_operation_save")).click();
	}
}
