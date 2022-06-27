//package ru.dorofeev.bulletin_board.mapper;
//
//import org.mapstruct.Mapper;
//import ru.dorofeev.bulletin_board.model.base.Category;
//import ru.dorofeev.bulletin_board.model.base.Subcategory;
//
//@Mapper(componentModel = "spring")
//public class CategoryMapper {
//    public String map(Subcategory subcategory) {
//        return subcategory.getCategory().getName();
//    }
//
//    public Subcategory map(String value) {
//        return Subcategory.builder()
//                .category(
//                        Category.builder()
//                                .name(value)
//                                .build()
//                )
//                .build();
//    }
//}
