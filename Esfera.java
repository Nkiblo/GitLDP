package trabalhoiap;

import java.util.Scanner;

public class Esfera extends Formas {

    //Atributos da Esfera
    double raio;

    public Esfera() {
        this.tipo = Tipo.ESFERA;
    }
    //Construtor da caixa em funçao dos atributos
    public Esfera(float raio) {
        this.raio = raio;
        this.tipo = Tipo.ESFERA;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    @Override
    public String toString() { //Verifica os atributos escolhidos antes
        String s = "Objeto: ";
        s = s + " Tipo: Esfera";
        s = s + cor.toString();
        s = s + posicao.toString();
        return s;
    }

    public void dimensoes(Scanner input) {

        do { //Defenir o raio da esfera
            System.out.println("Defina o raio da esfera: ");
            raio = input.nextDouble();//Lê o valor introduzido

            if (raio < 0) {// Verifica se a esfera existe em funçao do raio
                System.out.println("Valor inválido. Introduza um valor positivo!.");
            } else {
                System.out.println("O raio da esfera é de: " + raio);
            }
        } while (raio < 0);
    }

    @Override
    public String toX3D() {//Parte X3D gerada para a parte da Esfera
        String s = posicao.toX3D();
        s = s + "            <shape>\n";
        s = s + "                <appearance> \n";
        s = s + cor.toX3D();
        s = s + "                </appearance> \n";
        s = s + "                <sphere radius='" + raio + "'></sphere> \n";

        s = s + "            </shape> \n";
        s = s + "            </transform> \n";
        return s;
    }

}
