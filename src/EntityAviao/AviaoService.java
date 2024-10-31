package EntityAviao;

import java.util.Map;
import java.util.Scanner;

public class AviaoService {
    Scanner sc = new Scanner(System.in);

    public void cadastrarAviao(Map<Integer, Aviao> aviaoMap) {
        if (aviaoMap.size() <= 9) {
            System.out.println("Digite o número do voo: ");
            int numero = sc.nextInt();
            sc.nextLine();
            if (aviaoMap.containsKey(numero)) {
                System.out.println("Já possui um voo com este identificador");
            } else {
                System.out.println("Digite a origem do voo: ");
                String origem = sc.nextLine();
                System.out.println("Digite o destino do voo: ");
                String destino = sc.nextLine();
                System.out.println("Quantas cadeiras restantes?: ");
                int numeroLugares = sc.nextInt();
                sc.nextLine();
                Aviao aviaoCadastro = new Aviao(numero, numeroLugares, destino, origem);
                aviaoMap.put(numero,aviaoCadastro);
            }
        } else {
            System.out.println("Quantidade de cadastros máxima atingida!.");
        }
    }

    public void consultarVooPorNumero(Map<Integer, Aviao> aviaoMap) {
        if (!aviaoMap.isEmpty()) {
            System.out.println("Digite o Identificador do voo: ");
            int numero = sc.nextInt();
            sc.nextLine();
            if (aviaoMap.containsKey(numero)) {
                System.out.printf("Identificador do voo -> %d  Origem do voo -> %s  Destino do voo -> %s  Lugares disponiveis -> %d%n", numero, aviaoMap.get(numero).getOrigem().toUpperCase(), aviaoMap.get(numero).getDestino().toUpperCase(), aviaoMap.get(numero).getNumeroDeLugares());

            } else {
                System.out.println("Não há nenhum voo com este identificador!.");
            }
        }
        else {
            System.out.println("Nenhum dado foi inserido ainda!.");
        }
    }

    public void consultarVooPorOrigem(Map<Integer, Aviao> aviaoMap) {
        if (!aviaoMap.isEmpty()) {
            int achou = 0;
            System.out.println("Digite a origem: ");
            String origem = sc.nextLine();
            for (Aviao v : aviaoMap.values()) {
                if (v.getOrigem().equals(origem)) {
                    System.out.printf("Identificador do voo -> %d  Origem do voo -> %s  Destino do voo -> %s  Lugares disponiveis -> %d%n", v.getNumero(), v.getOrigem().toUpperCase(), v.getDestino().toUpperCase(), v.getNumeroDeLugares());
                    achou = 1;
                }
            }
            if (achou != 1) {
                System.out.println("Não há nenhum voo com este identificador!.");
            }
        }
        else {
            System.out.println("Nenhum dado foi inserido!.");
        }
    }

    public void ReservarVoo(Map<Integer, Aviao> aviaoMap) {
        char escolha;
        if (!aviaoMap.isEmpty()) {
            System.out.println("Digite o identificador do voo: ");
            int numero = sc.nextInt();
            sc.nextLine();
            if (aviaoMap.containsKey(numero)) {
                if (aviaoMap.get(numero).getNumeroDeLugares() > 0) {
                    do {
                        System.out.printf("Voo de -> %s para -> %s existente quantidade de lugares disponiveis -> %d%nConfirmar reserva? S-Sim N-Não%n", aviaoMap.get(numero).getOrigem(), aviaoMap.get(numero).getDestino(), aviaoMap.get(numero).getNumeroDeLugares());
                        escolha = sc.next().charAt(0);
                        if (escolha == 'S') {
                            System.out.println("Reserva Confirmada!.");
                            int lugares = aviaoMap.get(numero).getNumeroDeLugares() - 1;
                            aviaoMap.get(numero).setNumeroDeLugares(lugares);
                        }
                    } while ((escolha != 'S')&&(escolha != 'N'));
                }
                else {
                    System.out.printf("Voo de -> %s para -> %s existente, não há lugares disponiveis%n", aviaoMap.get(numero).getOrigem(), aviaoMap.get(numero).getDestino());
                }
            }
        }
        else {
            System.out.println("Nenhum dado foi inserido!.");
        }
    }
}
