package trabalhoiap;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);//Ler o teclado do utilizador

        int maxObjetos = 15; //Objetos maximos que podem ser guardados
        int comandos; //Para escolher as acçoes desejadas
        //Array de 10 objetos 
        Formas[] objetos = new Formas[maxObjetos];
        int numObjetos = 0; // Numero de objetos inicial nos arrays
        int forma; //Forma que vai ser escolhida

        do { //Listagem dos diferentes comandos disponiveis
            System.out.println("Trabalho Recurso: Ferramenta de modelação tridimensional: ");
            System.out.println("Pressione o numero atribuido para aceder a esse comando ");
            System.out.println("    1-Criar um novo Objeto");
            System.out.println("    2-Alterar um Objeto");
            System.out.println("    3-Apagar um Objeto");
            System.out.println("    4-Listar todos os Objetos");
            System.out.println("    5-Gerar o modelo X3D de um objeto");
            System.out.println("    0-Sair da ferramenta");
            comandos = input.nextInt(); // Lê o numero pressionado pelo utilizador

            if (comandos < 0 || comandos > 5) { //Este serve para verificar se o numero introduzido esta entre 0 e 5. Se não for o caso:
                System.out.println("Esse comando não existe, tente outro, por favor.");
            } else if (comandos == 1) {//Verifica se o numero introduzido foi = 1.
                System.out.println("Criar um novo objeto.");
                if (numObjetos >= maxObjetos) {//Verifica se o numero de onjetos maximos foi alcansado
                    System.out.println("Não é possivel criar mais objetos.");
                } else {
                    numObjetos++; // Adiciona um objeto a mais a lista

                    System.out.println("Novo objeto com número: " + numObjetos);//Da o numero do objeto actual /15

                    forma = numObjetos - 1; //O objeto está na posiçao numObjetos - 1

                    objetos[forma] = Formas.novoObjeto(input);//Acede a Formas.java para escolher a forma

                }

            } else if (comandos == 2) { //Verifica se o numero introduzido foi = 2.
                System.out.println("Alterar um objeto.");
                System.out.println("Qual é o número do objeto que quer alterar? (numero de objetos = " + numObjetos + ").");
                forma = input.nextInt();//Lê o numero pressionado pelo utilizador para saber qual vai ser alterado

                if (forma < 1 || forma > numObjetos) { //Verfica a existensia desse objeto
                    System.out.println("Objeto inexistente.");
                } else { //Introduzir os novos valores do objeto
                    System.out.println("Alteração do objeto número: " + forma);

                    objetos[forma - 1] = Formas.novoObjeto(input);

                }

            } else if (comandos == 3) {//Verifica se o numero introduzido foi = 3.
                System.out.println("Apagar um objeto.");
                System.out.println("Qual o número do objeto  a apagar? (numero de objetos = " + numObjetos + ").");
                forma = input.nextInt();//Lê o numero pressionado pelo utilizador para saber qual vai ser apagado

                if (forma < 1 || forma > numObjetos) {//Verfica a existensia desse objeto
                    System.out.println("Objeto inexistente.");
                } else { //Apagar o objeto em funçao do num escolhido
                    System.out.println("Apagar o objeto número: " + forma);

                    System.out.println(objetos[forma - 1].toString());

                    for (int i = forma - 1; i < maxObjetos - 1; i++) {
                        //Retirar uma posiçao a todos os objetos no array
                        //O valor da posição i+1 passa para a posiçao i
                        objetos[i] = objetos[i + 1];

                    }

                    numObjetos--; //Retira um objeto da lista
                }
            } else if (comandos == 4) {//Verifica se o numero introduzido foi = 4.
                System.out.println("Listagem de todos os objetos: ");

                if (numObjetos == 0) { // Se o não houver objetos criados
                    System.out.println("Não existem objetos");

                }

                for (int i = 0; i < numObjetos; i++) { // Mostra todos os objetos criados em funçao de i até numObjetos
                    System.out.println(objetos[i].toString());
                }

            } else if (comandos == 5) {//Verifica se o numero introduzido foi = 5.
                System.out.println("Gerar modelo X3D de um objeto.");//Cria o modelo x3d em funçao do material dado pelos docentes
                String s = "<html>\n";
                s = s + "    <head>\n";
                s = s + "        <title>IPVC</title> 			\n";
                s = s + "        <script type='text/javascript' src='http://www.x3dom.org/download/x3dom.js'> </script> \n";
                s = s + "        <link rel='stylesheet' type='text/css' href='http://www.x3dom.org/download/x3dom.css'></link> \n";
                s = s + "    </head> \n";
                s = s + "    <body> \n";
                s = s + "        <h1>Introdução à Programação - ECGM 2022/2023 - Recurso 06 Febreiro</h1> \n";
                s = s + "        <p> \n";
                s = s + "            Trabalho Prático - Editor de X3D (linguagem descritiva de mundos virtuais). \n";
                s = s + "        </p>\n\n"; //

                s = s + "        <x3d width='900px' height='600px'>\n"; // Começa a listagem X3D do objeto selecionado
                s = s + "        <scene>\n";

                for (int i = 0; i < numObjetos; i++) {
                    s = s + objetos[i].toX3D();

                }

                s = s + "        </scene>\n";
                s = s + "        </x3d>\n";
                //Começa a listagem X3D do objeto selecionado
                s = s + "    </body> \n";
                s = s + "</html> \n";
                

                System.out.println(s);//Mostra o modelo X3D obtido

            }

        } while (comandos != 0);//Verifica se o numero introduzido foi = 0.

        System.out.println("Programa terminado, Obrigado!");//Fim do programa depois 

    }

}
