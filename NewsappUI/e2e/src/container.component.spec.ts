//import { element } from "@angular/core/src/render3";
import { browser,by, protractor, element } from "protractor";
describe('Container Page Testing',function(){

    it('To check Favourite List has become Empty',function(){
        browser.get("http://localhost:4200/news/dashboard");
        browser.driver.sleep(2000);  
        browser.element(by.xpath('//*[@id="favoritePage"]')).click();
        browser.driver.sleep(1000); 
      
      let val=browser.findElement(by.xpath("/html/body/div[1]")).getText();
      expect(val).toEqual('Favourite List is Empty');    
    })

it('To check add to my article',function(){
    browser.get("http://localhost:4200/news/dashboard");
    browser.driver.sleep(4000);  
    let btn = browser.element(by.xpath("/html/body/app-root/app-dashboard/app-container/div/app-thumbnail[2]/mat-card/mat-card-actions/button/span")).click();
    browser.driver.sleep(2000); 
    let val=browser.findElement(by.xpath("/html/body/div[1]")).getText();
    browser.driver.sleep(4000); 
    expect(val).toEqual('Article added to watchlist');

})

it('To check add to my article2',function(){
    browser.get("http://localhost:4200/news/dashboard");
 
    browser.driver.sleep(4000);  
    let btn = browser.element(by.xpath("/html/body/app-root/app-dashboard/app-container/div/app-thumbnail[2]/mat-card/mat-card-actions/button/span")).click();
    browser.driver.sleep(2000);  
    let val=browser.findElement(by.xpath("/html/body/div[1]")).getText();

    browser.driver.sleep(4000); 
    expect(val).toEqual('Article added to watchlist');
})

it('To check delete from my article',function(){
    browser.get("http://localhost:4200/news/favouritelist");
    browser.driver.sleep(4000);  
    let btn = browser.element(by.xpath("/html/body/app-root/app-favouritelist/app-container/div/app-thumbnail[1]/mat-card/mat-card-actions/button/span")).click();
    browser.driver.sleep(1000); 
  
    let val=browser.findElement(by.xpath("/html/body/div[1]")).getText();
    expect(val).toEqual('Article deleted from your watchlist');
    
    browser.driver.sleep(2000); 

})

})