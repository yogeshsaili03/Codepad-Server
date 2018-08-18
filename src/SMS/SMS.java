/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class SMS {

    public static String Sms(String Number, String Message) {
        try {
            // Construct data
            String num = "91" + Number;
            System.out.println(num);

            String apiKey = "apikey=" +
                    //"2DIhtn2D/Mk-5H4ao3xEI1IP9dNQ9jMf65yoztU4ho";
                    "EV/tPFkAqiM-eX1NzbYgx7N6uh6BKcwQQscgLRrvBz";
            System.out.println(apiKey);
            String message = "&message=" + Message;
            System.out.println(message);
            String sender = "&sender=" + "TXTLCL";
            System.out.println(sender);
            String numbers = "&numbers=" + num;
            System.out.println(numbers);

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in//send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line;
            String sResult = "";
            while ((line = rd.readLine()) != null) {
                // Process line...
                sResult = sResult + line + " ";

                System.out.println(line);
            }
            rd.close();
            System.out.println("a" + sResult);
            String word = "success";
            if (Check.isWordExist(sResult, word)) {
                System.out.println("Word is exist");
                
                return "sent";
            } else {
                System.out.println("Word not exist");
                return "nosent";
            }
        } catch (Exception e) {
            System.out.println("Error SMS " + e);
            return "nosent";
        }
    }

}
