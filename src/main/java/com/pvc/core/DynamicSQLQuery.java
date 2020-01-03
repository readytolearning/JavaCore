package com.pvc.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DynamicSQLQuery {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader(new File("D:\\Git Code\\Java Core Examples\\JavaCore\\src\\com\\pvc\\core\\data.txt"));
        BufferedReader br = new BufferedReader(fr);
        String line;

        while((line = br.readLine()) != null){
          //  System.out.println(line);
            StringBuilder sb = new StringBuilder();
           String[] data =  line.split("\\|");
           // System.out.println(data.length);
            sb.append("UPDATE rm_service.osl_events SET customer_id = '"+data[0]+"', " +
                    "acct_id = '"+data[1]+"', item_code = '"+data[2]+"', " +
                    "proposition_amount = '200', hold_date = purchase_date + 45, " +
                    "status = 'PENDING', status_code = null, status_desc = null, " +
                    "final_qualification = 'QUALIFIED', " +
                    "message = 'Manually Updated as per RA', update_bh = null," +
                    "first_name = '"+data[3]+"', last_name = '"+data[4]+"', " +
                    "address1 = '"+data[5]+"'', address2 = '"+data[6]+"', " +
                    "city = '"+data[7]+"', state = '"+data[8]+"', zipcode = '"+data[9]+"' " +
                    " where event_id = "+data[10]+"");
            System.out.println(sb.toString());
        }
    }

}
