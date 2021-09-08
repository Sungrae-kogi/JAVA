package DataStructure;

public class OptExp {

	
	/* 중위 표기식 -> 후위 표기식변경 과정
	 1) 왼쪽 괄호를 만나면 무시하고 다음 문자를 읽음
	 2) 피연산자를 만나면 그대로 출력
	 3) 연산자를 만나면 스택(Stack)에 추가
	 4) 오른쪽 괄호를 만나면 스택에서 연산자 pop
	 5) 수식이 끝나면 스택이 빌때까지 pop하여 출력
	*/
		private String exp;
		private int expSize;
		private char testCh, openPair;
		public boolean testPair(String exp) {
			this.exp = exp;
			LinkedStack S = new LinkedStack();
			expSize = this.exp.length();
			for(int i =0; i<expSize; i++) {
				testCh = this.exp.charAt(i);
				switch(testCh) {
				case '(':
				case '{':
				case '[':
					S.push(testCh);
					break;
				case ')':
				case '}':
				case ']':
					if(S.isEmpty()) {
						return false;
					}else {
						openPair = S.pop();
						if((openPair == '(' && testCh
							!= ')') ||
							(openPair == '{' && testCh
							!= '}') ||
							(openPair == '[' && testCh
							!= ']'))
							return false;
						else break;
					}
				}
			}
			
			if(S.isEmpty()) return true;
			else return false;
		}
		
		public char[] toPostfix(String infix) {
			char testCh;
			exp = infix;
			
			int expSize =10;
			int j=0;
			char postfix[] = new char[expSize];
			LinkedStack S = new LinkedStack();
			
			for(int i=0; i<=expSize; i++) {
				testCh = this.exp.charAt(i);
				switch(testCh) {
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					postfix[j++] = testCh; break;
					
				case '+':
				case '-':
				case '*':
				case '/':
					S.push(testCh); break;
					
				case ')':
					postfix[j++] = S.pop();
					break;
					
				default:
				}
			}
			
			postfix[j] = S.pop();
			return postfix;
		}
}



