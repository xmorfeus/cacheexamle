import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainClass {

    public static void main( String[] args )
    {
        URL servlet;
        try {


//          String url = "http://localhost:8090/cacheServlet/getchangingoject";
            String url = "http://localhost:8090/cacheServlet/getstaticobject";

            servlet = new URL(url);

            int count = 5;
            long sumTime = 0;

            for (int i = 0; i < count; i++) {

                //start time
                long startTime = System.nanoTime();


                HttpURLConnection con = (HttpURLConnection) servlet.openConnection();
                con.setRequestMethod("GET");

                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                //print result
                System.out.println(response.toString());


                //end time
                long endTime = System.nanoTime();
                long duration = (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.

                sumTime += duration;

                System.out.println(duration);
            }


            System.out.println("Average time: " + (sumTime/count));

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
