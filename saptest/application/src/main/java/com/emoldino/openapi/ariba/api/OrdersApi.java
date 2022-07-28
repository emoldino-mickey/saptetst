

package com.emoldino.openapi.ariba.api;

import com.sap.cloud.sdk.services.openapi.core.OpenApiRequestException;
import com.sap.cloud.sdk.services.openapi.core.OpenApiResponse;
import com.sap.cloud.sdk.services.openapi.core.AbstractOpenApiService;
import com.sap.cloud.sdk.services.openapi.apiclient.ApiClient;

import com.emoldino.openapi.ariba.model.BadRequest ; //NOPMD
import com.emoldino.openapi.ariba.model.Forbidden ; //NOPMD
import com.emoldino.openapi.ariba.model.NotFound ; //NOPMD
import com.emoldino.openapi.ariba.model.OrderHeaders ; //NOPMD
import com.emoldino.openapi.ariba.model.OrderLineItems ; //NOPMD
import com.emoldino.openapi.ariba.model.Unauthorized ; //NOPMD

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.google.common.annotations.Beta;

import com.sap.cloud.sdk.cloudplatform.connectivity.HttpDestinationProperties;

/**
* Ariba Network Purchase Orders Buyer API in version 1.0.0.
*
* The Purchase Order API enables you to retrieve purchase order header and item details from the Ariba Network.
*/
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")

public class OrdersApi extends AbstractOpenApiService {
    /**
    * Instantiates this API class to invoke operations on the Ariba Network Purchase Orders Buyer API.
    *
    * @param httpDestination The destination that API should be used with
    */
    public OrdersApi( @Nonnull final HttpDestinationProperties httpDestination )
    {
        super(httpDestination);
    }

    /**
    * Instantiates this API class to invoke operations on the Ariba Network Purchase Orders Buyer API based on a given {@link ApiClient}.
    *
    * @param apiClient
    *            ApiClient to invoke the API on
    */
    @Beta
    public OrdersApi( @Nonnull final ApiClient apiClient )
    {
         super(apiClient);
    }

    
    /**
     * <p>Retrieves purchase-order header information.</p>
     *<p>Retrieves header information in purchase orders for a specified buyer.  Information can be further refined by filters, such as limiting data to a certain supplier and order ID.</p>
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param X_ARIBA_NETWORK_ID  (required)
        The buyer&#39;s ANID.
     * @param $filter  (optional)
        $filter&#x3D;_expression_. The value of _expression_ is a combination of a resource parameter and its value. The &#39;eq&#39; operator to links the parameter and value. The&#39;and&#39; operator links two or more parameter-value pairs. For example, $filter&#x3D;a eq &#39;b&#39; and c eq &#39;d&#39;. This feature supports the following parameters:&lt;br/&gt; buyerANID         -- The buyer&#39;s ANID. &lt;br/&gt; documentNumber       -- Same as the orderID. The identifier for this order, similar to the purchase order number. &lt;br/&gt; orderStatus          -- Indicates what state of processing the order has reached. &lt;br/&gt; routingStatus        -- Indicates whether a purchase order or service order is queued, sent, acknowledged, or if routing failed.&lt;br/&gt; startDate            -- The starting date of the period in which Ariba Network received the order. The maximum date range is 31 days.&lt;br/&gt; endDate              -- The ending date of the period in which Ariba Network received the order. The maximum date range is 31 days.&lt;br/&gt; 
     * @param $orderby  (optional)
        Specifies the sort order of results. You need to provide the parameter buyerANID into $filter when using $orderby. For example, &#39;$orderby&#x3D;_propertyName_ asc&#39;.&lt;br/&gt; The order can be either ascending or descending: asc or desc. If $orderby is not specified, results are sorted in ascending order by default.&lt;br/&gt; _propertyName_  -- The column name to sort by. This is either  BUYERORGID or SUPPLIERORGID. &lt;br/&gt; 
     * @param $skip  (optional)
        Specifies the number of items to skip (offset).
     * @param $top  (optional)
        Specifies the number of items to return (page size).
     * @param $count  (optional)
        Returns the number of elements in a collection inline. The syntax is $count&#x3D;true.&lt;br/&gt; 
     * @return OrderHeaders
     * @throws OpenApiRequestException if an error occurs while attempting to invoke the API
     */
    @Nullable  public OrderHeaders getOrderHeaderListUsingGET( @Nonnull final String X_ARIBA_NETWORK_ID,  @Nullable final String $filter,  @Nullable final String $orderby,  @Nullable final Integer $skip,  @Nullable final Integer $top,  @Nullable final String $count) throws OpenApiRequestException {
        final Object postBody = null;
        
        // verify the required parameter 'X_ARIBA_NETWORK_ID' is set
        if (X_ARIBA_NETWORK_ID == null) {
            throw new OpenApiRequestException("Missing the required parameter 'X_ARIBA_NETWORK_ID' when calling getOrderHeaderListUsingGET");
        }
        
        final String path = UriComponentsBuilder.fromPath("/orders").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", $filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$orderby", $orderby));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", $skip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", $top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$count", $count));

        if (X_ARIBA_NETWORK_ID != null)
        headerParams.add("X-ARIBA-NETWORK-ID", apiClient.parameterToString(X_ARIBA_NETWORK_ID));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        final String[] authNames = new String[] { "OAuth2" };

        final ParameterizedTypeReference<OrderHeaders> returnType = new ParameterizedTypeReference<OrderHeaders>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
    * <p>Retrieves purchase-order header information.</p>
     *<p>Retrieves header information in purchase orders for a specified buyer.  Information can be further refined by filters, such as limiting data to a certain supplier and order ID.</p>
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
* @param X_ARIBA_NETWORK_ID
        The buyer&#39;s ANID.
* @return OrderHeaders
* @throws OpenApiRequestException if an error occurs while attempting to invoke the API
     */
    @Nullable   public OrderHeaders getOrderHeaderListUsingGET( @Nonnull final String X_ARIBA_NETWORK_ID) throws OpenApiRequestException {
        return getOrderHeaderListUsingGET(X_ARIBA_NETWORK_ID, null, null, null, null, null);
    }

    /**
     * <p>Retrieves line-item information from purchase orders.</p>
     *<p>Retrieves information from line items in purchase orders for a specified buyer.  Information can be further refined by filters, such as limiting data to a certain supplier and order ID.</p>
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
     * @param X_ARIBA_NETWORK_ID  (required)
        The buyer&#39;s ANID.
     * @param $filter  (optional)
        $filter&#x3D;_expression_. The _expression_ is the combination of a resource parameter and its value. The &#39;eq&#39; operator links a parameter and its value. The &#39;and&#39; operator links two or more parameter-value pairs. For example, $filter&#x3D;a eq &#39;b&#39; and c eq &#39;d&#39;. This feature supports the following parameters:&lt;br/&gt; buyerANID         -- The buyer&#39;s ANID. &lt;br/&gt; documentNumber       -- The identifier for this order, similar to the purchase order number. &lt;br/&gt; orderStatus          -- Indicates what state of processing the order has reached. &lt;br/&gt; routingStatus        -- Indicates whether a purchase order or service order is queued, sent, acknowledged, or if routing failed.&lt;br/&gt; startDate            -- The starting date of the period in which Ariba Network received the order. The maximum date range is 31 days.&lt;br/&gt; endDate              -- The ending date of the period in which Ariba Network received the order. The maximum date range is 31 days.&lt;br/&gt; 
     * @param $orderby  (optional)
        Specifies the sort order of results. You need to provide the parameter supplierANID into $filter when using $orderby. For example, $orderby&#x3D;propertyName asc.&lt;br/&gt; The order can be either ascending or descending: asc or desc. If $orderby  is not specified, results are sorted in  ascending order by default.&lt;br/&gt;  propertyName    -- The column to sort on. This is either BUYERORGID or SUPPLIERORGID. &lt;br/&gt; 
     * @param $skip  (optional)
        The number of items to be skip (offset).
     * @param $top  (optional)
        The number of items to return (page size).
     * @param $count  (optional)
        Returns the number of elements in a collection inline. The syntax is $count&#x3D;true.&lt;br/&gt; 
     * @return OrderLineItems
     * @throws OpenApiRequestException if an error occurs while attempting to invoke the API
     */
    @Nullable  public OrderLineItems getOrderItemsListUsingGET( @Nonnull final String X_ARIBA_NETWORK_ID,  @Nullable final String $filter,  @Nullable final String $orderby,  @Nullable final Integer $skip,  @Nullable final Integer $top,  @Nullable final String $count) throws OpenApiRequestException {
        final Object postBody = null;
        
        // verify the required parameter 'X_ARIBA_NETWORK_ID' is set
        if (X_ARIBA_NETWORK_ID == null) {
            throw new OpenApiRequestException("Missing the required parameter 'X_ARIBA_NETWORK_ID' when calling getOrderItemsListUsingGET");
        }
        
        final String path = UriComponentsBuilder.fromPath("/items").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$filter", $filter));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$orderby", $orderby));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$skip", $skip));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$top", $top));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "$count", $count));

        if (X_ARIBA_NETWORK_ID != null)
        headerParams.add("X-ARIBA-NETWORK-ID", apiClient.parameterToString(X_ARIBA_NETWORK_ID));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        final String[] authNames = new String[] { "OAuth2" };

        final ParameterizedTypeReference<OrderLineItems> returnType = new ParameterizedTypeReference<OrderLineItems>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
    * <p>Retrieves line-item information from purchase orders.</p>
     *<p>Retrieves information from line items in purchase orders for a specified buyer.  Information can be further refined by filters, such as limiting data to a certain supplier and order ID.</p>
     * <p><b>200</b> - Successful Response
     * <p><b>400</b> - Bad Request
     * <p><b>401</b> - Unauthorized
     * <p><b>403</b> - Forbidden
     * <p><b>404</b> - Not Found
* @param X_ARIBA_NETWORK_ID
        The buyer&#39;s ANID.
* @return OrderLineItems
* @throws OpenApiRequestException if an error occurs while attempting to invoke the API
     */
    @Nullable   public OrderLineItems getOrderItemsListUsingGET( @Nonnull final String X_ARIBA_NETWORK_ID) throws OpenApiRequestException {
        return getOrderItemsListUsingGET(X_ARIBA_NETWORK_ID, null, null, null, null, null);
    }
}
