package com.appspot.petroltracker.language;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class TestRequestAnaylzer {

	public static void main(String[] args) throws RecognitionException {
		CharStream charStream =  new ANTLRStringStream("Westlands,Oil Libya,petrol,99.2");
		RequestAnalyzerLexer lexer = new RequestAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		RequestAnalyzerParser parser = new RequestAnalyzerParser(tokenStream);
		parser.request();
		System.out.println("ok!");
	}

}
