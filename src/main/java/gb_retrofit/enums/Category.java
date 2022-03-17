package gb_retrofit.enums;

import lombok.Getter;

public enum Category {
    FOOD( 1, "Food"),
    Electronic (2, "Electronic"),
    FURNITURE(3, "Furniture");

    @Getter
    private Integer id;
    @Getter
    private String name;

    Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
