package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {
		if(s1.length() > s2.length()) {
			return s1;
		}
		else if(s2.length() > s1.length()) {
			return s2;
		}
		else {
			return s1;
		}
	}

	
	// if String s contains the word "underscores", change all of the spaces to underscores
	public static String formatSpaces(String s) {
		String boi = "";
		if(s.contains("underscores")) {
			boi = s.replace(' ', '_');
			return boi;
		}
		return s;
	}

	
	// Return the name of the person whose LAST name would appear first if they were in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		char ln1 = ' ';
		char ln2 = ' ';
		char ln3 = ' ';
		for(int i = 2; i < s1.length(); i++) {
			if(s1.charAt(i) == ' ') {
				ln1 = s1.charAt(i+1);
				break;
			}
		}
		for(int i = 2; i < s2.length(); i++) {
			if(s2.charAt(i) == ' ') {
				ln2 = s2.charAt(i+1);
				break;
			}
		}
		for(int i = 2; i < s3.length(); i++) {
			if(s3.charAt(i) == ' ') {
				ln3 = s3.charAt(i+1);
				break;
			}
		}
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i = 0; i < alphabet.length()-1; i++) {
			if(alphabet.charAt(i) == ln1) {
				return s1;
			}
			else if(alphabet.charAt(i) == ln2) {
				return s2;
			}
			else if(alphabet.charAt(i) == ln3) {
				return s3;
			}
		}
		return null;
	}
	
	
	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int collector = 0;
		String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		for(int i = 0; i < s.length(); i++) {
			for(int j = 0; j < numbers.length; j++) {
			if(s.charAt(i) == numbers[j].charAt(0)) {
				collector += Integer.parseInt(numbers[j]);
			}
			}
		}
		return collector;
	}
	
	
	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int returner = 0;
		//System.out.println(substring);
		for(int i = 0; i < s.length(); i++) {
			if(substring.length()+i-1 < s.length()) {
				String checker = s.substring(i, substring.length()+i);
				//System.out.println(substring);
				if(checker.equals(substring)) {
					//i+=substring.length();
					returner++;
				}
			}
		}
		return returner;
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		Utilities.encrypt(s.getBytes(), (byte)key);
		return Utilities.encrypt(s.getBytes(), (byte)key);
	}

	// Call Utilities.decrypt to decrypt the cyphertext
	public static String decrypt(String s, char key) {
		Utilities.decrypt(s, (byte)key);
		return Utilities.decrypt(s, (byte)key);
	}


	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int returner = 0;
		for(int i = 0; i < s.length(); i++) {
			if(substring.length()+i < s.length()) {
				String checker = s.substring(i, substring.length()+i+1);
				if(checker.equals(substring + " ")) {
					returner++;
				}
			}
		}
		return returner;
	}
	

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		int first = 0;
		int second = 0;
		boolean check = false;
		for(int i = 0; i < s.length();i++) {
			if(substring.length()+i+1 < s.length()) {
				if(s.substring(i,  i+substring.length()).equals(substring) ){
					if(!check) {
						first = substring.length()+i;
						check = true;
					}
					else{
						second = substring.length()+i;
					}
				}
			}
		}
		int returner = second-first;
		return returner;
	}


	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		boolean checker = true;
		String newStr = "";
		
		for(int l = 0; l < s.length(); l++) {
			if(Character.isLetter(s.charAt(l))) {
				newStr+= s.charAt(l);
			}
			else {
				
			}
		}
		newStr = newStr.toLowerCase();
		System.out.println(newStr);
	for(int i = 0; i < newStr.length(); i++) {
		for(int j = newStr.length(); j > 0; j--) {
			System.out.println(newStr.charAt(i));
			System.out.println(newStr.charAt(j-1));
			if(newStr.charAt(i) == newStr.charAt(j-1)) {
				System.out.println("bababooey");
				i++;
			}
			else {
				System.out.println("nightmare");
				return false;
			}
		}
	}
	return true;
	}
	
}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
