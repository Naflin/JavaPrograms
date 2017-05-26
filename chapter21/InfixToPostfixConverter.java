/*************************************************************\
|    Program: InfixToPostfixConverter.java                    |
|     Author: Nathan Blue                                     |
|   Due Date: 4/25/17                                         |
| Assignment: Chapter 20/21 Program                           |
|    Purpose: The creation of Infix To Postfix Converter      |
|             Algorithm.                                      |
\*************************************************************/

import java.util.Stack;
import java.lang.StringBuffer;

public class InfixToPostfixConverter
{
	private StringBuffer postfix;
	private Stack<Character> stack;

	public InfixToPostfixConverter()
	{
		stack = new Stack<>();
		postfix = new StringBuffer();
	}

	public StringBuffer convertToPostfix(StringBuffer infix)
		{
			stack.push('(');
			infix.append(')');

			for(int i = 0; i < infix.length(); i++)
			{
				if(Character.isDigit(infix.charAt(i)))
				{
					postfix.append(infix.charAt(i));
					continue;
				}
				if(infix.charAt(i) == '(')
				{
					stack.push(infix.charAt(i));
					continue;
				}
				if(infix.charAt(i) == ')')
				{
					while(!stack.isEmpty() && stack.peek() != '(')
						postfix.append(stack.pop());

					if(!stack.isEmpty())
						stack.pop();
					continue;
				}
				if(isOperator(infix.charAt(i)))
				{
					while(isOperator(stack.peek()) && precedence(infix.charAt(i), stack.peek()))
						postfix.append(stack.pop());
					stack.push(infix.charAt(i));
					continue;
				}
			}

			while(!stack.empty())
			{
				char temp = stack.pop();
				if(temp != ')' && temp != '(')
					postfix.append(temp);
			}

			return postfix;
	}

	public boolean precedence(char c1, char c2)
	{
		int p1 = getPriority(c1);
		int p2 = getPriority(c2);

		if(p1 == 0 || p2 == 0)
			return false;

		if(p1 <= p2)
			return true;
		return false;
	}

	public int getPriority(char c)
	{
		switch(c)
		{
			case '+':
			case '-': return 1;
			case '*':
			case '/': return 2;
			case '^':
			case '%': return 3;
			default: return 0;
		}
	}

	public boolean isOperator(char c)
	{
		switch(c)
		{
			case '+':
			case '-':
			case '*':
			case '/':
			case '^':
			case '%': return true;
			default: return false;
		}
	}

	public boolean isValidExpression(StringBuffer infix)
	{
		for(int i = 0; i < infix.length(); i++)
		{
			if(!isOperator(infix.charAt(i)) &&
				!Character.isDigit(infix.charAt(i)) &&
				infix.charAt(i) != ')' &&
				infix.charAt(i) != '(')
				return false;

			if(i < infix.length() - 1)
				if(Character.isDigit(infix.charAt(i)) &&
					Character.isDigit(infix.charAt(i+1)))
					return false;

			if(i < infix.length() - 1)
				if(isOperator(infix.charAt(i)) &&
					isOperator(infix.charAt(i+1)))
					return false;
		}

		return true;
	}
}


