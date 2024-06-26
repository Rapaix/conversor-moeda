package service;

import com.google.gson.Gson;
import model.ConversaoMoeda;
import model.Moeda;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoedas {
    String API_KEY = "016ebd7b6c28be57cf3ff6da";
    public void converter(Double valor,
                          ConversaoMoeda moeda1,
                          ConversaoMoeda moeda2){
        try {
            Double moedaConvertida = RequestAPIMoeda(valor, moeda1.getSigla(), moeda2.getSigla());

            System.out.println(moedaConvertida);
        }
        catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    Double RequestAPIMoeda(Double valor, String moeda1, String moeda2) throws URISyntaxException {

        String uri = """
                https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%s""".formatted(API_KEY, moeda1,moeda2, valor);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =  HttpRequest.newBuilder()
                .uri(new URI(uri))
                .GET()
                .build();
        HttpResponse response;

        try {
           response =client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        Moeda moeda = gson.fromJson(response.body().toString(), Moeda.class);

        return moeda.valor();
    }
}
