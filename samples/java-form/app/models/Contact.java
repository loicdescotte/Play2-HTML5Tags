package models;

import java.util.*;

import javax.validation.*;

import play.data.validation.Constraints.*;

public class Contact {
    
    @Required
    @MinLength(2)
    @MaxLength(10)
    public String name;

	@Required @Email
    public String email;

    @Min(18)
    @Max(99)
    public Integer age;

    @Required
    @Pattern("[0-9]{4}")
    public String password;

}