package com.xgb.java.base.designpattern.factory.staticf;

public interface Car {
	
	public void driver();
	
	
}

class BaoMaCar implements Car{

	@Override
	public void driver() {
		System.out.println("driver BaoMaCar");
		
	}
	
}


class AoDiCar implements Car{

	@Override
	public void driver() {
		System.out.println("driver AoDiCar");
		
	}
	
}