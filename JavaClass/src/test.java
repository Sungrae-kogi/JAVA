import java.util.Arrays;
import java.util.Scanner;

class Polynomial{
	private Term[] termArray;
	private int terms;
	
	class Term{
		private double coef;
		private int exp;
	}
	
	Polynomial(int cap){
		termArray=new Term[cap];
		terms=0;
	}
	
	public void NewTerm(double theCoeff, int theExp) {
		if(terms==termArray.length) {
			termArray = Arrays.copyOf(termArray, termArray.length*2);
		}
		termArray[terms] = new Term();
		termArray[terms].coef = theCoeff;
		termArray[terms++].exp = theExp;
	}
	
	public Polynomial Add(Polynomial b) {
		Polynomial c = new Polynomial(128);
		int aPos=0, bPos=0;
		while((aPos<terms) && (bPos <b.terms)) {
			//
			if(termArray[aPos].exp == b.termArray[bPos].exp) {
				double t = termArray[aPos].coef + b.termArray[bPos].coef;
				if(t!=0.0)
					c.NewTerm(t, termArray[aPos].exp);
				aPos++; bPos++;
			}
			else if(termArray[aPos].exp < b.termArray[bPos].exp) {
				c.NewTerm(b.termArray[bPos].coef, b.termArray[bPos].exp);
				bPos++;
			}else {
				c.NewTerm(termArray[aPos].coef, termArray[aPos].exp);
				aPos++;
			}
		}
		//add in remaining temrs of *this
		for(; aPos < terms; aPos++)
			c.NewTerm(termArray[aPos].coef, termArray[aPos].exp);
		for(; bPos < b.terms; bPos++)
			c.NewTerm(b.termArray[bPos].coef, b.termArray[bPos].exp);
		return c;
	}
	//Subtract ���
	public Polynomial Subtract(Polynomial b) {
		Polynomial c = new Polynomial(128);
		int aPos=0, bPos=0;
		while((aPos<terms) && (bPos <b.terms)) {
			if(termArray[aPos].exp == b.termArray[bPos].exp) {	//aPos������ ��������  a�� b �Ѵ� ��������, ���� ����� ���ָ��
				double t = termArray[aPos].coef - b.termArray[bPos].coef;	//����� ���� ����
				if(t!=0.0)
					c.NewTerm(t,termArray[aPos].exp);
				aPos++; bPos++;
			}else if(termArray[aPos].exp < b.termArray[bPos].exp) {	//������ �ϴ� b���� ������ �� ū ��Ȳ ****
				c.NewTerm(-b.termArray[bPos].coef, b.termArray[bPos].exp);
				bPos++;
			}else {
				c.NewTerm(termArray[aPos].coef, termArray[aPos].exp);
				aPos++;
			}
		}
		//add in remaining terms of *this
		for(; aPos < terms; aPos++)
			c.NewTerm(termArray[aPos].coef, termArray[aPos].exp);
		for(; bPos < b.terms; bPos++)
			c.NewTerm(b.termArray[bPos].coef, b.termArray[bPos].exp);
		
		return c;
	}
	double Evaluate(double f) {
		double eval=0.0;
		int Pos=0;
		
		for(Pos=0; Pos<terms; Pos++) {
			eval+= termArray[Pos].coef*Math.pow(f, termArray[Pos].exp);
		}
		
		return eval;
	}
}

