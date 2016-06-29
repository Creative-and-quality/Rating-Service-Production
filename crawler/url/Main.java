package url;

import control.DBFacade;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;


/**
 * Created by d.gurov on 22.06.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {

//        String url = args[0];
      //  String urlFromDB = "lenta.ru";
        Collection<String> urlFromDB = DBFacade.getInstance().getSitesDao().select();



        String htmlRobots;
        String htmlSitemap;
        String siteMap = null;
        String html;

        try {
            String urlRobots = "https://" + urlFromDB + "/robots.txt";
            htmlRobots = Jsoup.connect(urlRobots).get().html();

            if (htmlRobots.contains("sitemap.xml")) {
                String[] text = htmlRobots.split(" ");
                for (String x : text) {
                    if (x.endsWith(".xml")) {
                        System.out.println(x);
                        siteMap = x;
                    }
                }
                System.out.println("ура");
            } else {
                System.out.println("жопа");
            }
        } catch (IOException e) {
            String urlRobots = "http://" + urlFromDB + "/robots.txt";
            htmlRobots = Jsoup.connect(urlRobots).get().html();
        }


        htmlSitemap = Jsoup.connect(siteMap).get().html();
//        System.out.println(htmlSitemap);
        ArrayList<String> list = new ArrayList<>();

        String[] text1 = htmlSitemap.split(" ");
        for (String y : text1) {
            if (y.contains(".xml") | y.contains(".gz")) {
                list.add(y);
//                System.out.println(y);
//                openGZ(y);

            }
        }

        openGZ("https://lenta.ru/news/sitemap.xml.gz");

    }



       public static void openGZ(String s){
            String url_get_page = s;
            StringBuffer result = new StringBuffer();
            URL url;

            try {
                url = new URL(url_get_page);
                HttpURLConnection connection = null;
                connection = (HttpURLConnection) url.openConnection();

//                connection.setRequestMethod("GET");
//                connection.setDoOutput(true);
//                connection.setReadTimeout(10000);
//                connection.setRequestProperty("Host", "www.pai.pt");
//                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; ru; rv:1.9.2) Gecko/20100115 Firefox/3.6");
//                connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,****/*//*//**//*//**//**//**//*;q=0.8");
//                connection.setRequestProperty("Accept-Language", "ru,en-us;q=0.7,en;q=0.3");
//                connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
//                connection.setRequestProperty("Accept-Charset", "windows-1251,utf-8;q=0.7,*;q=0.7");
//                connection.setRequestProperty("Keep-Alive", "115");
//                connection.setRequestProperty("Connection", "keep-alive");
//                connection.setRequestProperty("Referer", "http://www.pai.pt/search.ds");
//                connection.setRequestProperty("Cookie", "MfPers=12678646695048a98819027298bf50127329f8c315e8f; vuid=8a98819027298bf50127329f8c315e8f; ptkn=40EAFA18-5758-F374-F570-A0480F306222; WT_FPC=id=174.142.104.57-1456441520.30063880:lv=1267888167073:ss=1267888167073; __utma=76091412.2059393411.1267864686.1267878351.1267891770.4; __utmz=76091412.1267864686.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); BFHost=wd-web04.osl.basefarm.net; JSESSIONID=20C8FD4414F50F3AE361C487D0E3C719; MfTrack=12678917654148a98819027298bf50127329f8c315e8f; BIGipServerwd-web-pt=285284362.20480.0000; __utmb=76091412.1.10.1267891770; __utmc=76091412");
//                connection.connect();

                GZIPInputStream gzipInputStream = new GZIPInputStream(connection.getInputStream());
//                BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF8"));
                BufferedReader rd = new BufferedReader(new InputStreamReader(gzipInputStream));
                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line).append("\n");
                }
                connection.disconnect();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
//            System.out.println(result.toString());


            String[] resultZ = result.toString().split("<loc>");
            for (String q : resultZ) {
//                System.out.println(q);
                String[] ss = q.split("</loc>");
                System.out.println(ss[0]);
//                System.out.println(q);
            }


        }
    }




