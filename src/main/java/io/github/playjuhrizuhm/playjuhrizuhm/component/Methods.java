package io.github.playjuhrizuhm.playjuhrizuhm.component;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class Methods {

    public static int getLevenshteinDistance(String X, String Y)
    {
        int m = X.length();
        int n = Y.length();

        int[][] T = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            T[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            T[0][j] = j;
        }

        int cost;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cost = X.charAt(i - 1) == Y.charAt(j - 1) ? 0: 1;
                T[i][j] = Integer.min(Integer.min(T[i - 1][j] + 1, T[i][j - 1] + 1),
                        T[i - 1][j - 1] + cost);
            }
        }

        return T[m][n];
    }

    public static double findSimilarity(String x, String y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }
        double maxLength = Double.max(x.length(), y.length());
        if (maxLength > 0) {
            // optionally ignore case if needed
            return (maxLength - getLevenshteinDistance(x, y)) / maxLength;
        }
        return 1.0;
    }

    public static PlayComponent serializable(String result){
        PlayComponent arrayList = null;
        String source = null, playContent = null;
        int a = result.indexOf("http");
        source = result.substring(a,result.indexOf("\"" ,a));
        playContent = result.substring(result.indexOf("<p>")+3,result.indexOf("</p>"));
        arrayList = new PlayComponent(playContent,source);
        return arrayList;
    }
    public synchronized static String  solution(String paths) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        Thread thread  =   new Thread(() -> {
            try {
                URL url = new URL("https://www.bing.com/search?q='"+ URLEncoder.encode( paths.replace("path=",""), "UTF-8" )+"'");
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                // read the output from the server
                BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    if(line.contains("<li class=\"b_algo\"")){
                        int a = line.indexOf("<li class=\"b_algo\"");
                        stringBuilder.append(line, a, line.indexOf("<li class=\"b_algo\"",a+50));
                        break;
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });

        thread.start();
        thread.join();
        return stringBuilder.toString();
    }

}
