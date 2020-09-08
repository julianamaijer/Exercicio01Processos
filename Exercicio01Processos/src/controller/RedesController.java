package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

    public RedesController() {
        super();
    }

    public void ip(String process) {
        String adaptador=null;

        try {
            Process p = Runtime.getRuntime().exec(process);
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            if (process == "ipconfig"){
                while (linha != null) {
                    if (linha.contains("Adaptador")) {
                        adaptador = linha;
                    }else{
                        if (linha.contains("IPv4")) {
                            System.out.println(adaptador);
                            System.out.println(linha);
                        }
                    }linha = buffer.readLine();
                }
            }else{
                while (linha != null) {
                    if (linha.contains("inet")) {
                        adaptador = linha;
                        System.out.println(adaptador);
                    }linha = buffer.readLine();
                }
            }
            buffer.close();
            leitor.close();
            fluxo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void ping(String process) {
        String tempo = null;
        int tempoTotal=0;
        int tempoMedio=0;

        try {
            Process p = Runtime.getRuntime().exec(process);
            InputStream fluxo = p.getInputStream();
            InputStreamReader leitor = new InputStreamReader(fluxo);
            BufferedReader buffer = new BufferedReader(leitor);
            String linha = buffer.readLine();
            if (process == "ping -n 10 www.google.com.br"){
                while (linha != null) {
                    if (linha.contains("tempo")) {
                        tempo = linha.substring(40,46);
                        String tempo2 = tempo.replaceAll("[^0-9]", "");
                        int tempoConvertido = Integer.parseInt(tempo2);
                        tempoTotal = tempoTotal + tempoConvertido;
                    }linha = buffer.readLine();
                }
            }else{
                while (linha != null) {
                    if (linha.contains("time")) {
                        tempo = linha.substring(50, 58);
                        String tempo2 = tempo.replaceAll("[^0-9]", "");
                        int tempoConvertido = Integer.parseInt(tempo2);
                        tempoTotal = tempoTotal + tempoConvertido;
                    }linha = buffer.readLine();
                }
            }
            buffer.close();
            leitor.close();
            fluxo.close();
            tempoMedio = (tempoTotal / 10);
            System.out.println("O tempo médio das iterações do ping é: " + tempoMedio + "ms.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}