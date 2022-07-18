package com.saptest.api;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

//
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestination;

public class UnitTest {

	//
	final HttpDestination destination = DestinationAccessor.getDestination("MyDestination").asHttp();
	final String X_ARIBA_NETWORK_ID = "mfINP9SKbSo9u0xy8h76UKyctfzJY1kO";
//	final OrdersApi service = new OrdersApi(destination);
//	final OrderLineItems result = service.getOrderItemsListUsingGET(X_ARIBA_NETWORK_ID);

	@Test
	public void test() {
		assertTrue(true);
	}

	@Test
	public void 서비스_콜() {
		//destination.getKeyStorePassword()
		
		final HttpDestination destination = DestinationAccessor.getDestination("MyDestination").asHttp();
		final String X_ARIBA_NETWORK_ID = "mfINP9SKbSo9u0xy8h76UKyctfzJY1kO";
	}
}
