package com.ssa.coding;

public class Coding9 {
	public static void main(String[] args) throws Exception {
		System.out.println(power(3.0,7));
		System.out.println(1.0/9);
	}

	public static double power(double base, int exponent) throws Exception {
		if(equal(base, 0.0) && (exponent<0)){
			throw new Exception("0的负数次幂没有意义");
		}
		double result = 1.0;
		if(exponent<0) {
			result = 1/(powerWithExponent2(base, -exponent));
		} else {
			result = powerWithExponent2(base, exponent);
		}
		
		return result;
	}

	public static double powerWithExponent(double base, int exponent) {
		// 0的0次方没有意义，此处输出1
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		double result = 1.0;
		for (int i = 1; i <= exponent; i++) {
			result = result * base;
		}

		return result;
	}

	public static double powerWithExponent2(double base, int exponent) {
		if(0==exponent) {
			return 1;
		}
		if(1==exponent) {
			return base;
		}
		double result = powerWithExponent2(base, exponent>>1);
		result *=result;
		if((exponent & 0x1) == 1) {
			result = result * base;
		}
		
		return result;
	}
	
	public static boolean equal(double num1, double num2) {
		if ((num1 - num2 > -10e-7) && (num1 - num2 < 10e-7)) {
			return true;
		} else {
			return false;
		}
	}
}
