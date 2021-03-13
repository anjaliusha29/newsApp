import { HttpResponse } from "@angular/common/http";
import { element } from "@angular/core/src/render3";
import { browser,by, Key } from "protractor";

describe('Search Page Testing',function(){


    it('To check search ',function(){ 
        
        browser.get("http://localhost:4200/news/search");
       let mySearch= browser.findElement(by.id("search-button-input"));
       browser.sleep(4000);
       mySearch.sendKeys("corona");
       browser.sleep(4000);

       mySearch.sendKeys(Key.ENTER);
       browser.sleep(4000);   

})

it('To check invalid search ',function(){ 
        
    browser.get("http://localhost:4200/news/search");
   let mySearch= browser.findElement(by.id("search-button-input"));
   browser.sleep(4000);
   mySearch.sendKeys();
   browser.sleep(4000);

   mySearch.sendKeys(Key.ENTER);
   browser.sleep(4000);
  
   browser.driver.switchTo().alert().accept();
   browser.sleep(4000);
   
})

})