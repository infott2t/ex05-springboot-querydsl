package org.example.domain.serv.workplan;
import lombok.Data;

@Data
public class WorkPlanSearchCondition {

    private String field;       
    private String s;          

    private String sdate;      
    private String edate;      
}