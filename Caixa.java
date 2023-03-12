package trabalhoiap;

import java.util.Scanner;

public class Caixa extends Formas {

    //Atributos da caixa
    float aresta;
    float altura;

    public Caixa() {
        this.tipo = Tipo.CAIXA;
    }

    //Construtor da cilindro em funçao dos atributos
    public Caixa(float aresta, float altura) {
        this.aresta = aresta;
        this.altura = altura;
        this.tipo = Tipo.CAIXA;
    }
    
    
    public double getAltura(){
        return altura;
    }
    public void setAltura(float altura){
    this.altura = altura;
    }
    
    public double getAresta() {
        return aresta;
    }

    public void setAresta(float aresta) {
        this.aresta = aresta;
    }
    
    

    @Override
    public String toString() { //Verifica os atributos escolhidos antes
        String s = "Objeto: ";
        s = s + " Tipo: Caixa";
        s = s + cor.toString();
        s = s + posicao.toString();
        return s;
    }

    public void dimensoes(Scanner input) {

        do {//Defenir os atributos da caixa
            System.out.println("Defina a aresta da caixa: ");
            aresta = input.nextFloat();//Lê o valor introduzido
             System.out.println("Defina a altura da caixa: ");
            altura = input.nextFloat();//Lê o valor introduzido

            if (aresta < 0 || altura <0) {// Verifica se ocone existe em funçao dos atributos
                System.out.println("Valor inválido. Introduza um valor positivo!");
            } else {
                System.out.println("A aresta =  " + aresta +" Altura = "+ altura );
            }
        } while (aresta < 0|| altura <0);
        

    }

    @Override//Parte X3D gerada para a parte da Esfera
    public String toX3D() {
        String s = posicao.toX3D();
        s = s + "            <shape>\n";
        s = s + "                <appearance> \n";
        s = s + cor.toX3D();
        s = s + "                </appearance> \n";
        s = s + "                <box size='" + aresta + " " + altura + " " + aresta + "'></box> \n";

        s = s + "            </shape> \n";
        s = s + "            </transform> \n";
        return s;

    }

}
