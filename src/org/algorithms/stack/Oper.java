package org.algorithms.stack;

import java.security.InvalidParameterException;

public enum Oper {

	ADD {
		@Override
		public String toString() {
			return "+";
		}

		@Override
		public int compare(Oper other) {
			if(other==MULTI||other==DIV)
				return -1;
			if(other==LBRACKETS)
				return -1;
			return 1;
		}

		@Override
		public int calculate(int opnd1, int opnd2) {
			return opnd1+opnd2;
		}
		
	},MINUS {
		@Override
		public String toString() {
			return "-";
		}
		
		@Override
		public int compare(Oper other) {
			if(other==MULTI||other==DIV)
				return -1;
			if(other==LBRACKETS)
				return -1;
			return 1;
		}
		@Override
		public int calculate(int opnd1, int opnd2) {
			return opnd1-opnd2;
		}
	},MULTI {
	
		@Override
		public String toString() {
			return "*";
		}
		@Override
		public int compare(Oper other) {
			if(other==LBRACKETS)
				return -1;
			return 1;
		}
		@Override
		public int calculate(int opnd1, int opnd2) {
			return opnd1*opnd2;
		}
	},DIV {
		@Override
		public String toString() {
			return "/";
		}
		@Override
		public int compare(Oper other) {
			if(other==LBRACKETS)
				return -1;
			return 1;
		}
		@Override
		public int calculate(int opnd1, int opnd2) {
			if(opnd2==0)
				throw new InvalidParameterException("opnd2 is not permit equal 0");
			return opnd1/opnd2;
		}
	},LBRACKETS {
		@Override
		public String toString() {
			return "(";
		}
		@Override
		public int compare(Oper other) {
			if(other==RBRACKETS)
				return 0;
			return -1;
		}
		@Override
		public int calculate(int opnd1, int opnd2) {
			throw new UnsupportedOperationException();
		}
	},RBRACKETS {
		@Override
		public String toString() {
			return ")";
		}
		@Override
		public int compare(Oper other) {
			if(other==LBRACKETS)
				return 0;
			return 1;
		}
		@Override
		public int calculate(int opnd1, int opnd2) {
			throw new UnsupportedOperationException();
		}
	};
	public abstract int calculate(int opnd1, int opnd2);
	public abstract String toString();
	public abstract int compare(Oper otherOper);
}
