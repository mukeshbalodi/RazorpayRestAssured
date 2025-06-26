package org.Mukesh.MyRestAssured;

public class TestNetwork {
    public static void main(String[] args) {
        try {
            java.net.HttpURLConnection con = (java.net.HttpURLConnection) new java.net.URL("https://reqres.in/api/users").openConnection();
            con.setRequestMethod("GET");
            System.out.println("Response Code: " + con.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
