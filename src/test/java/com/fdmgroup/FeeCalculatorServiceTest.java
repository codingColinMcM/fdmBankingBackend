package com.fdmgroup;

import static org.junit.Assert.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.junit.jupiter.*;

import com.fdmgroup.bankUserStories.service.*;

//@ExtendWith(MockitoExtension.class)
class FeeCalculatorServiceTest {
	
	FeeCalculatorServiceImplementation fCSI;

	@BeforeEach
	void setUp() {
		
		fCSI = new FeeCalculatorServiceImplementation();

	}
	

//	@SuppressWarnings("deprecation")
	@Test
	void testCalculateFee_ReturnTheSameBalanceThatIsPassedAsAnArguementToCaclulateFeeBecausesCasesForWritingFeesHaveNotBeenWrittenYet_WhenCalculateFeeIsCalled() {
		
		double expectedCalculation = 10000.0;
		double testedCalculation = fCSI.calculateFee(expectedCalculation);
		double marginOfError = 0.0; // assertEquals(double, double) is depreciated if it does not use this. 
		
		assertEquals(expectedCalculation, testedCalculation, marginOfError);
	}
	
	@Test
	void testCalculateFee_ReturnTheBalanceThatIsPassedAsAnArguementToCaclulateFeeMinusTwentyBecauseThisIsForACaseWhereTheBalanceIsLessThanOrEqualToOneHundredDollars_WhenCalculateFeeIsCalled() {
		double expectedCalculation = 80.0;
		double testedCalculation = fCSI.calculateFee(100.0);
		double marginOfError = 0.0;
		
		assertEquals(expectedCalculation, testedCalculation, marginOfError);
	}
	
	@Test
	void testCalculateFee_ReturnTheBalanceThatIsPassedAsAnArguementToCaclulateFeeMinusFifteenBecauseThisIsForACaseWhereTheBalanceIsLessThanOrEqualToFiveHundredDollarsAndGreaterThanOneHundredDollars_WhenCalculateFeeIsCalled() {
		double expectedCalculation = 385.0;
		double testedCalculation = fCSI.calculateFee(400.0);
		double marginOfError = 0.0;
		
		assertEquals(expectedCalculation, testedCalculation, marginOfError);
	}
	
	@Test
	void testCalculateFee_ReturnTheBalanceThatIsPassedAsAnArguementToCaclulateFeeMinusTenBecauseThisIsForACaseWhereTheBalanceIsLessThanOrEqualToOneThousandDollarsAndGreaterThanFiveHundredDollars_WhenCalculateFeeIsCalled() {
		double expectedCalculation = 890.0;
		double testedCalculation = fCSI.calculateFee(900.0);
		double marginOfError = 0.0;
		
		assertEquals(expectedCalculation, testedCalculation, marginOfError);
	}
	
	@Test
	void testCalculateFee_ReturnTheBalanceThatIsPassedAsAnArguementToCaclulateFeeMinusFiveBecauseThisIsForACaseWhereTheBalanceIsLessThanOrEqualToTwoThousandDollarsAndGreaterThanOneThousandDollars_WhenCalculateFeeIsCalled() {
		double expectedCalculation = 1495.0;
		double testedCalculation = fCSI.calculateFee(1500.0);
		double marginOfError = 0.0;
		
		assertEquals(expectedCalculation, testedCalculation, marginOfError);
	}
	
}
