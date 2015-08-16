package ru.lesson.lessons;


public class Client{
    private String clientName;
    private IPet pet;
    /**
     * Constructor of the client
     * @param clientName Name of the client
     * @param pet Pet for the client
     */
    public Client(String clientName, IPet pet) {
        this.clientName = clientName;
        this.pet = pet;
    }
    /**
     * Get client name
     * @return client name
     */
    public String getClientName() {
        return this.clientName;
    }
    /**
     * Redacting the client name
     * @param newClientName New name of the client
     */
    public void renameClient(final String newClientName){
        this.clientName = newClientName;
    }
    /**
     * Get pet of the client
     * @return Pet of the client
     */
    public IPet getPet(){
        return this.pet;
    }
    /**
     * Change pet of the client
     * @param newPet New pet for the client
     */
    public void changePet(final IPet newPet){
        this.pet=newPet;
    }
    /**
     *Compare two Client objects by name and pet.
     * @param client Compared client
     * @return True or false
     */
    public boolean compareClient(Client client) {
        if(clientName.equals(client.getClientName()) &&
           pet.getPetType().equals(client.getPet().getPetType()) &&
           pet.getName().equals(client.getPet().getName()))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return String.format("Client %s has a %s %s",getClientName(),getPet().getPetType(),getPet().getName());
    }
    /**
     * Print list of the client
     */
     public void printClient(){
        String client = String.format("|| CLIENT: %s", this.getClientName());
        String pet = String.format("||    PET: %s", this.getPet().getName());
        String doctor = String.format("Doctor ask: %s how are you?", this.getPet().getName());
        System.out.println(String.format("%s\n%s\n%s",client,pet,doctor));
        this.getPet().getVoice();
        for ( int i = 1 ; i <= doctor.length() ; i++ ) {
            System.out.print("=");
            if (i == doctor.length())
                System.out.println("\t");
        }
    }
}