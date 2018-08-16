package com.xgb.java.base.designpattern.factory.staticf;

public class StaticFactory {

	public static Car getName(String name) {
		if("baoma".equals(name)) {
			return new BaoMaCar();
		}
		else if("aodi".equals(name)) {
			return new AoDiCar();
		}
		else {
			return null;
		}
	}
	
	
	public static void main(String[] args) {
		
		Car car1 = StaticFactory.getName("baoma");
		car1.driver();
		
		Car car2 = StaticFactory.getName("aodi");
		car2.driver();
	}
}
