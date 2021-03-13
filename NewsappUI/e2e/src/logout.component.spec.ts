import { element } from "@angular/core/src/render3";
import { browser,by } from "protractor";

describe('Logout Page Testing',function(){

    it('To check the Logout',function(){
        browser.ignoreSynchronization=true;
        browser.get("http://localhost:4200/news/dashboard").then(()=>(browser.getTitle())).then((title)=>(console.log(title)));
        browser.driver.sleep(4000); 
        browser.findElement(by.xpath("/html/body/app-root/mat-toolbar/span[3]/button")).click();
    expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/login');
    browser.driver.sleep(4000);  
    })
})