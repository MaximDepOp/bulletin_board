//package ru.dorofeev.bulletin_board.mapper;
//
//import org.mapstruct.Mapper;
//import ru.dorofeev.bulletin_board.model.base.Locality;
//import ru.dorofeev.bulletin_board.model.base.Subcategory;
//
//@Mapper(componentModel = "spring")
//public class LocalityMapper {
//    public String map(Locality locality) {
//        return locality.getName();
//    }
//
//    public Locality map(String value) {
//        return Locality.builder()
//                .name(value)
//                .build();
//    }
//}
