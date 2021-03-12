package com.capgemini.lenskart.models.dto;

import java.io.Serializable;
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
public class ProductUpdateDto implements Serializable {
    /**
     * Serial Version Id
     */
    private static final long serialVersionUID = 770945351909626253L;
    @JsonProperty(value = "productName")
    private String productName;
    @JsonProperty(value = "productDescription")
    private String productDescription;
}
