package com.project.springbootcallenabledapp;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class SpringBootCallEnabledAppApplication implements ApplicationRunner {

	private final static String SID_ACCOUNT = "place your id here";
	private final static String AUTH_ID = "place your secured id here";
	private final static String FROM_NUMBER="twilio mobile num";
	private final static String TO_NUMBER =" Mobile number To whom you want make a voice call";

	static {
		Twilio.init(SID_ACCOUNT, AUTH_ID);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCallEnabledAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call.creator(new PhoneNumber("// the number you want to make a call"), new PhoneNumber("From"), // Your twilio Mobile number
				new URI("http://demo.twilio.com/docs/voice.xml")).create();

	}
}