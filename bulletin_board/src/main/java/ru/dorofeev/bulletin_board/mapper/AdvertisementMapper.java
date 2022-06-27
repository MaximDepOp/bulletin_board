//package ru.dorofeev.bulletin_board.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//import ru.dorofeev.bulletin_board.dto.AdvertisementDto;
//import ru.dorofeev.bulletin_board.model.base.Advertisement;
//
//import java.util.List;
////, CategoryMapper.class, RegionMapper.class
//@Mapper(componentModel = "spring", uses = {SubcategoryMapper.class, LocalityMapper.class, StreetMapper.class})
//public interface AdvertisementMapper {
//    @Mappings({
//            @Mapping(source = "subcategory.category.name", target = "category"),
//            @Mapping(source = "subcategory.name", target = "subcategory"),
//            @Mapping(source = "locality.name", target = "locality"),
//            @Mapping(source = "locality.region.name", target = "region"),
//            @Mapping(source = "street.name", target = "contentGuid"),
//    })
//    List<AdvertisementDto> toDtoList(List<Advertisement> advertisement);
//
//    @Mappings({
//            @Mapping(source = "category", target = "subcategory.category.name"),
//            @Mapping(source = "subcategory", target = "subcategory.name"),
//            @Mapping(source = "locality", target = "locality.name"),
//            @Mapping(source = "region", target = "locality.region.name"),
//            @Mapping(source = "contentGuid", target = "street.name"),
//    })
//    List<Advertisement> toViewedList(List<AdvertisementDto> advertisementDto);
//
//}
