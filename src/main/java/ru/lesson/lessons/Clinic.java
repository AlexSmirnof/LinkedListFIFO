package ru.lesson.lessons;

public class Clinic {
    /**
     * Clients list of the clinic
     */
    private MyLinkedListFIFO clients;

    public Clinic() {
        this.clients = new MyLinkedListFIFO();
    }

    /**
     * Constractor with parameter
     *
     * @param client
     */
    public Clinic(final Client client) {
        this();
        clients.addFirst(client);
    }

    /**
     * Delegate addClient() from MyArrayList
     *
     * @param client New client for the clinic
     * @throws CustomInputException
     */
    public void addClient(final Client client) throws CustomInputException {
        if (clients.contains(client))
            throw new CustomInputException("This client is already exist !!!");
        clients.add(client);
    }

    /**
     * Remove client from the list by client name
     *
     * @param clientName Name of the client that must be removed from clinic
     * @return True if remove complete or false if not
     * @throws LinkedListException
     */
    public boolean removeClientByName(final String clientName) throws LinkedListException {
        boolean hasRemove = false;
        MyLinkedListFIFO.MyIterator myIterator = (MyLinkedListFIFO.MyIterator) clients.iterator();
        while (myIterator.hasNext()) {
            Client removedClient = clients.getClient(myIterator.next());
            if (removedClient.getClientName().equals(clientName)) {
                clients.removeClient(removedClient);
                hasRemove = true;
                break;
            }
        }
        return hasRemove;
    }

    /**
     * Remove client from the list by pet name
     *
     * @param petName Name of the pet that must be removed from clinic
     * @return True if remove complete or false if not
     * @throws LinkedListException
     */
    public boolean removeClientByPetName(final String petName) throws LinkedListException {
        boolean hasRemove = false;
        MyLinkedListFIFO.MyIterator myIterator = (MyLinkedListFIFO.MyIterator) clients.iterator();
        while (myIterator.hasNext()) {
            Client removedClient = clients.getClient(myIterator.next());
            if (removedClient.getPet().getName().equals(petName)) {
                clients.removeClient(removedClient);
                hasRemove = true;
                break;
            }
        }
        return hasRemove;
    }

    /**
     * Search name of the pet by the clients name
     *
     * @param clientName Clients name for the search
     * @return Received pets name
     * @throws LinkedListException
     */
    public String findPetName(final String clientName) throws LinkedListException, CustomInputException {
        IPet requiredPet = null;
        MyLinkedListFIFO.MyIterator myIterator = (MyLinkedListFIFO.MyIterator) clients.iterator();
        while (myIterator.hasNext()) {
            Client currentClient = clients.getClient(myIterator.next());
            if (currentClient.getClientName().equals(clientName)) {
                requiredPet = currentClient.getPet();
                break;
            }
        }
        if (requiredPet == null)
            throw new CustomInputException("Your client " + clientName + " name is does`t exist!");
        return requiredPet.getName();
    }

    /**
     * Search name of the client by pets name
     *
     * @param petName Pets name for the search
     * @return Received clients name
     */
    public String findClientName(final String petName) throws CustomInputException {
        Client requiredClient = null;
        MyLinkedListFIFO.MyIterator myIterator = (MyLinkedListFIFO.MyIterator) clients.iterator();
        while (myIterator.hasNext()) {
            Client currentClient = clients.getClient(myIterator.next());
            if (currentClient.getPet().getName().equals(petName)) {
                requiredClient = currentClient;
                break;
            }
        }
        if (requiredClient == null)
            throw new CustomInputException("Your petName " + petName + " name is does`t exist!");
        return requiredClient.getClientName();
    }

    /**
     * Redacting name of client
     *
     * @param clientName    Name of client
     * @param newClientName New name of client
     * @return True if redact complete or false if not
     */
    public boolean redClientName(String clientName, String newClientName) {
        boolean hasRedact = false;
        MyLinkedListFIFO.MyIterator myIterator = (MyLinkedListFIFO.MyIterator) clients.iterator();
        while (myIterator.hasNext()) {
            Client currentClient = clients.getClient(myIterator.next());
            if (currentClient.getClientName().equals(clientName)) {
                currentClient.renameClient(newClientName);
                hasRedact = true;
                break;
            }
        }
        return hasRedact;
    }

    /**
     * Redacting name of pet
     *
     * @param petName    Name of pet
     * @param newPetName New name of pet
     * @return True if redact complete or false if not
     */
    public boolean redPetName(String petName, String newPetName) {
        boolean hasRedact = false;
        MyLinkedListFIFO.MyIterator myIterator = (MyLinkedListFIFO.MyIterator) clients.iterator();
        while (myIterator.hasNext()) {
            Client currentClient = clients.getClient(myIterator.next());
            if (currentClient.getPet().getName().equals(petName)) {
                currentClient.getPet().setName(newPetName);
                hasRedact = true;
                break;
            }
        }
        return hasRedact;
    }

    /**
     * Print clients list for the clinic
     */
    public void printClinic() {
        System.out.printf("%sTOTAL: %d clients\n", clients.toString(), clients.size());
    }

    /**
     * Return size of clinic list
     *
     * @return Size of clinic list
     */
    public int getSize() {
        return clients.size();
    }
}