package com.fdmgroup;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.*;

import org.junit.jupiter.api.*;
import org.mockito.*;

import com.fdmgroup.bankUserStories.model.*;
import com.fdmgroup.bankUserStories.service.*;

class SafetyDepositBoxServiceTest {
	
	SafetyDepositBoxService safetyDepositBoxService;
	List<SafetyDepositBox> safetyDepositBoxes;
//	Thread thread1;
//	Thread thread2;
//	Thread thread3;
	Runnable runnable;
	@Mock
	SafetyDepositBox mockSafetyDepositBox;

	@BeforeEach
	void setUp() throws Exception {
		safetyDepositBoxService = SafetyDepositBoxService.getInstance();
		mockSafetyDepositBox = mock(SafetyDepositBox.class);
		safetyDepositBoxes = new ArrayList<>();
		safetyDepositBoxes.add(mockSafetyDepositBox);
		safetyDepositBoxService.setSafetyDepositBoxes(safetyDepositBoxes);
		when(mockSafetyDepositBox.isAllotted()).thenReturn(true);
//	    thread1 = new Thread(runnable);
//	    thread2 = new Thread(runnable);
//	    thread3 = new Thread(runnable);
	}

	@Test
	void testSafetyDepositBoxServiceSingltonBeingCreated_ReturnTheSinglgetonOfSafetyDepositBoxService_WhenGetInstanceIsCalled() {
		assertNotNull(safetyDepositBoxService);
	}
	
//	@Test
//	void testGetReleasedSafetyDepositBox_ReturnAnAvailableSafetyDepositBox_WhenGetReleasedSafetyDepositBoxIsCalled() {
//		assertEquals(Optional.ofNullable(mockSafetyDepositBox), safetyDepositBoxService.getReleasedSafetyDepositBox());
//	}
	
//	@Test
//	void testAllocateSafetyDepositBox_ReturnAnAvailableSafetyDepositBox_WhenAllocateSafetyDepositBoxIsCalled() {
//		assertEquals(mockSafetyDepositBox, safetyDepositBoxService.allocateSafetyDepositBox());
//	}
	
//	@Test
//	void testAllocateSafetyDepositBox_ReturnANewAvailableSafetyDepositBoxBecauseTheOldOneIsNotAllotted_WhenAllocateSafetyDepositBoxIsCalled() {
//		when(mockSafetyDepositBox.isAllotted()).thenReturn(false);
//		SafetyDepositBox safetyDepositBox = safetyDepositBoxService.allocateSafetyDepositBox();
//		assertEquals(safetyDepositBoxService.getSafetyDepositBoxes().get(1), safetyDepositBox);
//	}
//	
	@Test
	void testTwoThreadsRequestSafetyDepositBox_ExpectedResultIsThatNoThreadWaits() throws InterruptedException {
	    safetyDepositBoxService.setSafetyDepositBoxes(new ArrayList<>()); 

	    Thread thread1 = new Thread(new Runnable(){
	        SafetyDepositBox safetyDepositBox = safetyDepositBoxService.allocateSafetyDepositBox();
			@Override
			public void run() {
				try {
		            Thread.sleep(5000); 
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        } finally {
		            safetyDepositBoxService.releaseSafetyDepositBox(safetyDepositBox);
		        }
			}
	    });

	    Thread thread2 = new Thread(new Runnable(){
	        SafetyDepositBox safetyDepositBox = safetyDepositBoxService.allocateSafetyDepositBox();
			@Override
			public void run() {
				try {
		            Thread.sleep(5000); 
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        } finally {
		            safetyDepositBoxService.releaseSafetyDepositBox(safetyDepositBox);
		        }
			}
	    });

	    long startTime = System.currentTimeMillis();

	    thread1.start();
	    thread2.start();

	    thread1.join();
	    thread2.join();

	    long endTime = System.currentTimeMillis();
	    System.out.println(startTime);
	    System.out.println(endTime);
	    System.out.println(endTime - startTime);
	    assertTrue((endTime - startTime) < 6000);
	}


	@Test
	void testThreeThreadsRequestSafetyDepositBox_ExpectedResultIsEachThreadWaitsOneAtATime() throws InterruptedException {	    
	    Runnable runnable = new Runnable(){
	        SafetyDepositBox safetyDepositBox = safetyDepositBoxService.allocateSafetyDepositBox();
			@Override
			public void run() {
				safetyDepositBoxService.releaseSafetyDepositBox(safetyDepositBox);
			}
	    };

	    Thread thread1 = new Thread(runnable);
	    Thread thread2 = new Thread(runnable);
	    Thread thread3 = new Thread(runnable);

	    long startTime = System.currentTimeMillis();

	    thread1.start();
	    thread2.start();
	    thread3.start();
	    
	    thread1.sleep(5000);
	    thread2.sleep(5000);
	    thread3.sleep(5000);

	    thread1.join();
	    thread2.join();
	    thread3.join();

	    long endTime = System.currentTimeMillis();
	    System.out.println(startTime);
	    System.out.println(endTime);
	    System.out.println(endTime - startTime);
	    assertTrue((endTime - startTime) > 10000);
	}
	
}
