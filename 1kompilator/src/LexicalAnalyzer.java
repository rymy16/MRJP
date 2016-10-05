import java.util.LinkedList;
import java.util.List;

import Lexems.*;
import interfaces.Lexem;


public class LexicalAnalyzer {
	List<Lexem> tokenize(String... lines) {
		List<Lexem> lexems = new LinkedList<Lexem>();
		String[] words = null;
		
		for(String line : lines) {
			words = line.split(" ");
			for (String word : words) {
				if (isNumber(word)) {
					lexems.add(new LConst(word));
				} else if (word.equals("=")) {
					lexems.add(new LEq());
				} else if (word.equals("+")) {
					lexems.add(new LPlus());
				} else if (word.equals("-")) {
					lexems.add(new LMinus());
				} else if (word.equals("*")) {
					lexems.add(new LStar());
				} else if (word.equals("/")) {
					lexems.add(new LSlash());
				} else if (word.equals("%")) {
					lexems.add(new LPercent());
				} else {
					lexems.add(new LIdent(word));
				}
			}
		}
		return lexems;
	}

	private boolean isNumber(String word) {
		if (word.matches("^-?\\d+$")) {
			return true;
		}
		return false;
	}
}
