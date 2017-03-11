package com.pelayolluna.ddosAttacker.test;

import com.pelayolluna.ddosAttacker.core.MultiRequester;

public class ApplicationTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new MultiRequester().start("http://pelayolluna.com");
	}

}
