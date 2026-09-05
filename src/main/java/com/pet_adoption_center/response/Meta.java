package com.pet_adoption_center.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meta {

    private Long totalElements;
    private Integer totalPages;
    private Integer size;
    private Integer number;

}
