package br.com.leno.view;

import br.com.leno.model.Tabuleiro;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {

        Tabuleiro tabuleiro = new Tabuleiro(16,30,50);
        PainelTabuleiro painelTabuleiro = new PainelTabuleiro(tabuleiro);
        add(painelTabuleiro);

        setTitle("Campo Minado");
        setSize(690,438);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);


    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
