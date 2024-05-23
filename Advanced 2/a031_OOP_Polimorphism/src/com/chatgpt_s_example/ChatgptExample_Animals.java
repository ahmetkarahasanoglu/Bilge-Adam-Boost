package com.chatgpt_s_example;


	class Animal {
	    public void makeSound() {
	        System.out.println("Some generic sound");
	    }
	}

	class Horse extends Animal {
	    @Override
	    public void makeSound() {
	        System.out.println("Neigh!");
	    }
	}

	class Cat extends Animal {
	    @Override
	    public void makeSound() {
	        System.out.println("Meow!");
	    }
	}

	class Dog extends Animal {
	    @Override
	    public void makeSound() {
	        System.out.println("Woof!");
	    }
	}

	
	

