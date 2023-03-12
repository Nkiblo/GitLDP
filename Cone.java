package trabalhoiap;
import java.util.Scanner;

public class Cone extends Formas {
    //Atributos do Cone
    double altura, raio;

    public Cone() {
        this.tipo = Tipo.CONE;

    }
    //Construtor do cone em funçao dos atributos
    public Cone(float  altura, float raio) {
        this.altura = altura;
        this.raio = raio;
        this.tipo = Tipo.CONE;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
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
        s = s + " Tipo: Cone";
        s = s + cor.toString();
        s = s + posicao.toString();
        return s;
    }

    public void dimensoes(Scanner input) {

        do {//Defenir os atributos do cone
            System.out.println("Defina a altura do Cone: ");
            altura = input.nextDouble();//Lê o valor introduzido
            System.out.println("Defina o valor do raio da base do Cone: ");
            raio = input.nextDouble();//Lê o valor introduzido

            if (altura < 0 || raio < 0) {// Verifica se ocone existe em funçao dos atributos
                System.out.println("Valor inválido. Introduza um valor positivo!");
            } else {
                System.out.println("A altura do Cone é de: " + altura);
                System.out.println("O raio da base do Cone é de: " + raio);
            }
        } while (altura < 0 || raio < 0);
    }

    @Override
    public String toX3D() {//Parte X3D gerada para a parte da Esfera
        String s = posicao.toX3D();
        s = s + "            <shape>\n";
        s = s + "                <appearance> \n";
        s = s + cor.toX3D();
        s = s + "                </appearance> \n";
                    s = s + "                <cone bottomRadius='" + raio + "' height='" + altura + "'></cone> \n";

        s = s + "            </shape> \n";
        s = s + "            </transform> \n";
        return s;
    }
}
