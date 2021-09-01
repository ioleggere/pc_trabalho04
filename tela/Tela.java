package tela;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.*;
import threads.Tremdois;
import threads.Tremum;
import static threads.Tremum.velocidadetremum;
import static threads.Tremdois.velocidadetremdois;;
/*=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Autor....: Euler da Silva Lima
Matrícula: 201911534
Inicio...: 05 de abril de 2021
Alteracao: 18 de abril de 2021
Nome.....: Tela.java
Funcao...: Classe Tela, onde todos as acoes de interface serao administradas.
=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=*/
public class Tela{
  public static JFrame janela = new JFrame("Trilhos Thread"); //JFrame, onde tudo sera desenhado.

  public static JLabel trem = new JLabel(); //JLabel representando o primeiro trem.

  public static JLabel trem2 = new JLabel(); //JLabel representando o segundo trem.

  public static Tremum tremum = new Tremum(); //Iniciando o objeto representando o primeiro trem.

  public static Tremdois tremdois = new Tremdois(); //Iniciando o objeto representando o segundo trem.

  public static JLabel greenflag = new JLabel(); //Iniciando o objeto representando a primeira bandeira verde.

  public static JLabel redflag = new JLabel(); //Iniciando o objeto representando a primeira bandeira vermelha.

  public static JLabel greenflag2 = new JLabel(); //Iniciando o objeto representando a segunda bandeira verde.

  public static JLabel redflag2 = new JLabel(); //Iniciando o objeto representando a segunda bandeira vermelha.

  public static JLabel greenflag3 = new JLabel(); //Iniciando o objeto representando a terceira bandeira verde.

  public static JLabel redflag3 = new JLabel(); //Iniciando o objeto representando a terceira bandeira vermelha.

  public static JLabel greenflag4 = new JLabel(); //Iniciando o objeto representando a quarta bandeira verde.

  public static JLabel redflag4 = new JLabel(); //Iniciando o objeto representando a quarta bandeira vermelha.

  public Tela(){
    
    janela.pack();

    JMenuBar menu = new JMenuBar(); //JMenuBar, uma barra de menus onde ficara as opcoes de controle do programa.

    JMenu opcoes = new JMenu("Opcoes"); //JMenu, uma janela onde ira conter as opcoes.

    JMenuItem iniciar = new JMenuItem("Iniciar"); //JMenuItem, uma opcao para o menu.

    JMenuItem reiniciar = new JMenuItem("Reiniciar"); //JMenuItem, uma opcao para o menu.

    JMenuItem aumentartremum = new JMenuItem("Aumentar velocidade do trem 1"); //JMenuItem, uma opcao para o menu.

    JMenuItem diminuirtremum = new JMenuItem("Diminir velocidade do trem 1"); //JMenuItem, uma opcao para o menu.

    JMenuItem aumentartremdois = new JMenuItem("Aumentar velocidade do trem 2"); //JMenuItem, uma opcao para o menu.

    JMenuItem diminuirtremdois = new JMenuItem("Diminuir velocidade do trem 2"); //JMenuItem, uma opcao para o menu.

    JLabel trilhos = new JLabel(new ImageIcon(getClass().getResource("/img/trilhos.png"))); //JLabel, representando os trilhos.
    
    //Adicionando as opcoes no JMenu 'opcoes'.
    opcoes.add(iniciar); 
    opcoes.add(reiniciar);
    opcoes.add(aumentartremum);
    opcoes.add(diminuirtremum);
    opcoes.add(aumentartremdois);
    opcoes.add(diminuirtremdois);

    menu.setSize(260,20); //Definindo o tamanho da barra de menus.

    menu.setLocation(0,0); //Definindo a localizacao da barra de menus.

    opcoes.setSize(80,18); //Definindo o tamanho da guia opcoes.

    opcoes.setLocation(0,0); //Definindo a localizacao da guia opcoes.

    menu.add(opcoes); //Adicionando a guia de opcoes na barra de menus.

    //Inserindo as imagens nas respectivas JLabel's.
    trem = new JLabel(new ImageIcon(getClass().getResource("/img/trem.png"))); 

    trem2 = new JLabel(new ImageIcon(getClass().getResource("/img/trem2.png")));
    
    greenflag = new JLabel(new ImageIcon(getClass().getResource("/img/greenflag.png")));

    redflag = new JLabel(new ImageIcon(getClass().getResource("/img/redflag.png")));

    greenflag2 = new JLabel(new ImageIcon(getClass().getResource("/img/greenflag.png")));

    redflag2 = new JLabel(new ImageIcon(getClass().getResource("/img/redflag.png")));

    greenflag3 = new JLabel(new ImageIcon(getClass().getResource("/img/greenflag.png")));

    redflag3 = new JLabel(new ImageIcon(getClass().getResource("/img/redflag.png")));

    greenflag4 = new JLabel(new ImageIcon(getClass().getResource("/img/greenflag.png")));

    redflag4 = new JLabel(new ImageIcon(getClass().getResource("/img/redflag.png")));

    //Configuracoes da janela, e insercoes dos elementos na mesma.

    janela.setDefaultCloseOperation(janela.EXIT_ON_CLOSE);

    janela.setResizable(false);

    janela.setSize(260, 750);

    janela.setVisible(true); 

    janela.setLocationRelativeTo(null); 

    janela.add(menu); 

    trem.setBounds(40, 0, 50 ,100); 

    janela.add(trem); 

    trem2.setBounds(140, 610, 50 ,100); 

    janela.add(trem2); 
    
    greenflag.setBounds(30, 150, 40,40);

    janela.add(greenflag);
    
    greenflag2.setBounds(160, 150, 40, 40);

    janela.add(greenflag2);

    greenflag3.setBounds(30, 480, 40, 40);

    janela.add(greenflag3);

    greenflag4.setBounds(160, 480, 40, 40);

    janela.add(greenflag4);

    redflag.setBounds(30, 150, 40,40);
    
    redflag.setVisible(false);

    janela.add(redflag);

    redflag2.setBounds(160, 150, 40, 40);

    redflag2.setVisible(false);

    janela.add(redflag2);

    redflag3.setBounds(30, 480, 40, 40);

    redflag3.setVisible(false);

    janela.add(redflag3);

    redflag4.setBounds(160, 480, 40, 40);

    redflag4.setVisible(false);

    janela.add(redflag4);

    janela.add(trilhos);

    //Definindo a acao da opcao iniciar.
    iniciar.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar a opcao.
        tremum.start(); //Iniciando a thread do primeiro trem.
        tremdois.start(); //Iniciando a thread do segundo trem.
      } //Fim do actionPerfomed.
    });

    //Definindo a acao da opcao reiniciar.
    reiniciar.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar a opcao.
        trem.setBounds(40, 0, 50 ,100); //Volta o primeiro trem para a posicao inicial.
        trem2.setBounds(140, 610, 50 ,100); //Volta o segundo trem para a posicao inicial.       
      } //Fim do actionPerfomed.
    });

    //Definindo a acao da opcao aumentartremum.
    aumentartremum.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar a opcao.
        if(velocidadetremum > 50){ //Verificamos se a velocidadetremum nao esta no limite (no caso, 50).
          velocidadetremum -= 50; //Entao decrementamos 50.
        } //Fim do if.
      } //Fim do actionPerfomed.
    });

    //Definindo a acao da opcao diminuirtremum.
    diminuirtremum.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar a opcao.
        if(velocidadetremum < 200){ //Verificamos se a velocidadetremum nao esta no limite (no caso, 200);
        velocidadetremum += 50; //Entao incrementamos 50;
        } //Fim do if.       
      } //Fim do actionPerfomed.
    });
    
    //Definindo a acao da opcao aumentartremdois.
    aumentartremdois.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar o botao.
        if(velocidadetremdois > 50){ //Verificamos se a velocidadetremdois nao esta no limite (no caso 50);
          velocidadetremdois -=50; //Entao descrementamos 50.
        } //Fim do if.
      } //Fim do actionPerfomed.
    });

    //Definindo a acao da opcao diminuirtremdois.
    diminuirtremdois.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) { //Ao acionar o botao.
        if(velocidadetremdois < 200){ //Verificamos se a velocidadetremdois nao esta no limite (no caso 200);
          velocidadetremdois +=50; //Entao incrementamos 50.
        } //Fim do if.
      } //Fim do actionPerformed.
    });
  } //Fim do contrutor Tela().    
} //Fim da classe Tela.