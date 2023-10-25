package br.com.leno.view;

import br.com.leno.model.Tabuleiro;

import javax.swing.*;
import java.awt.*;

public class PainelTabuleiro extends JPanel {

    public PainelTabuleiro(Tabuleiro tabuleiro) {

        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCada(c -> add(new ButaoCampo(c)));
        tabuleiro.registrarObservador(e -> {

            SwingUtilities.invokeLater(() -> {
                if (tabuleiro.objetivoAlcancado()) {

                    JOptionPane.showMessageDialog(this, "Ganhou");
                } else {
                    JOptionPane.showMessageDialog(this, "Perdeu");

                }

                tabuleiro.reiniciar();
            });


        });


    }
}
