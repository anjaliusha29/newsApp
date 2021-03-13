import { HttpResponse } from "@angular/common/http";
import { element } from "@angular/core/src/render3";
import { browser,by } from "protractor";

describe('Register Page Testing',function(){
   it('To check the page title',function(){
   browser.ignoreSynchronization=true;
   browser.get("http://localhost:4200/register").then(()=>(browser.getTitle())).then((title)=>(console.log(title)));
  })
  
  //Defect--1

   it('Register user without firstname secondname and password', async()=> {
   browser.get("http://localhost:4200/register");
   browser.driver.manage().window().maximize();
   browser.driver.sleep(4000);
   browser.findElement(by.id('userId')).sendKeys("Aadithya");
   let v1= browser.findElement(by.buttonText('Register')).click();
   browser.driver.sleep(5000);
   expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
   browser.driver.sleep(5000);
   })

   it('Register User with Blank credentials', async()=> {
   browser.get("http://localhost:4200/register");
   browser.driver.manage().window().maximize();
   browser.driver.sleep(4000);
   browser.findElement(by.id('firstName')).sendKeys();
   browser.findElement(by.id('lastName')).sendKeys();
   browser.findElement(by.id('userId')).sendKeys();
   browser.findElement(by.id('password')).sendKeys();
   browser.findElement(by.buttonText('Register')).click();
   browser.driver.sleep(5000);
   expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
   browser.driver.sleep(5000);
   })

   //Defect --2
   it('Register user with invalid credentials', async()=> {
   browser.get("http://localhost:4200/register");
   browser.driver.manage().window().maximize();
   browser.driver.sleep(4000);
   browser.findElement(by.id('firstName')).sendKeys("Komal");
   browser.findElement(by.id('lastName')).sendKeys("venu");
   browser.findElement(by.id('userId')).sendKeys("KomalRaju");
   browser.findElement(by.id('password')).sendKeys("komal@123");
   let v1= browser.findElement(by.buttonText('Register')).click();
   browser.driver.sleep(5000);
   expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/register');
   browser.driver.sleep(5000);
   })

   it('Clear button test', async()=> {
   browser.get("http://localhost:4200/register");
   browser.driver.manage().window().maximize();
   browser.driver.sleep(4000);
   browser.findElement(by.id('firstName')).sendKeys("Jincy");
   browser.findElement(by.id('lastName')).sendKeys("AR");
   browser.findElement(by.id('userId')).sendKeys("808080");
   browser.findElement(by.id('password')).sendKeys("Jincy@123");
   browser.driver.sleep(4000);
   let v1= browser.findElement(by.buttonText('Clear')).click();
   browser.driver.sleep(5000);
   let v2= browser.findElement(by.buttonText('Register')).click();
   let val = browser.findElement(by.xpath("/html/body/div[2]")).getText();
   expect(val).toEqual('Field is empty or userid exists');
   browser.driver.sleep(5000);
   })

   it('Register User valid credentials', async()=> {
   browser.get("http://localhost:4200/register");
   browser.driver.manage().window().maximize();
   browser.driver.sleep(4000);
   browser.findElement(by.id('firstName')).sendKeys("Jincy");
   browser.findElement(by.id('lastName')).sendKeys("AR");
   browser.findElement(by.id('userId')).sendKeys("Abraham");
   browser.findElement(by.id('password')).sendKeys("jincy@123");
   browser.findElement(by.buttonText('Register')).click();
   browser.driver.sleep(5000);
   expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/login');
   browser.driver.sleep(5000);
  })
  })