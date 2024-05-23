package com.ahmet;

import java.util.Stack;

/*
 * We will check if a text is palindrome or not 
 * by using stack.
 */
public class PalindromStack_myCode {

	public static void main(String[] args) {
		
		String text = "kabak";
		
		Stack<String> stack = new Stack<>();
		
		for(int i=0; i<text.length(); i++) {
			stack.push((text.charAt(i) + "").toLowerCase());
		}		
		Stack<String> stackCopy = new Stack<>(); // making a copy of the stack
		for(int i=0; i<stack.size(); i++) {
			stackCopy.push(stack.get(i));
		}
		
		Stack<String> stackReverse = new Stack<>(); // making the reverse stack
		while(!stackCopy.isEmpty()) {
			stackReverse.push(stackCopy.pop());
		}
		
		boolean isPalindrome = true;
		for(int i=0; i<stack.size()/2; i++) {  // checking if palindrome
			if(!stack.get(i).equals(stackReverse.get(i))) {
				isPalindrome = false;
				break;
			}
		}
		System.out.println("Is the text palindrome: " + isPalindrome);
		
	}
	
	
}
