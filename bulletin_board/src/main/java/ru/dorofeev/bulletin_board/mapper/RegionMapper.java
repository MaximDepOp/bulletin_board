//package ru.dorofeev.bulletin_board.mapper;
//
//import org.mapstruct.Mapper;
//import ru.dorofeev.bulletin_board.model.base.Locality;
//import ru.dorofeev.bulletin_board.model.base.Region;
//
//@Mapper(componentModel = "spring")
//public class RegionMapper {
//    public String map(Locality locality) {
//        return locality.getRegion().getName();
//    }
//
//    public Locality map(String value) {
//        return Locality.builder()
//                .region(
//                        Region.builder()
//                                .name(value)
//                                .build()
//                )
//                .build();
//    }
//}
