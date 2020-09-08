package view;

import javax.swing.*;

import controller.RedesController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RedesController redesController = new RedesController();
        Scanner scanner = new Scanner(System.in);

        int os = 0;
        String process=null;
        int opcao = 0;

        while (opcao != 99) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu: \n" +
                    "1 - Método ip\n" +
                    "2 - Método ping\n" +
                    "99 - Sair"));

            switch (opcao) {
                case 1:
                    os = Integer.parseInt(JOptionPane.showInputDialog("Insira (1) para SO Windows 10 e (2) para SO Linux: "));
                    if (os == 1){
                        process = "ipconfig";
                        redesController.ip(process);
                    }else{
                        if (os == 2){
                            process = "ifconfig";
                            redesController.ip(process);
                        }else{
                            JOptionPane.showMessageDialog(null,"Opção inválida!");
                        }
                    }
                    break;
                case 2:
                    os = Integer.parseInt(JOptionPane.showInputDialog("Insira (1) para SO Windows 10 e (2) para SO Linux: "));
                    if (os == 1){
                        process = "ping -n 10 www.google.com.br";
                        redesController.ping(process);
                    }else{
                        if (os == 2){
                            process = "ping -c 10 www.google.com.br";
                            redesController.ping(process);
                        }else{
                            JOptionPane.showMessageDialog(null,"Opção inválida!");
                        }
                    }
                    break;
                case 99:
                    JOptionPane.showMessageDialog(null,"Você saiu do cadastro!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}