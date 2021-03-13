import { AppPage } from './app.po';
import { browser, by, protractor, element } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display title', () => {
    page.navigateTo();
    expect(browser.getTitle()).toEqual('Newsapp');
    browser.sleep(5000);
  });

 

});
