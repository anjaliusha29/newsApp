import { element } from "@angular/core/src/render3";
import { browser,by } from "protractor";

describe('Dashboard Page Testing',function(){
    
it('To check the page title',function(){
    browser.ignoreSynchronization=true;
    browser.get("http://localhost:4200/news/dashboard").then(()=>(browser.getTitle())).then((title)=>(console.log(title)));
    browser.driver.sleep(4000); 
    expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/news/dashboard');
    browser.driver.sleep(4000); 
})

it('To check the favourite list title',function(){
    browser.ignoreSynchronization=true;
    browser.get("http://localhost:4200/news/dashboard");
    browser.driver.sleep(4000); 
    browser.findElement(by.xpath("/html/body/app-root/mat-toolbar/span[2]/button[3]/span")).click();
    expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/news/favouritelist');
    browser.driver.sleep(4000); 
})

it('To check the search list title',function(){
    browser.ignoreSynchronization=true;
    browser.get("http://localhost:4200/news/dashboard");
    browser.driver.sleep(4000); 
    browser.findElement(by.xpath("/html/body/app-root/mat-toolbar/span[2]/button[2]/span")).click();
    expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/news/search');
    browser.driver.sleep(4000); 
})
})