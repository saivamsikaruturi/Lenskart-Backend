package com.capgemini.lenskart.models.dto;

import java.util.List;

import com.capgemini.lenskart.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CategoryUpdateDto{

	 @JsonProperty(value = "categoryId")
	    private Long categoryId;

	    @JsonProperty(value = "categoryName")
	    private String categoryName;

	    @JsonProperty(value = "product")
	    private List<Product> productList;

}
