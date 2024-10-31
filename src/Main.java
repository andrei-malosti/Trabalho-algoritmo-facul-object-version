
import EntityAviao.Aviao;
import EntityAviao.AviaoService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AviaoService aviao = new AviaoService();
        Map<Integer, Aviao> aviaoMap = new TreeMap<>();
        int opcao;
        do {
            do {
                System.out.printf("%nMenu%n1->Cadastrar voo%n2->Consultar voo por número%n3->Consultar voo por origem%n4->efetuar reserva%n5->Sair%n");
                opcao = sc.nextInt();
                sc.nextLine();
                if (((opcao != 1) && (opcao != 2) && (opcao != 3) && (opcao != 4) && (opcao != 5))) {
                    System.out.println("digite um número do menu");
                }

                switch (opcao) {
                    case 1:
                        aviao.cadastrarAviao(aviaoMap);
                        break;
                    case 2:
                        aviao.consultarVooPorNumero(aviaoMap);
                        break;
                    case 3:
                        aviao.consultarVooPorOrigem(aviaoMap);
                        break;
                    case 4:
                        aviao.ReservarVoo(aviaoMap);
                        break;
                }
            } while ((opcao != 1) && (opcao != 2) && (opcao != 3) && (opcao != 4) && (opcao != 5));
        } while (opcao != 5);
    }
}