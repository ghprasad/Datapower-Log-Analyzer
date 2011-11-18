package DatapowerSource;

import java.util.ArrayList;

public class Query {
   public ArrayList<Expression> expressionList;
   String file;
   
   public Query(){
	   expressionList = new ArrayList<Expression>();
   }

public String getFile() {
	return file;
}

public void setFile(String file) {
	this.file = file;
}

public ArrayList<Expression> getExpressionList() {
	return expressionList;
}

public void setExpressionList(ArrayList<Expression> expressionList) {
	this.expressionList = expressionList;
}
	
   
}
