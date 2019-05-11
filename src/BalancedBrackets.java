import java.util.*;
/**
 * Determine whether an expression contains matching closing brackets.
 *
 */

public class BalancedBrackets {
	
	public static void main(String args[]) {
		String expression1 = "{[()]}"; //true
		String expression2 = "{[(])}"; //false
        
		if (isBalanced(expression1)) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}

	}
	
	
	public static boolean isBalanced(String expression) {
		
		//if not even length not balanced
		if (expression.length() % 2 != 0) {
			return false;
		}	
		
        HashMap<Character, Character> table = new HashMap<>();
        table.put(')', '(');
        table.put(']', '[');
        table.put('}', '{');
		
		char bracket;
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < expression.length(); i++) {
			bracket = expression.charAt(i);
			
			//if stack has elements and
			//the last bracket correspond to current bracket
			if (!stack.isEmpty() && table.get(bracket) == stack.peek()) {
				stack.pop();
			}else { 
				stack.push(bracket);
			}
			 
		}

		if (stack.isEmpty()) {
			return true;
		}else { 
			return false; //end of string, should not hit theoretically
		}
		
	}
}
