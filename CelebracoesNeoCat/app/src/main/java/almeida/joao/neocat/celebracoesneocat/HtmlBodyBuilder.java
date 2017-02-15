package almeida.joao.neocat.celebracoesneocat;

import java.util.ArrayList;

/**
 * Created by jpa on 15/02/2017.
 */

public class HtmlBodyBuilder {

    public static String getHtmlBody(int type, ArrayList<String> parameters) {
        String body = "";
        switch (type) {
            case 1: body = getCelbPalavraBody(parameters);
                break;
            default: body = "<p>No type selected</p>";
                break;
        }
        return body;
    }

    private static String getCelbPalavraBody(ArrayList<String> parameters) {
        StringBuilder body = new StringBuilder();
        body.append("<h2>Celebração da Palavra</h2>");
        body.append("<p><b>Admonição Ambiental: </b>").append(parameters.get(0)).append("</p>");
        body.append("<p><b>Cântico Entrada: </b>").append(parameters.get(1)).append("</p>");
        body.append("<p></p>");
        body.append("<p><b>1ª Leitura: </b>").append(parameters.get(2)).append("</p>");
        body.append("<p><b>Admonição: </b>").append(parameters.get(3)).append("</p>");
        body.append("<p><b>Cântico: </b>").append(parameters.get(4)).append("</p>");
        body.append("<p></p>");
        body.append("<p><b>2ª Leitura: </b>").append(parameters.get(5)).append("</p>");
        body.append("<p><b>Admonição: </b>").append(parameters.get(6)).append("</p>");
        body.append("<p><b>Cântico: </b>").append(parameters.get(7)).append("</p>");
        body.append("<p></p>");
        body.append("<p><b>3ª Leitura: </b>").append(parameters.get(8)).append("</p>");
        body.append("<p><b>Admonição: </b>").append(parameters.get(9)).append("</p>");
        body.append("<p><b>Cântico: </b>").append(parameters.get(10)).append("</p>");
        body.append("<p></p>");
        body.append("<p><b>Evangelho: </b>").append(parameters.get(11)).append("</p>");
        body.append("<p><b>Admonição: </b>").append(parameters.get(12)).append("</p>");
        body.append("<p></p>");
        body.append("<p><b>Cântico Final: </b>").append(parameters.get(13)).append("</p>");
        return body.toString();
    }
}
