
package proyecto_final;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


public class Conexion {
    
    public static double traerDatos(String tipoCotizacionEsperada) {
                
        String ventaTemp = "";
        double venta = 0;
        int contador = 0;
        
        try {

            URL url = new URL("https://api-dolar-argentina.herokuapp.com/" + tipoCotizacionEsperada);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();

            if (!conn.getResponseMessage().equals("OK")) {

                throw new RuntimeException("Ocurrio un error:\t" + conn.getResponseMessage());

            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {

                    informationString.append(scanner.nextLine());

                }

                scanner.close();
                
                for (int i = 0; i < informationString.length(); i++) {

                        if (informationString.charAt(i) == '"') {

                            contador++;
                            i++;

                        }

                        if (contador == 11) {

                            ventaTemp += informationString.charAt(i);

                        }

                    }
                
                venta = Double.parseDouble(ventaTemp);
                
                return venta;

            }

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
        
        return venta;

    }

}
