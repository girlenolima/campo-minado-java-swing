package br.com.leno.view;

import br.com.leno.model.Campo;
import br.com.leno.model.CampoEvento;
import br.com.leno.model.CampoObservador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButaoCampo extends JButton implements CampoObservador, MouseListener {


    private Campo campo;
    private final Color BG_PADRAO = new Color(184, 184, 184);
    private final Color BG_MARCADO = new Color(8, 179, 247);
    private final Color BG_EXPLODIR = new Color(189, 66, 68);
    private final Color BG_VERDE = new Color(0, 100, 0);

    public ButaoCampo(Campo campo) {
        this.campo = campo;
        setBorder(BorderFactory.createBevelBorder(0));
        setBackground(BG_PADRAO);
        setOpaque(true);
        addMouseListener(this);
        campo.registrarObservador(this);
    }

    @Override
    public void eventoOcorreu(Campo c, CampoEvento evento) {
        switch (evento) {
            case ABRIR:
                aplicarEstiloAbrir();
                break;

            case MARCA:
                aplicarEstiloMarca();
                break;

            case DESMARCAR:
                aplicarEstiloDesmarcar();
                break;

            case EXPLODIR:
                aplicarEstiloExplodir();
                break;

            default:
                aplicarEstiloPadrao();
                break;
        }


    }

    private void aplicarEstiloPadrao() {

        setBackground(BG_PADRAO);
        setBorder(BorderFactory.createBevelBorder(0));
        setText("");
    }

    private void aplicarEstiloExplodir() {
        setBackground(BG_EXPLODIR);
        setForeground(Color.WHITE);
        setText("X");
    }

    private void aplicarEstiloDesmarcar() {

    }

    private void aplicarEstiloMarca() {

        setBackground(BG_MARCADO);
        setForeground(Color.BLACK);
        setText("M");
    }

    private void aplicarEstiloAbrir() {
        setBorder(BorderFactory.createLineBorder(Color.gray));

        if (campo.isMinado()) {
            setBackground(BG_EXPLODIR);
            return;
        }

        setBackground(BG_PADRAO);

        switch (campo.minasNavizinhaca()) {
            case 1:
                setForeground(BG_VERDE);
                break;

            case 2:
                setForeground(Color.BLUE);
                break;

            case 3:
                setForeground(Color.YELLOW);
                break;
            case 4:
                setForeground(Color.RED);
                break;

            case 5:
                setForeground(Color.RED);
                break;
            case 6:
                setForeground(Color.RED);
                break;
            default:
                setForeground(Color.PINK);

        }
        String valor = !campo.vizinhacaSegura() ? campo.minasNavizinhaca() + "" : "";
        setText(valor);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == 1) {
            campo.abrir();

        } else {
            campo.alternarMarcacao();

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
