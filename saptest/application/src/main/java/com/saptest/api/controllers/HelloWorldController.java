package com.saptest.api.controllers;

import com.emoldino.openapi.ariba.api.OrdersApi;
import com.emoldino.openapi.ariba.model.OrderLineItems;
import com.sap.cloud.sdk.cloudplatform.connectivity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saptest.api.models.HelloWorldResponse;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);



//	customLoader = new DefaultDestinationLoader()
//        .registerDestination(customHttpDestination);


	//final HttpDestination destination = DestinationAccessor.getDestination("MyDestination").asHttp();
	final String X_ARIBA_NETWORK_ID = "AN02000000280";


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<HelloWorldResponse> getHello(@RequestParam(defaultValue = "world") final String name) {
		logger.info("I am running!");
		//Orders
		//OrdersApi

		DefaultHttpDestination customHttpDestination =
				DefaultHttpDestination.builder("https://sandbox.api.sap.com/ariba/api/purchase-orders/v1/sandbox")
						.name("custom-destination")
						.header(getHeader())
						.property("APIKey","4C9GS1yeuLKeRtPNdPGXEUp2rgA1buaM")
						.build();
		DefaultDestinationLoader defaultDestinationLoader = new DefaultDestinationLoader().registerDestination(customHttpDestination);

		DestinationAccessor.setLoader(defaultDestinationLoader);
		// This will now return the custom destination
		HttpDestination destination1 = DestinationAccessor.getDestination("custom-destination").asHttp();

		final OrdersApi service = new OrdersApi(destination1);
		final OrderLineItems result = service.getOrderItemsListUsingGET(X_ARIBA_NETWORK_ID);
		System.out.println(result);

		//service.getOrderHeaderListUsingGET(X_ARIBA_NETWORK_ID)
		return ResponseEntity.ok(new HelloWorldResponse(name));
	}

	private Header getHeader() {
		return new Header("APIKey","4C9GS1yeuLKeRtPNdPGXEUp2rgA1buaM");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/holi")
	public ResponseEntity<HelloWorldResponse> getHello2(@RequestParam(defaultValue = "world") final String name) {
		logger.info("I am running too!");

		return ResponseEntity.ok(new HelloWorldResponse(name));
	}

}
