package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame{

    private JTextField display;
    private JButton boton1, boton2, boton3, boton4,boton5, boton6, boton7, boton8;
    private JButton boton9, boton10, boton11, boton12, boton13, boton14, boton15, boton16;
    private JPanel panelSuperior, panelInferior;

    String memoria1;
    String signo;
    String memoria2;

    public Calculadora(){
        super("calculadora");
        //setSize(300,300);
        display = new JTextField(30);
        panelSuperior = new JPanel(new FlowLayout());
        panelInferior = new JPanel(new GridLayout(4,4));
        panelSuperior.add(display);



        boton1 = new JButton("7");



        boton2 = new JButton("8");
        boton3 = new JButton("9");
        boton4 = new JButton("/");
        boton5 = new JButton("4");
        boton6 = new JButton("5");
        boton7 = new JButton("6");
        boton8 = new JButton("X");
        boton9 = new JButton("1");
        boton10 = new JButton("2");
        boton11 = new JButton("3");
        boton12 = new JButton("+");
        boton13 = new JButton("0");
        boton14 = new JButton(",");
        boton15 = new JButton("=");
        boton16 = new JButton("-");

        panelInferior.add(boton1);
        panelInferior.add(boton2);
        panelInferior.add(boton3);
        panelInferior.add(boton4);
        panelInferior.add(boton5);
        panelInferior.add(boton6);
        panelInferior.add(boton7);
        panelInferior.add(boton8);
        panelInferior.add(boton9);
        panelInferior.add(boton10);
        panelInferior.add(boton11);
        panelInferior.add(boton12);
        panelInferior.add(boton13);
        panelInferior.add(boton14);
        panelInferior.add(boton15);
        panelInferior.add(boton16);

        setLayout(new BorderLayout());
        add(panelSuperior, BorderLayout.NORTH);
        add(panelInferior, BorderLayout.CENTER);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText(display.getText()+"7");
            }
        });

        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText(display.getText()+"8");
            }
        });

        boton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText(display.getText()+"9");
            }
        });

        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //display.setText(display.getText()+"/");

                if(!display.getText().equals("")){

                    memoria1 = display.getText();
                    signo = "/";
                    display.setText("");
                }
            }
        });

        boton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText(display.getText()+"4");
            }
        });

        boton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText(display.getText()+"5");
            }
        });

        boton7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText(display.getText()+"6");
            }
        });

        boton8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //display.setText(display.getText()+"x");

                if(!display.getText().equals("")){

                    memoria1 = display.getText();
                    signo = "x";
                    display.setText("");
                }
            }
        });

        boton9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText(display.getText()+"1");
            }
        });

        boton10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText(display.getText()+"2");
            }
        });

        boton11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText(display.getText()+"3");
            }
        });

        boton12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //display.setText(display.getText()+"+");

                if(!display.getText().equals("")){

                    memoria1 = display.getText();
                    signo = "+";
                    display.setText("");
                }
            }
        });

        boton13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText(display.getText()+"0");
            }
        });

        boton14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String cadena;
                cadena =  display.getText();
                if (cadena.length()<=0){
                    display.setText("0,");
                }else{
                    if (!existePunto(display.getText())){
                        display.setText(display.getText()+",");
                    }
                }
            }
            public  boolean existePunto(String cadena){
                boolean resultado;
                resultado = false;
                for (int i = 0; i < cadena.length(); i++){
                    if (cadena.substring(i, i + 1).equals(",")){
                        resultado = true;
                        break;
                    }
                }
                return  resultado;
            }
        });

        boton15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //display.setText(display.getText()+"=");

                String resultado;
                memoria2 = display.getText();

                if (!memoria2.equals("")){
                    resultado = calcu(memoria1, memoria2, signo);
                    display.setText(resultado);
                }
            }

            public  String calcu(String memoria1, String memoria2, String signo) {


                    double resultado = 0;
                    String respuesta;

                    if (signo.equals("-")){
                        resultado = Double.parseDouble(memoria1)- Double.parseDouble(memoria2);
                    }

                    else if (signo.equals("+")){
                        resultado = Double.parseDouble(memoria1)+ Double.parseDouble(memoria2);
                    }

                    else if (signo.equals("/")){
                        resultado = Double.parseDouble(memoria1) / Double.parseDouble(memoria2);
                    }

                    else if (signo.equals("x")){
                        resultado = Double.parseDouble(memoria1) * Double.parseDouble(memoria2);
                    }

                    respuesta = String.valueOf(resultado);
                    return respuesta;

            }

        });
        
        
        

        boton16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //display.setText(display.getText()+"-");

                if(!display.getText().equals("")){

                    memoria1 = display.getText();
                    signo = "-";
                    display.setText("");
                }
            }
        });

    }



}
