package SystemControl;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemControl {
    private ArrayList<Alien> aliens = new ArrayList<>();
    private ArrayList<Specie> species = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);

    public SystemControl(){}

    private Planet choosePlanet(){
        System.out.print("Para Planeta de origem escolha uma das opções: \n");
        System.out.println("Opção 1 - MERCÚRIO\n" +
                "Opção 2 - VÊNUS\n" +
                "Opção 3 - MARTE,\n" +
                "Opção 4 - JUPITER,\n" +
                "Opção 5 - SATURNO,\n" +
                "Opção 6 - URANO,\n" +
                "Opção 7 - NETUNO");
        int option = Integer.parseInt(scan.nextLine());
        Planet fromPlanet = null;
        switch (option) {
            case 1:
                return Planet.MERCURY;
            case 2:
                return Planet.VENUS;
            case 3:
                return Planet.MARS;
            case 4:
                return Planet.JUPITER;
            case 5:
                return Planet.SATURN;
            case 6:
                return Planet.URANOS;
            case 7:
                return Planet.NEPTUNE;

        }

        throw new RuntimeException("Não foi informado uma opção válida");
    }

    private Behaviour chooseBehaviour(){
        System.out.print("Para Comportamento escolha uma das opções: \n");
        System.out.println("Opção 1 - VIOLENTO \n" +
                "Opção 2 - AGRESSIVO \n" +
                "Opção 3 - NEUTRO \n" +
                "Opção 4 - COMUNICATIVO \n" +
                "Opção 5 - CALMO");
        int option = Integer.parseInt(scan.nextLine());
        Behaviour behaviour = null;
        switch (option) {
            case 1:
                return behaviour = Behaviour.VIOLENT;
            case 2:
                return behaviour = Behaviour.TRUCULENT;
            case 3:
                return behaviour = Behaviour.NEUTRAL;
            case 4:
                return behaviour = Behaviour.COMMUNICATIVE;
            case 5:
                return behaviour = Behaviour.CALM;

        }

        throw new RuntimeException("Não foi informado uma opção válida");
    }

    public void registerSpecie(){
        System.out.println("Registrar nova espécie:\n");
        System.out.print("Nome: ");
        String name = scan.nextLine();
        Planet fromPlanet = this.choosePlanet();
        scan.nextLine();
        assert fromPlanet != null;
        species.add(new Specie(name, fromPlanet));
        System.out.println("Espécie registrada com sucesso!\n");
    }

    public void registerAlien(){
        System.out.println("Registrar novo alien: \n");
        System.out.println("ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        System.out.print("Nome: ");
        String name = scan.nextLine();
        System.out.print("Nome da espécie: ");
        String nameSpecie = scan.nextLine();
        Planet fromPlanet = this.choosePlanet();
        assert fromPlanet != null;
        Specie specie = new Specie(nameSpecie, fromPlanet);
        scan.nextLine();
        System.out.print("Nível de periculosidade: ");
        int lvl = scan.nextInt();
        scan.nextLine();
        Behaviour behaviour = this.chooseBehaviour();
        aliens.add(new Alien(id, name, specie, lvl, behaviour));
        System.out.println("Alien registrado com sucesso!\n");
    }

    public void showAll(){
        System.out.println("Relatório de Entrada de Aliens: \n");

        for (Alien alien : aliens) {
            System.out.println(alien.getName());
            System.out.println(alien.getSpecie().getNameSpecie());
            System.out.println(alien.getBehaviour());
            System.out.println("*******************");
        }
        System.out.println();
    }

    public void generateReport() {
        boolean isExecuting = true;

        while (isExecuting) {
            System.out.println("Sistema de Controle de Entrada de Aliens");
            System.out.println("1. Registrar Espécie");
            System.out.println("2. Registrar Alien");
            System.out.println("3. Mostrar todos os aliens cadastrados");
            System.out.println("4. Encerrar Programa");
            System.out.print("Escolha uma opção: ");

            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    registerSpecie();
                    break;
                case 2:
                    registerAlien();
                    break;
                case 3:
                    showAll();
                    break;
                case 4:
                    isExecuting = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.\n");
                    break;
            }
        }

        scan.close();
    }


}
