package com.greenbridge.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FarmerDTO {

    private Integer farmerId;
    @NotEmpty
    @Size(min = 4,message="first name must be min of 4 characters")
    private String firstName;
    private String lastName;
    @NotNull
    private String userName;
    @NotNull
    private Integer age;
    private String gender;
    @NotNull
    private String password;
    private String mobileNumber;

}
