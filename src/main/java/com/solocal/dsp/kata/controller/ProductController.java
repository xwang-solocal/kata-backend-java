package com.solocal.dsp.kata.controller;

import com.solocal.dsp.kata.dto.business.ProductDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Product resource endpoints", description = "All endpoints allow to manipulate the product resource")
@RestController
@RequestMapping("/onelinestore_api")
public class ProductController {

    @ApiOperation(value = "Get the list of products according to the title", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping( path = "/products", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ProductDTO> getProducts(@RequestParam(required = false) String title) {
        return null;
    }

    public ProductDTO publishProduct(@RequestBody ProductDTO bookDTO) {
        return null;
    }

    public ProductDTO updateProduct(@PathVariable int id, @RequestBody ProductDTO bookDTO) {
        return null;
    }

    public String unPublishProduct(@PathVariable int id) {
        return null;
    }


}
