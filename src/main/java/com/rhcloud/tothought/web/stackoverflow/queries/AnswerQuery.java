package com.rhcloud.tothought.web.stackoverflow.queries;

public class AnswerQuery extends AbstractQuery {

//	final static String FILTER = "!*0reXVBL(FFx3LJB01c";
	final static String FILTER = "!5(g5q*eQD-CEaDxg";
	public AnswerQuery(String userId){
		super.buildBase(userId).setSite("stackoverflow").setMethod("answers")
		.addParameter("filter", FILTER);
	}
}
