package com.onlineMarket.core.endpoints;



import com.onlineMarket.core.converters.ProductConverter;
import com.onlineMarket.core.services.ProductService;
import com.onlineMarket.core.soap.products.GetAllProductsRequest;
import com.onlineMarket.core.soap.products.GetAllProductsResponse;
import com.onlineMarket.core.soap.products.GetProductByIdRequest;
import com.onlineMarket.core.soap.products.GetProductByIdResponse;
import com.onlineMarket.core.data.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.onlineMarket.com/products";
    private final ProductService productService;
    private final ProductConverter productConverter;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductByIdRequest")
    @ResponsePayload
    public GetProductByIdResponse getProductById(@RequestPayload GetProductByIdRequest request) {
        GetProductByIdResponse response = new GetProductByIdResponse();
        Optional<Product> product = productService.findById(request.getId());
        response.setProduct(productConverter.entityToProductSoap(product.get()));
        return response;
    }

    /*
        Пример запроса: POST http://localhost:8080/store/ws
        Header -> Content-Type: text/xml

        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.onlineMarket.com/products">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getAllProductsRequest/>
            </soapenv:Body>
        </soapenv:Envelope>
     */

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
       GetAllProductsResponse response = new GetAllProductsResponse();
       productService.getAllProducts().stream()
               .map(productConverter::entityToProductSoap)
               .forEach(response.getProducts()::add);
       return response;
    }
}
