package com.koo.framework;

import com.koo.utils.CommonUtils;

public class DebugTest {

	public static void main(String[] args) {
		String textVal ="Bill saved with the Bill No BLCS1050285 and Amount 800";
		
		String billingId = textVal.trim().split("Bill saved with the Bill No ")[1].split(" and Amount ")[0];
		String actualAmt = textVal.trim().split("Bill saved with the Bill No ")[1].split(" and Amount ")[1];
		actualAmt = actualAmt.split(".")[0];
		String totalAmt = actualAmt.split(".")[0];
		
		System.out.println("actualAmt:"+actualAmt);
		System.out.println("totalAmt:"+totalAmt);

	}

}
