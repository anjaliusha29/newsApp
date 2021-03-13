import { element } from "@angular/core/src/render3";
import { browser,by } from "protractor";

describe('Favourite List Page Testing',function(){

    it('To check the favourite list title',function(){
        browser.ignoreSynchronization=true;
        browser.get("http://localhost:4200/news/dashboard");
        browser.driver.sleep(4000); 
        browser.findElement(by.xpath("/html/body/app-root/mat-toolbar/span[2]/button[3]/span")).click();
        expect<any>(browser.getCurrentUrl()).toEqual('http://localhost:4200/news/favouritelist');
        browser.driver.sleep(4000); 
    })
    
})