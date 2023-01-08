package org.example.domain.address;
import lombok.Data;

@Data
public class AddressStrSearchCondition {

    private String field;       
    private String s;          

    private String sdate;      
    private String edate;      
}