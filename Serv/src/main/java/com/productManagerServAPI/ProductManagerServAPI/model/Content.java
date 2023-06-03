package com.productManagerServAPI.ProductManagerServAPI.model;

import jakarta.validation.constraints.NotEmpty;

import javax.sound.sampled.EnumControl;

public record Content (
        Integer id,
        @NotEmpty
        String name,
        String desc,
        Integer price,
        Integer quantity,
        Type type,
        String image,
        Boolean inTrend

)
{
}
