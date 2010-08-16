//
// Copyright 2010 Saidimu Apale
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package com.appspot.petroltracker.language;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

public class TestRequestAnaylzer {

	public static void main(String[] args) throws RecognitionException {
		CharStream charStream =  new ANTLRStringStream("Westlands,Oil Libya,petrol,99.2");
//		CharStream charStream =  new ANTLRStringStream("Westlands, diesel");
		RequestAnalyzerLexer lexer = new RequestAnalyzerLexer(charStream);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		RequestAnalyzerParser parser = new RequestAnalyzerParser(tokenStream);
		parser.request();
//		System.out.println("ok!");
	}

}
