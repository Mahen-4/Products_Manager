package com.productManagerServAPI.ProductManagerServAPI.model;

import javax.sound.sampled.EnumControl;

public record Content (
        Integer id,
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
