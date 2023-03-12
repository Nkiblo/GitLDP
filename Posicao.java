package trabalhoiap;

import java.util.Scanner;

public class Posicao {

    //Posiçoes cartesianas do objeto
    int x, y, z;

    //Construtor das posiçoes dos objetos
    public Posicao(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return " Posição XYZ: " + x + ", " + y + ", " + z + " ";
    }

    public static Posicao inputPosicao(Scanner input) {//Listagem das diferentes posiçoes a serem introduzidas
        int posicaoX, posicaoY, posicaoZ;

        System.out.println("Qual a posição do objeto? (X, Y, Z)");
        System.out.println(" Introduza X: ");
        posicaoX = input.nextInt();//Lê o valor introduzido
        System.out.println(" Introduza Y: ");
        posicaoY = input.nextInt();//Lê o valor introduzido
        System.out.println(" Introduza Z: ");
        posicaoZ = input.nextInt();//Lê o valor introduzido

        Posicao resultado = new Posicao(posicaoX, posicaoY, posicaoZ);

        return resultado; //Retorna as posiçoes
    }

    public String toX3D() {//Parte X3D gerada para a parte da posiçao
        return "            <transform translation='" + x + " " + y + " " + z + "'>\n";

    }

}
