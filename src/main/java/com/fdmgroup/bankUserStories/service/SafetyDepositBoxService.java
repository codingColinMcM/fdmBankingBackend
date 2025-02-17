package com.fdmgroup.bankUserStories.service;

import java.util.*;
import java.util.concurrent.locks.*;
import com.fdmgroup.bankUserStories.model.*;

public class SafetyDepositBoxService {
	
	private static SafetyDepositBoxService safetyDepositBoxService;
	private List<SafetyDepositBox> safetyDepositBoxes;
	private static int numberOfSafetyDepositBoxes;
	private final int MAX_SAFETY_DEPOSIT_BOXES;
	
	private SafetyDepositBoxService() {
		this.safetyDepositBoxes = new ArrayList<>();
		SafetyDepositBoxService.numberOfSafetyDepositBoxes = 0;
		MAX_SAFETY_DEPOSIT_BOXES = 2;
	}
	
	public static synchronized SafetyDepositBoxService getInstance() {
		
		if (SafetyDepositBoxService.safetyDepositBoxService == null) {
			SafetyDepositBoxService.safetyDepositBoxService =  new SafetyDepositBoxService();
		}
		
		return SafetyDepositBoxService.safetyDepositBoxService;
	}
	
	public static void setNumberOfSafetyDepositBoxes(int numberOfSafetyDepositBoxes) {
		SafetyDepositBoxService.numberOfSafetyDepositBoxes = numberOfSafetyDepositBoxes;
	}
	
	public static int getNumberOfSafetyDepositBoxes() {
		return SafetyDepositBoxService.numberOfSafetyDepositBoxes;
	}
	
	public synchronized SafetyDepositBox allocateSafetyDepositBox() {
		
		final Lock lock = new ReentrantLock();
		Optional<SafetyDepositBox> optionalSafetyDepositBox = getReleasedSafetyDepositBox();
		if(optionalSafetyDepositBox.isPresent()) {
			return optionalSafetyDepositBox.get();
		}
		else if (this.safetyDepositBoxes.size() < this.MAX_SAFETY_DEPOSIT_BOXES) {
			// This will need to be refactored in the future
			SafetyDepositBox safetyDepositBox = new SmallSafetyDepositBox();
			this.safetyDepositBoxes.add(safetyDepositBox);
			return safetyDepositBox;
		}
		else  {
			synchronized (lock) {
				try {
					while(this.safetyDepositBoxes.size() == this.MAX_SAFETY_DEPOSIT_BOXES) {
						wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return allocateSafetyDepositBox();
	}
	
	public synchronized void releaseSafetyDepositBox(SafetyDepositBox safetyDepositBox) {
		safetyDepositBox.setAllotted(false);
		notify();
 }
	
	public synchronized int getNumberOfAvailableSafetyDepositBoxes() {
		int numberOfAllottedSafetyDepositBoxes = 0;
		for (SafetyDepositBox safetyDepositBox : safetyDepositBoxes) {
			if (!safetyDepositBox.isAllotted()) {
				numberOfAllottedSafetyDepositBoxes++;
			}
		}
		return numberOfAllottedSafetyDepositBoxes;
	}
	
	public synchronized Optional<SafetyDepositBox> getReleasedSafetyDepositBox() {
		for (SafetyDepositBox safetyDepositBox : safetyDepositBoxes) {
			if (!safetyDepositBox.isAllotted()) {
				return Optional.ofNullable(safetyDepositBox);
			}
		}
		return Optional.empty();
	}
	
	public List<SafetyDepositBox> getSafetyDepositBoxes() {
		return this.safetyDepositBoxes;
	}

	public void setSafetyDepositBoxes(List<SafetyDepositBox> safetyDepositBoxes) {
		this.safetyDepositBoxes = safetyDepositBoxes;
	}

}
