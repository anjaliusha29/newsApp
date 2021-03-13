package com.stackroute.favouriteservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.favouriteservice.exception.NewsAlreadyExistsException;
import com.stackroute.favouriteservice.exception.NewsNotFoundException;
import com.stackroute.favouriteservice.model.News;
import com.stackroute.favouriteservice.repository.NewsRepository;
import com.stackroute.favouriteservice.services.NewsServiceImpl;

public class NewsServiceImplTest {
	
	@Mock
	private transient NewsRepository newsRepo;
	@InjectMocks
	private NewsServiceImpl newsManagerServiceImpl;
	@Autowired
	private MockMvc mockMvc;
	transient Optional<News> options;

	@Test
	public void getAllNewsTest() {
		final List<News> newsList = new ArrayList<>(1);
		when(newsRepo.findAll()).thenReturn(newsList);
		final List<News> newList = newsManagerServiceImpl.getMyNews("amalRam");		
		assertEquals(newList, newsList);
		
	}

	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		mockMvc= MockMvcBuilders.standaloneSetup(newsManagerServiceImpl).build();

	}
	
	@Test
	public void deleteNewsByIdTest() throws NewsNotFoundException {
		

		//News news = new News();
		News news = Mockito.mock(News.class);
		news.setPublishedAt("2021-01-25T12:00:00Z");
		news.setContent("Thanks to Twitter, you can now watch a doctors heart break in real time. Like everyone else, weve often made our feelings plain during the pandemicour despondence over all the deaths, our anger over …");
		news.setTitle("Stop Ignoring the Evidence on Covid-19 Treatments");
		news.setId(1);
		news.setUrlToImage("https://media.wired.com/photos/600b7a50d721ab7365e3b9a7/191:100/w_1280,c_limit/ideas-plasma.jpg");
		news.setUrl("https://www.wired.com/story/stop-ignoring-the-evidence-on-covid-19-treatments/");

		options=Optional.of(news);
		when(newsRepo.findById(1)).thenReturn(options);
		
		doNothing().when(newsRepo).delete(news);
		final boolean flag = newsManagerServiceImpl.deleteNewsById(1);
		assertTrue(flag);
	}
		@Test
		public void saveNewsTest() throws NewsAlreadyExistsException {
			
	//	News news = new News();
		News news = Mockito.mock(News.class);
		news.setPublishedAt("2021-01-25T12:00:00Z");
		news.setContent("Thanks to Twitter, you can now watch a doctors heart break in real time. Like everyone else, weve often made our feelings plain during the pandemicour despondence over all the deaths, our anger over …");
		news.setTitle("Stop Ignoring the Evidence on Covid-19 Treatments");
		news.setId(1);
		news.setUrlToImage("https://media.wired.com/photos/600b7a50d721ab7365e3b9a7/191:100/w_1280,c_limit/ideas-plasma.jpg");
		news.setUrl("https://www.wired.com/story/stop-ignoring-the-evidence-on-covid-19-treatments/");
		newsManagerServiceImpl.saveNews(news);
		
		when(newsRepo.save(news)).thenReturn(news);
		final boolean flag = newsManagerServiceImpl.saveNews(news);
		assertTrue(flag);
	
	}
		
		@Test(expected = NewsNotFoundException.class)
		public void deleteNewsByIdFailTest() throws NewsNotFoundException {
			
						
			when(newsRepo.findByUserId("Jhon123")).thenReturn(null);
			boolean status = newsManagerServiceImpl.deleteNewsById(1);
			assertEquals(false, status);
			
		}
		
}