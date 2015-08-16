package ru.lesson.lessons;

import ru.lesson.lessons.Pets.*;

import java.util.Scanner;

public class ClinicRunner {

    private static final boolean ANSWER_YES = true;
    private static Clinic clinic = new Clinic();
    private static Client client = null;
    private static Scanner reader = new Scanner(System.in);
    /**
     * Run pets clinic
     * @param args
     */
    public static void main(String[] args){
        ClinicRunner runner = new ClinicRunner();
        try{
            while (true) {
                System.out.println("\nENTER THE NUMBER OF OPERATION: ");
                System.out.println("[1] - ADD CLIENT;                   [6] - REDACT CLIENT NAME;"+
                        "\n[2] - REMOVE CLIENT BY NANE;        [7] - REDACT PET NAME;"+
                        "\n[3] - REMOVE CLIENT BY PET NAME;    [8] - GET NUMBER OF CLIENTS;" +
                        "\n[4] - FIND PET NAME BY CLIENT NAME; [9] - PRINT CLINIC LIST;"+
                        "\n[5] - FIND CLIENT NAME BY PET NAME; [0] - QUIT.");
                int number = Integer.valueOf(reader.next().trim());
                try{
                    switch (number){
                        case 1: runner.addClientRun();
                            break;
                        case 2: runner.removeClientByNameRun();
                            break;
                        case 3: runner.removeClientByPetNameRun();
                            break;
                        case 4: runner.findPetNameRun();
                            break;
                        case 5: runner.findClientNameRun();
                            break;
                        case 6: runner.redClientNameRun();
                            break;
                        case 7: runner.redPetNameRun();
                            break;
                        case 8: runner.getSizeRun();
                            break;
                        case 9: runner.printClinicRun();
                            break;
                        case 0: reader.close();
                            System.exit(0);
                        default:
                            System.out.println("You should select the right number! Try again..");
                            continue;
                    }
                } catch (CustomInputException | LinkedListException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (NumberFormatException e){
            System.out.println(e.toString());
        }finally {
            reader.close();
        }
    }
    private String readName(){
        String s = reader.next().trim();
        String name = Character.toString(s.charAt(0)).toUpperCase() + s.substring(1);
        return name;
    }
    private void addClientRun()throws CustomInputException {
        while(true){
            System.out.println("ENTER THE CLIENT NAME: ");
            String clientName = readName();
            System.out.println("ENTER THE PET NAME: ");
            String petName = readName();
            System.out.println("ENTER THE PET TYPE: ");
            System.out.println("[cat], [dog], [bird], [cow], [horse], [mouse], [octopus], [pig], [snake]");
            String petType = reader.next().trim();
            client = new Client(clientName, generatePet(petType, petName));
            if(client.getPet() != null){
                clinic.addClient(client);
            }else{
                System.out.println("+++Incorrect input of the pet type. Try again.+++");
                continue;
            }
            System.out.println("Add more clients: [y/n]");
            String recur = reader.next().trim();
            if (recur.equals("y")) {
                continue;
            } else {
                    break;
            }
        }
    }

    /**
     * Generate pet for the client in addRun()
     * @param petType Type for the pet
     * @param petName Name for the pet
     * @return Pet with correct type
     */
    private IPet generatePet(String petType,String petName){
        IPet[] pet = new IPet[]{new Cat(petName),new Dog(petName),new Bird(petName),new Cow(petName),new Horse(petName),
                                new Mouse(petName), new Octopus(petName), new Pig(petName), new Snake(petName)};
        IPet clientPet = null;
        for (IPet iPet: pet){
            if(iPet.getPetType().equals(petType)){
                clientPet = iPet;
                break;
            }
        }
        return clientPet;
    }
    private void removeClientByNameRun() throws LinkedListException {
        System.out.println("ENTER THE CLIENT NAME: ");
        String clientName = readName();
        boolean hasRemove = clinic.removeClientByName(clientName);
        if(hasRemove) System.out.println("Client is removed.");
        else System.out.println("Your clients name does`t exist!\nTry again..");
    }
    private void removeClientByPetNameRun() throws LinkedListException {
        System.out.println("ENTER THE PET NAME: ");
        String petName = readName();
        boolean hasRemove = clinic.removeClientByPetName(petName);
        if(hasRemove) System.out.println("Client is removed.");
        else System.out.println("This pets name does`t exist!\nTry again..");
    }
    private void findPetNameRun() throws LinkedListException,CustomInputException {
        System.out.println("ENTER THE CLIENT NAME: ");
        String clientName = readName();
        String petName = clinic.findPetName(clientName);
        System.out.println("The pets name is " + petName);
    }
    private void findClientNameRun() throws CustomInputException {
        System.out.println("ENTER THE PET NAME: ");
        String petName = readName();
        String clientName = clinic.findClientName(petName);
        System.out.println("The clients name is " + clientName);
    }
    private void redClientNameRun(){
        System.out.println("ENTER THE PRESENT CLIENT NAME: ");
        String clientName = readName();
        System.out.println("ENTER A NEW CLIENT NAME: ");
        String newClintName = readName();
        boolean hasRed = clinic.redClientName(clientName, newClintName);
        if(hasRed)
            System.out.println("A new name for the client is " + newClintName);
        else System.out.println("Your clients name is does`t exist!\nTry again..");
    }
    private void redPetNameRun(){
        System.out.println("ENTER THE PRESENT PET NAME: ");
        String petName = readName();
        System.out.println("ENTER A NEW PET NAME: ");
        String newPetName = readName();
        boolean hasRed = clinic.redPetName(petName, newPetName);
        if(hasRed)
            System.out.println("A new name for the pet is " + newPetName);
        else System.out.println("Your pets name is does`t exist!\nTry again..");
    }
    private void getSizeRun(){
        System.out.println("The number of clients is " + clinic.getSize());
    }
    private void printClinicRun(){
        clinic.printClinic();
    }
}

