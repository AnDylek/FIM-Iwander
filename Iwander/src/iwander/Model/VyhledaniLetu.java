/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iwander.Model;

import iwander.Database.Connect;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 *
 * @author AnDylek
 */
public class VyhledaniLetu extends Connect{

    public VyhledaniLetu(Connection conn, Statement stmt) {
        super();
    }
    public void vyhledej(String odkud, String kam, SimpleDateFormat sdf){
        Statement stmtVyhledej;
        
    }

}
