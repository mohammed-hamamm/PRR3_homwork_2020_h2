/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hemwork_Q3;

/**
 *
 * @author Extreme
 */
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
public class Q3 {
   public static void main(String[] args) {

	List<String> names = Arrays.asList("Melisandre","Sansa","Jon","Daenerys","Joffery");
		
	//Creating the stream of all names
	Stream<String> allNames = names.stream();
		
	//Creating another stream by filtering long names using filter()
	Stream<String> longNames = allNames.filter(str -> str.length() > 6);
		
	//displaying the long names
	longNames.forEach(str->System.out.print(str+" "));
  }
}