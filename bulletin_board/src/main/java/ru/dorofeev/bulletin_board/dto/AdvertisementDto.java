package ru.dorofeev.bulletin_board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
public class AdvertisementDto {

    private Long id;

    private String name;

    private Date create_date;

    private String category;

    private String subcategory;

    private String description;

    private BigDecimal price;

    private String locality;

    private String region;

    private String street;

    private String houseNumber;
}
