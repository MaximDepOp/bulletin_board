package ru.dorofeev.bulletin_board.mapper;

import ru.dorofeev.bulletin_board.dto.AdvertisementDto;
import ru.dorofeev.bulletin_board.model.base.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdvertisementMapperCustom {
    public static List<Advertisement> toAdvertisementList(List<AdvertisementDto> advertisementDto) {
        List<Advertisement> temp = new ArrayList<>();
        if (advertisementDto == null) {
            return List.of();
        }

        for (var item : advertisementDto){
            temp.add(toAdvertisement(item));
        }

        return temp;
    }

    public static List<AdvertisementDto> toAdvertisementDtoList(List<Advertisement> advertisement) {
        List<AdvertisementDto> temp = new ArrayList<>();
        if (advertisement == null) {
            return List.of();
        }

        for (var item : advertisement){
            temp.add(toAdvertisementDto(item));
        }

        return temp;
    }

    public static Advertisement toAdvertisement(AdvertisementDto advertisementDto) {
        if (advertisementDto == null) {
            return null;
        }

        Advertisement advertisement = new Advertisement();
        advertisement.setId(advertisementDto.getId());
        advertisement.setName(advertisementDto.getName());
        advertisement.setSubcategory(
                Subcategory.builder()
                        .name(advertisementDto.getSubcategory())
                        .category(
                                Category.builder()
                                        .name(advertisementDto.getCategory())
                                        .build()
                        )
                        .build()
        );
        advertisement.setDescription(advertisementDto.getDescription());
        advertisement.setPrice(advertisementDto.getPrice());
        advertisement.setLocality(
                Locality.builder()
                        .name(advertisementDto.getLocality())
                        .region(
                                Region.builder()
                                        .name(advertisementDto.getRegion())
                                        .build()
                        )
                        .build()
        );
        advertisement.setStreet(
                Street.builder()
                        .name(advertisementDto.getStreet())
                        .build()
        );
        advertisement.setHouseNumber(advertisementDto.getHouseNumber());

        return advertisement;
    }

    public static AdvertisementDto toAdvertisementDto(Advertisement advertisement) {
        if (advertisement == null) {
            return null;
        }

        AdvertisementDto advertisementDto = new AdvertisementDto();
        advertisementDto.setId(advertisement.getId());
        advertisementDto.setName(advertisement.getName());
        advertisementDto.setCreate_date(advertisement.getCreate_date());
        advertisementDto.setCategory(advertisement.getSubcategory().getCategory().getName());
        advertisementDto.setSubcategory(advertisement.getSubcategory().getName());
        advertisementDto.setDescription(advertisement.getDescription());
        advertisementDto.setPrice(advertisement.getPrice());
        advertisementDto.setLocality(advertisement.getLocality().getName());
        advertisementDto.setRegion(advertisement.getLocality().getRegion().getName());
        advertisementDto.setStreet(advertisement.getStreet().getName());
        advertisementDto.setHouseNumber(advertisement.getHouseNumber());

        return advertisementDto;
    }
}
