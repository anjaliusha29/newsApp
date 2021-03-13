import { element } from "@angular/core/src/render3";
import { browser,by } from "protractor";

describe('Login Page Testing',function(){

     it('Login User invalid userId', async()=>  {  
    
        browser.get("http://localhost:4200/login");
         browser.driver.manage().window().maximize();
         browser.driver.sleep(4000); 
        
        browser.findElement(by.id('userId')).sendKeys("arun01");
      
        browser.findElement(by.id('password')).sendKeys("arnav@123");
     
        browser.findElement(by.buttonText('Login')).click(); 
        browser.driver.sleep(5000);
         expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/login');
       browser.driver.sleep(5000);  
     })

      it('Login User invalid Password', async()=>  {  
    
         browser.get("http://localhost:4200/login");
         browser.driver.manage().window().maximize();
         browser.driver.sleep(4000); 
        
         browser.findElement(by.id('userId')).sendKeys("arnav01");
      
         browser.findElement(by.id('password')).sendKeys("arun@123");
     
        browser.findElement(by.buttonText('Login')).click(); 
        browser.driver.sleep(5000);
        expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/login');
        browser.driver.sleep(5000);  
      })

      it('Login User blank credentials', async()=>  {  
    
         browser.get("http://localhost:4200/login");
         browser.driver.manage().window().maximize();
         browser.driver.sleep(4000); 
        
        browser.findElement(by.id('userId')).sendKeys("");
      
        browser.findElement(by.id('password')).sendKeys("");
     
        browser.findElement(by.buttonText('Login')).click(); 
         browser.driver.sleep(5000);
         expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/login');
         browser.driver.sleep(5000);  
      })

   it('Login User valid credentials', async()=>  {  
    
    browser.get("http://localhost:4200/login");
    browser.driver.manage().window().maximize();
    browser.driver.sleep(4000); 
    
    browser.findElement(by.id('userId')).sendKeys("arnav01");
  
    browser.findElement(by.id('password')).sendKeys("arnav001");
 
    browser.findElement(by.buttonText('Login')).click(); 
    browser.driver.sleep(5000);
    expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/news/dashboard');
    browser.driver.sleep(5000);  
 })

})
