package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test") //Indicates it's a test profile so will not run DataLoader
@SpringBootTest
public class WhiskyTrackerApplicationTests {
	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetAllWhiskiesOfAParticularYear(){
	 List<Whisky> foundWhiskies = whiskyRepository.findAllByYear(2018);
		assertEquals(6, foundWhiskies.size());
	}

	@Test
	public void canGetAllDistilleriesByRegion(){
		List<Distillery> foundDistillery = distilleryRepository.findAllDistilleryByRegion("Highland");
		assertEquals(3, foundDistillery.size());
	}

	@Test
	public void canGetAllWhiskyFromADistilleryThatIsASpecificAge(){

		Distillery particularDistillery = distilleryRepository.getById(1L);
		List<Whisky> foundWhiskiesOfAnAge = whiskyRepository.findByDistilleryIdAndAge(1L, 2018);
		assertEquals(2, foundWhiskiesOfAnAge.size());
	}

}
