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

public class xrayanalysis {
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
 		Object[][] retObjArr=datap.getTableArray("D:\\Renuka\\testeoc.xls",3);
        return(retObjArr);
         
 	}
  @Test(dataProvider="data-provider")	
  public void search(String ptname,String trname,String revname,String date,String normal,String normalr,String acetabular,String acetabularr,String valga,String valgar,String vara,String varar,String periacet,String periacetr,String pelvic,String pelvicr,String proximal,String proximalr,String preskeletal,String preskeletalr,String postskeletal,String postskeletalr,String perthes,String perthesr,String sufe,
		  String sufer,String pistol,String pistolr,String profunda,String profundar,String protrusio,String protrusior,String retro,String retror,String joint,String jointr,String traumatic,String traumaticr,String septic,String septicr,String pvns,String pvnsr,String synovial,String synovialr,String primaryoa,String primaryoar,String primaryother,String primaryotherr,String lefthipother,String righthipother,
		  String hemiarthrop,String hemiarthropr,String aseptic,String asepticr,String ostoloysis,String ostoloysisr,String revision,String revisionr,String instability,String instabilityr,String prosthetic,String prostheticr,String revother,String revotherr,String revleftother,String revrightother,String tonnisgrading,String tonnisgradingr,String tonnisleft,String tonnisright,String femoral,String femoralheight,String medial,String position,String illoischial,String femoralheadsize,String hipheight,String notes)throws InterruptedException, BiffException, IOException {
	  
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
	     	        	String rvform = "//input[contains(@class,'leftmenuBox') and contains(@value,'X Ray Analysis')]";
	     			   
	     				 WebElement selfyes = driver.findElement(By.xpath(rvform));
	     				 selfyes.click();
	     				 Thread.sleep(2000);
	     				 //driver.findElement(By.className("dateformatPICK smallBox hasDatepicker")).sendKeys(date);
	     				// String rvform1 = "//input[contains(@id, 'self_care') and contains(@value,"+selfcare+")]";
				    	 //WebElement self = driver.findElement(By.xpath(rvform1));
						  //self.click();
	     				 String s1 =  "//input[contains(@id,'xa_normal') and contains(@value,"+normal+")]";
	     				 WebElement n=driver.findElement(By.xpath(s1));
	     				 n.click();
	     				
	     				 String s2 =  "//input[contains(@id,'xa_normalr') and contains(@value,"+normalr+")]";
	     				 WebElement n1=driver.findElement(By.xpath(s2));
	     				 n1.click();
	     				 String s3 =  "//input[contains(@id,'xa_acetabular') and contains(@value,"+acetabular+")]";
	     				 WebElement n2=driver.findElement(By.xpath(s3));
	     				 n2.click();
	     				 String s4 =  "//input[contains(@id,'xa_acetabularr') and contains(@value,"+acetabularr+")]";
	     				 WebElement n3=driver.findElement(By.xpath(s4));
	     				 n3.click();
	     				 String s5 =  "//input[contains(@id,'xa_coxa_valga') and contains(@value,"+valga+")]";
	     				 WebElement n4=driver.findElement(By.xpath(s5));
	     				 n4.click();
	     				 String s6 =  "//input[contains(@id,'xa_coxa_valgar') and contains(@value,"+valgar+")]";
	     				 WebElement n5=driver.findElement(By.xpath(s6));
	     				 n5.click();
	     				 String s7 =  "//input[contains(@id,'xa_coxa_vara') and contains(@value,"+vara+")]";
	     				 WebElement n6=driver.findElement(By.xpath(s7));
	     				 n6.click();
	     				 String s8 =  "//input[contains(@id,'xa_coxa_varar') and contains(@value,"+varar+")]";
	     				 WebElement n7=driver.findElement(By.xpath(s8));
	     				 n7.click();
	     				 String s9 =  "//input[contains(@id,'xa_periacetabular') and contains(@value,"+periacet+")]";
	     				 WebElement n8=driver.findElement(By.xpath(s9));
	     				 n8.click();
	     				 String s10 =  "//input[contains(@id,'xa_periacetabularr') and contains(@value,"+periacetr+")]";
	     				 WebElement n9=driver.findElement(By.xpath(s10));
	     				 n9.click();
	     				 String s11 =  "//input[contains(@id,'xa_pelvic') and contains(@value,"+pelvic+")]";
	     				 WebElement n10=driver.findElement(By.xpath(s11));
	     				 n10.click();
	     				 String s12 =  "//input[contains(@id,'xa_pelvicr') and contains(@value,"+pelvicr+")]";
	     				 WebElement n11=driver.findElement(By.xpath(s12));
	     				 n11.click();
	     				 String s13 =  "//input[contains(@id,'xa_proximal') and contains(@value,"+proximal+")]";
	     				 WebElement n12=driver.findElement(By.xpath(s13));
	     				 n12.click();
	     				 String s14 =  "//input[contains(@id,'xa_proximalr') and contains(@value,"+proximalr+")]";
	     				 WebElement n13=driver.findElement(By.xpath(s14));
	     				 n13.click();
	     				 String s15 =  "//input[contains(@id,'xa_pre_skeletal') and contains(@value,"+preskeletal+")]";
	     				 WebElement n14=driver.findElement(By.xpath(s15));
	     				 n14.click();
	     				 String s16 =  "//input[contains(@id,'xa_pre_skeletalr') and contains(@value,"+preskeletalr+")]";
	     				 WebElement n15=driver.findElement(By.xpath(s16));
	     				 n15.click();
	     				String s17 =  "//input[contains(@id,'xa_post_skeletal') and contains(@value,"+postskeletal+")]";
	     				 WebElement n16=driver.findElement(By.xpath(s17));
	     				 n16.click();
	     				String s18 =  "//input[contains(@id,'xa_post_skeletalr') and contains(@value,"+postskeletalr+")]";
	     				 WebElement n17=driver.findElement(By.xpath(s18));
	     				 n17.click();
	     				String s19 =  "//input[contains(@id,'xa_perthes') and contains(@value,"+perthes+")]";
	     				 WebElement n18=driver.findElement(By.xpath(s19));
	     				 n18.click();
	     				String s20 =  "//input[contains(@id,'xa_perthesr') and contains(@value,"+perthesr+")]";
	     				 WebElement n19=driver.findElement(By.xpath(s20));
	     				 n19.click();
	     				String s21 =  "//input[contains(@id,'xa_sufe') and contains(@value,"+sufe+")]";
	     				 WebElement n20=driver.findElement(By.xpath(s21));
	     				 n20.click();
	     				String s22 =  "//input[contains(@id,'xa_sufer') and contains(@value,"+sufer+")]";
	     				 WebElement n21=driver.findElement(By.xpath(s22));
	     				 n21.click();
	     				String s23 =  "//input[contains(@id,'xa_cam_pistol') and contains(@value,"+pistol+")]";
	     				 WebElement n22=driver.findElement(By.xpath(s23));
	     				 n22.click();
	     				String s24 =  "//input[contains(@id,'xa_cam_pistolr') and contains(@value,"+pistolr+")]";
	     				 WebElement n23=driver.findElement(By.xpath(s24));
	     				 n23.click();
	     				String s25 =  "//input[contains(@id,'xa_coxa_profunda') and contains(@value,"+profunda+")]";
	     				 WebElement n24=driver.findElement(By.xpath(s25));
	     				 n24.click();
	     				String s26 =  "//input[contains(@id,'xa_coxa_profundar') and contains(@value,"+profundar+")]";
	     				 WebElement n25=driver.findElement(By.xpath(s26));
	     				 n25.click();
	     				String s27 =  "//input[contains(@id,'xa_coxa_protrusio') and contains(@value,"+protrusio+")]";
	     				 WebElement n26=driver.findElement(By.xpath(s27));
	     				 n26.click();
	     				String s28 =  "//input[contains(@id,'xa_coxa_protrusior') and contains(@value,"+protrusior+")]";
	     				 WebElement n27=driver.findElement(By.xpath(s28));
	     				 n27.click();
	     				String s29 =  "//input[contains(@id,'xa_acetabular_retroversion') and contains(@value,"+retro+")]";
	     				 WebElement n28=driver.findElement(By.xpath(s29));
	     				 n28.click();
	     				String s30 =  "//input[contains(@id,'xa_acetabular_retroversionr') and contains(@value,"+retror+")]";
	     				 WebElement n29=driver.findElement(By.xpath(s30));
	     				 n29.click();
	     				String s31 =  "//input[contains(@id,'xa_joint_disease') and contains(@value,"+joint+")]";
	     				 WebElement n30=driver.findElement(By.xpath(s31));
	     				 n30.click();
	     				String s32 =  "//input[contains(@id,'xa_joint_diseaser') and contains(@value,"+jointr+")]";
	     				 WebElement n31=driver.findElement(By.xpath(s32));
	     				 n31.click();
	     				String s33 =  "//input[contains(@id,'xa_post_traumatic') and contains(@value,"+traumatic+")]";
	     				 WebElement n32=driver.findElement(By.xpath(s33));
	     				 n32.click();
	     				String s34 =  "//input[contains(@id,'xa_post_traumaticr') and contains(@value,"+traumaticr+")]";
	     				 WebElement n33=driver.findElement(By.xpath(s34));
	     				 n33.click();
	     				String s35 =  "//input[contains(@id,'xa_septic_arthritis') and contains(@value,"+septic+")]";
	     				 WebElement n34=driver.findElement(By.xpath(s35));
	     				 n34.click();
	     				String s36 =  "//input[contains(@id,'xa_septic_arthritisr') and contains(@value,"+septicr+")]";
	     				 WebElement n35=driver.findElement(By.xpath(s36));
	     				 n35.click();
	     				String s37 =  "//input[contains(@id,'xa_pvns') and contains(@value,"+pvns+")]";
	     				 WebElement n36=driver.findElement(By.xpath(s37));
	     				 n36.click();
	     				String s38 =  "//input[contains(@id,'xa_pvnsr') and contains(@value,"+pvnsr+")]";
	     				 WebElement n37=driver.findElement(By.xpath(s38));
	     				 n37.click();
	     				String s39 =  "//input[contains(@id,'xa_synovial_chondromatosis') and contains(@value,"+synovial+")]";
	     				 WebElement n38=driver.findElement(By.xpath(s39));
	     				 n38.click();
	     				String s40 =  "//input[contains(@id,'xa_synovial_chondromatosisr') and contains(@value,"+synovialr+")]";
	     				 WebElement n39=driver.findElement(By.xpath(s40));
	     				 n39.click();
	     				String s41 =  "//input[contains(@id,'xa_primary_oa') and contains(@value,"+primaryoa+")]";
	     				 WebElement n40=driver.findElement(By.xpath(s41));
	     				 n40.click();
	     				String s42 =  "//input[contains(@id,'xa_primary_oar') and contains(@value,"+primaryoar+")]";
	     				 WebElement n41=driver.findElement(By.xpath(s42));
	     				 n41.click();
	     				String s43 =  "//input[contains(@id,'xa_primary_other') and contains(@value,"+primaryother+")]";
	     				 WebElement n42=driver.findElement(By.xpath(s43));
	     				 n42.click();
	     				String s44 =  "//input[contains(@id,'xa_primary_otherr') and contains(@value,"+primaryotherr+")]";
	     				 WebElement n43=driver.findElement(By.xpath(s44));
	     				 n43.click();
	     				 
	     				 if(driver.findElement(By.xpath(s43)).isSelected())
	     				 {
	     					Thread.sleep(5000);
	     					driver.findElement(By.id("xa_primary_lefthip_other")).click();
	     					driver.findElement(By.id("xa_primary_lefthip_other")).sendKeys("test");
	     				 driver.findElement(By.id("xa_primary_lefthip_other")).sendKeys(lefthipother);
	     				 }
	     				 driver.findElement(By.id("xa_primary_righthip_other")).sendKeys(righthipother);
	     				String s45 =  "//input[contains(@id,'xa_hemiarthroplasty') and contains(@value,"+hemiarthrop+")]";
	     				 WebElement n44=driver.findElement(By.xpath(s45));
	     				 n44.click();
	     				String s46 =  "//input[contains(@id,'xa_hemiarthroplastyr') and contains(@value,"+hemiarthropr+")]";
	     				 WebElement n45=driver.findElement(By.xpath(s46));
	     				 n45.click();
	     				String s47 =  "//input[contains(@id,'xa_aseptic_loosening') and contains(@value,"+aseptic+")]";
	     				 WebElement n46=driver.findElement(By.xpath(s47));
	     				 n46.click();
	     				String s48 =  "//input[contains(@id,'xa_aseptic_looseningr') and contains(@value,"+asepticr+")]";
	     				 WebElement n47=driver.findElement(By.xpath(s48));
	     				 n47.click();
	     				String s49 =  "//input[contains(@id,'xa_ostoloysis') and contains(@value,"+ostoloysis+")]";
	     				 WebElement n48=driver.findElement(By.xpath(s49));
	     				 n48.click();
	     				String s50 =  "//input[contains(@id,'xa_ostoloysisr') and contains(@value,"+ostoloysisr+")]";
	     				 WebElement n49=driver.findElement(By.xpath(s50));
	     				 n49.click();
	     				String s51 =  "//input[contains(@id,'xa_revision_infection') and contains(@value,"+revision+")]";
	     				 WebElement n50=driver.findElement(By.xpath(s51));
	     				 n50.click();
	     				String s52 =  "//input[contains(@id,'xa_revision_infectionr') and contains(@value,"+revisionr+")]";
	     				 WebElement n51=driver.findElement(By.xpath(s52));
	     				 n51.click();
	     				String s53 =  "//input[contains(@id,'xa_revision_instability') and contains(@value,"+instability+")]";
	     				 WebElement n52=driver.findElement(By.xpath(s53));
	     				 n52.click();
	     				String s54 =  "//input[contains(@id,'xa_revision_instabilityr') and contains(@value,"+instabilityr+")]";
	     				 WebElement n53=driver.findElement(By.xpath(s54));
	     				 n53.click();
	     				String s55 =  "//input[contains(@id,'xa_peri_prosthetic') and contains(@value,"+prosthetic+")]";
	     				 WebElement n54=driver.findElement(By.xpath(s55));
	     				 n54.click();
	     				String s56 =  "//input[contains(@id,'xa_peri_prostheticr') and contains(@value,"+prostheticr+")]";
	     				 WebElement n55=driver.findElement(By.xpath(s56));
	     				 n55.click();
	     				String s57 =  "//input[contains(@id,'xa_revision_other') and contains(@value,"+revother+")]";
	     				 WebElement n56=driver.findElement(By.xpath(s57));
	     				 n56.click();
	     				String s58 =  "//input[contains(@id,'xa_revision_otherr') and contains(@value,"+revotherr+")]";
	     				 WebElement n57=driver.findElement(By.xpath(s58));
	     				 n57.click();
	     				driver.findElement(By.id("xa_revision_lefthip_other")).sendKeys(revleftother);
	     				driver.findElement(By.id("xa_revision_righthip_other")).sendKeys(revrightother);
	     				 Select d1=new Select(driver.findElement(By.id("xa_tonnis_grading")));
	    	             d1.selectByVisibleText(tonnisgrading);
	    	             Select d2=new Select(driver.findElement(By.id("xa_tonnis_gradingr")));
	    	             d2.selectByVisibleText(tonnisgradingr);
	     				 driver.findElement(By.id("xa_tonnis_grading_lefthip")).sendKeys(tonnisleft);
	     				 driver.findElement(By.id("xa_tonnis_grading_righthip")).sendKeys(tonnisright);
	     				 Thread.sleep(2000);
	     				 driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/form/table/tbody/tr[2]/td[1]/ul/li[2]/a")).click();
	     				 driver.findElement(By.id("xa_femoral_offset")).sendKeys(femoral);
	     				 driver.findElement(By.id("xa_femoral_height")).sendKeys(femoralheight);
	     				 driver.findElement(By.id("xa_medial_offset")).sendKeys(medial);
	     				Select p1=new Select(driver.findElement(By.id("xa_position")));
	    	           //  p1.selectByVisibleText(position);
	    	             p1.selectByValue("3");
	    	             driver.findElement(By.id("xa_illoischial_offset")).sendKeys(illoischial);
	    	             driver.findElement(By.id("xa_femoral_head_size")).sendKeys(femoralheadsize);
	    	             driver.findElement(By.id("xa_hip_height")).sendKeys(hipheight);
	    	             driver.findElement(By.id("xa_notes")).sendKeys(notes);
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
  

  @Test
  public void f() {
  }
}
