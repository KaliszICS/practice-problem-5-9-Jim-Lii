/*
Lesson: Queues and stacks
Author: Jim Li
Date Created: May 8, 2026
Date Last Modified: May 8, 2026
 */

import java.util.ArrayDeque;
public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static String processBackspaces(String word){
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < word.length(); i++){
			if (word.charAt(i) == '#' && !stack.isEmpty()){
				stack.pop();
			} else {
				stack.push(word.charAt(i));
			}
		}
		String newWord = "";
		while (!stack.isEmpty()){
			newWord = stack.pop() + newWord;
		}
		return newWord;
	}

	public static String simulateLine(String[] commands){
		ArrayDeque<String> line = new ArrayDeque<>();
		for (int i = 0; i < commands.length; i++){
			if (commands[i].startsWith("ENQUEUE ")){
				String name = commands[i].substring(commands[i].indexOf(" ") + 1);
				line.addLast(name);
			}
			else if (commands[i].startsWith("VIP ")){
				String name = commands[i].substring(commands[i].indexOf(" ") + 1);
				line.addFirst(name);
			}
			else if (commands[i].equals("SERVE") && !line.isEmpty()){
				line.removeFirst();
			}
			else if (commands[i].equals("REQUEUE") && !line.isEmpty()){
				line.addLast(line.removeFirst());
			}
			else if (commands[i].equals("SCARE") && !line.isEmpty()){
				line.removeLast();
			}
		}
		String newLine = "[";
		while (!line.isEmpty()){
			newLine += line.removeFirst();
			if (!line.isEmpty()){
				newLine += ", ";
			}
		}
		newLine += "]";
		return newLine;
	}

}
