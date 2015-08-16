package ru.lesson.lessons;

import org.junit.Test;

import static org.junit.Assert.*;


public class ClinicTest {
    @Test
    public  void testAddClient() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals(1, clients.getSize());
    }
    @Test(expected = CustomInputException.class)
    public synchronized void testAddClientCustomInputException() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        clients.addClient(new Client("Mr Bob", new Dog("Chap")));
    }
    @Test
    public synchronized void testRemoveClientByNameTrue() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals(true,clients.removeClientByName("Mr Bob"));
    }
    @Test
    public synchronized void testRemoveClientByNameFalse() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals(false,clients.removeClientByName("Ms Smith"));
    }
    @Test
    public synchronized void testRemoveClientByPetNameTrue() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals(true, clients.removeClientByPetName("Chap"));
    }
    @Test
    public synchronized void testRemoveClientByPetNameFalse() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals(false, clients.removeClientByPetName("Sam"));
    }
    @Test
    public synchronized void testFindPetName() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals("Chap",clients.findPetName("Mr Bob"));
    }
    @Test(expected = CustomInputException.class)
    public synchronized void testFindPetNameE() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals("Chap",clients.findPetName("Ms Bob"));
    }
    @Test
    public synchronized void testFindClientName() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals("Mr Bob",clients.findClientName("Chap"));
    }
    @Test(expected = CustomInputException.class)
    public synchronized void testFindClientNameE() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals("Mr Bob",clients.findClientName("Chapp"));
    }
    @Test
    public synchronized void testRedClientNameTrue() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals(true, clients.redClientName("Mr Bob", "Mr Bill"));
    }
    @Test
    public synchronized void testRedClientNameFalse() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals(false,clients.redClientName("Bob","Mr Bill"));
    }
    @Test
    public synchronized void testRedPetNameTrue() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals(true, clients.redPetName("Chap", "Bobby"));
    }
    @Test
    public synchronized void testRedPetNameFalse() throws Exception {
        Clinic clients = new Clinic();
        Client client = new Client("Mr Bob", new Dog("Chap"));
        clients.addClient(client);
        assertEquals(false,clients.redPetName("Chapp","Bobby"));
    }
}