package com.creamind.banking.DTO;


import com.creamind.banking.models.Address;
import com.creamind.banking.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AddressDto {

    private Integer id;
    private String street;
    private Integer houseNumber;
    private Integer zipCode;
    private String city;
    private String country;

    private Integer userid;

      public static AddressDto fromEntity(Address address){

        return AddressDto.builder()
                .id(address.getId())
                .street(address.getStreet())
                .houseNumber(address.getHouseNumber())
                .city(address.getCity())
                .zipCode(address.getZipCode())
                .country(address.getCountry())
                .userid(address.getAccountowner().getId())
                .build();
        }


    public static Address toEntity(AddressDto addressdto){

        return Address.builder()
                .id(addressdto.getId())
                .street(addressdto.getStreet())
                .houseNumber(addressdto.getHouseNumber())
                .city(addressdto.getCity())
                .zipCode(addressdto.getZipCode())
                .country(addressdto.getCountry())
                .accountowner(
                        User.builder()
                                .id(addressdto.getUserid())
                                .build())
                .build();
    }

}
