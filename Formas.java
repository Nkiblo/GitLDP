package trabalhoiap;

import java.util.Scanner;

public class Formas {

    //Atributos utilizados nos objetos
    Cor cor;
    Posicao posicao;

    public enum Tipo {
        CAIXA, CONE, CILINDRO, ESFERA, INEXISTENTE; //Diferentes tipos de formas definidos
    }

    Tipo tipo;

    //Construtor das formas em funçao dos atributos e forma escolhida.
    public Formas() {
        this.cor = null;
        this.posicao = null;
        this.tipo = Tipo.INEXISTENTE;
    }

    public Formas(Cor cor, Posicao posicao) {
        this.cor = cor;
        this.posicao = posicao;
        this.tipo = Tipo.INEXISTENTE;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "FormaGeometrica{" + "cor=" + cor + ", posicao=" + posicao + '}';
    }

    public static Tipo inputTipo(Scanner input) {
        int tipo;
        Tipo resultado = Tipo.INEXISTENTE;
        do {//Listagem dos diferentes comandos disponiveis
            System.out.println("Qual é o objeto que pretende modelar?");
            System.out.println("    1-Caixa");
            System.out.println("    2-Cone");
            System.out.println("    3-Cilindro");
            System.out.println("    4-Esfera");
            tipo = input.nextInt();

            switch (tipo) {
                case 1:
                    resultado = Tipo.CAIXA;
                    break;
                case 2:
                    resultado = Tipo.CONE;
                    break;
                case 3:
                    resultado = Tipo.CILINDRO;
                    break;
                case 4:
                    resultado = Tipo.ESFERA;
                    break;
                default:
                    System.out.println("Objeto inexistente");

            }

            System.out.println("Escolheu o objeto do tipo " + tipo);// Lê o numero pressionado pelo utilizador e  aficha o tipo escolhido

        } while (tipo < 0 || tipo > 4);

        return resultado;
    }

    public String toX3D() { //Parte X3D gerada para a parte da forma
        return "";
    }

    public static Formas novoObjeto(Scanner input) {
        Formas resultado = null;
        Tipo tipo = Formas.inputTipo(input); //Lê o tipo de objeto
        switch (tipo) {
            case CAIXA: //Se for caixa
                Caixa caixa = new Caixa(); // Cria o objeto caixa
                caixa.dimensoes(input); // Pede dimensoes
                Cor corCaixa = Cor.inputCor(input); //Pede a cor
                caixa.setCor(corCaixa); //Armazena cor
                Posicao posicaoCaixa = Posicao.inputPosicao(input); //Pede posiçao
                caixa.setPosicao(posicaoCaixa); //Armazena posicao
                resultado = caixa; //Retorna resultado
                break;
            case CONE:
                Cone cone = new Cone(); // cria o objeto cone
                cone.dimensoes(input); // Pede dimensoes
                Cor corCone = Cor.inputCor(input); //Pede a cor
                cone.setCor(corCone);//Armazena cor
                Posicao posicaoCone = Posicao.inputPosicao(input); // Pede posiçao
                cone.setPosicao(posicaoCone);//Armazena posicao
                resultado = cone;//Retorna resultado
                break;
            case CILINDRO:
                Cilindro cilindro = new Cilindro(); // Cria o objeto cilindro
                cilindro.dimensoes(input); // Pede as dimensoes
                Cor corCilindro = Cor.inputCor(input); //Pede a cor
                cilindro.setCor(corCilindro);//Armazena cor
                Posicao posicaoCilindro = Posicao.inputPosicao(input); // Pede posiçao
                cilindro.setPosicao(posicaoCilindro);//Armazena posicao
                resultado = cilindro;//Retorna resultado
                break;
            case ESFERA:
                Esfera esfera = new Esfera(); // cria o objeto esfera
                esfera.dimensoes(input); // Pede as dimensoes
                Cor corEsfera = Cor.inputCor(input); //Pede a cor
                esfera.setCor(corEsfera);//Armazena cor
                Posicao posicaoEsfera = Posicao.inputPosicao(input); // Pede posiçao
                esfera.setPosicao(posicaoEsfera);//Armazena posicao
                resultado = esfera;
                break;//Retorna resultado
        }
        return resultado;
    }

}
