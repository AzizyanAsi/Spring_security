package com.example.webik.service.dto;

import javax.validation.constraints.*;
import java.util.Objects;

public class ItemDTO {
    private Long id;
    @NotBlank(message = "name must not be blank")
    private String name;
    @PositiveOrZero
    @Min(value = 10)
    @Max(value = 1000)
    private Integer price;
    @NotNull
    private ItemDetailsDTO itemDetails;
    private String groupName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ItemDetailsDTO getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(ItemDetailsDTO itemDetails) {
        this.itemDetails = itemDetails;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(id, itemDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
