class EncapsulationExample {
	public static void main(String[] args) {
		Car car1 = new Car();
		car.setName("Porsche Cayenne 4.8-litre V8");
		Car.setTopSpeed(278);

		System.out.println(car.getName());
		System.out.println(car.getTopSpeed());
	}
}
