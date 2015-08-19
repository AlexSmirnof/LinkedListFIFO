package ru.lesson.lessons;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyLinkedListFIFOTest {
    @Test
    public void testClear() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.clear();
        assertEquals(0, myLinkedListFIFO.size());
    }
    @Test
    public void testContainsTrue() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        assertEquals(true,myLinkedListFIFO.contains(client));
    }
    @Test
    public void testContainsFalse() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO();
        assertEquals(false,myLinkedListFIFO.contains(client));
    }
    @Test
    public void testIsEmptyTrue() throws Exception {
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO();
        assertEquals(true,myLinkedListFIFO.isEmpty());
    }
    @Test
    public void testIsEmptyFalse() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        assertEquals(false,myLinkedListFIFO.isEmpty());
    }
    @Test
    public void testAdd() throws Exception {
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO();
        Client client = new Client("Name",new Cat("Cat"));
        myLinkedListFIFO.add(client);
        assertEquals(1, myLinkedListFIFO.size());
    }
    @Test
    public void testAddByIndex() throws Exception {
        Client client1 = new Client("Name1",new Cat("Cat1"));
        Client client2 = new Client("Name2",new Cat("Cat2"));
        Client client3 = new Client("Name3",new Cat("Cat3"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO();
        myLinkedListFIFO.add(client1);
        myLinkedListFIFO.addByIndex(1, client2);
        myLinkedListFIFO.addByIndex(2, client3);
        assertEquals(3, myLinkedListFIFO.size());
    }
    @Test(expected = LinkedListException.class)
    public void testAddByIndexException() throws Exception {
        Client client1 = new Client("Name1",new Cat("Cat1"));
        Client client2 = new Client("Name2",new Cat("Cat2"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO();
        myLinkedListFIFO.add(client1);
        myLinkedListFIFO.addByIndex(2,client2);
     }
    @Test
    public void testGetFirst() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        Client client2 = new Client("Name2", new Dog("Dog"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.add(client2);
        assertEquals(true, myLinkedListFIFO.getClient(myLinkedListFIFO.getFirst()).compareClient(client));
    }
    @Test
    public void testGetLast() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        Client client2 = new Client("Name2", new Dog("Dog"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.add(client2);
        assertEquals(true, myLinkedListFIFO.getClient(myLinkedListFIFO.getLast()).compareClient(client2));
    }
    @Test
    public void testGetNode() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        Client client2 = new Client("Name2", new Dog("Dog"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.add(client2);
        assertEquals(true, myLinkedListFIFO.getClient(myLinkedListFIFO.getNode(1)).compareClient(client));
    }
    @Test
    public void testGetClient() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        Client client2 = new Client("Name2", new Dog("Dog"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.add(client2);
        assertEquals(client2,myLinkedListFIFO.getClient(myLinkedListFIFO.getNode(2)));
    }
    @Test
    public void testIndexOf() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        assertEquals(1,myLinkedListFIFO.indexOf(client));
    }
    @Test
    public void testIndexOfMines() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        assertEquals(-1,myLinkedListFIFO.indexOf(new Client("Name2", new Dog("Dog"))));
    }
    @Test
         public void testSetClient() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        Client client2 = new Client("Name2", new Dog("Dog"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.setClient(client, client2);
        assertEquals(true,myLinkedListFIFO.contains(client2));
    }
    @Test(expected = LinkedListException.class)
    public void testSetClientException() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        Client client2 = new Client("Name2", new Dog("Dog"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.setClient(client2, client);
    }
    @Test
    public void testSetClientByIndex() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        Client client2 = new Client("Name2", new Dog("Dog"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.setClientByIndex(1, client2);
        assertEquals(true,myLinkedListFIFO.contains(client2));
    }
    @Test(expected = LinkedListException.class)
    public void testSetClientByIndexException() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        Client client2 = new Client("Name2", new Dog("Dog"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.setClientByIndex(2,client2);
    }
    @Test
    public void testRemoveFirst() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.removeFirst();
        assertEquals(0,myLinkedListFIFO.size());
    }
    @Test
    public void testRemoveLast() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.removeLast();
        assertEquals(0,myLinkedListFIFO.size());
    }
    @Test
    public void testRemoveByIndex() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.removeByIndex(1);
        assertEquals(0,myLinkedListFIFO.size());
    }
    @Test(expected = LinkedListException.class)
    public void testRemoveByIndexException() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.removeByIndex(2);
    }
    @Test
    public void testRemoveClient() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.removeClient(client);
        assertEquals(0,myLinkedListFIFO.size());
    }
    @Test(expected = LinkedListException.class)
    public void testRemoveClientException() throws Exception {
        Client client = new Client("Name",new Cat("Cat"));
        Client client2 = new Client("Name2", new Dog("Dog"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client);
        myLinkedListFIFO.removeClient(client2);
    }
    @Test
    public void testToString() throws Exception {
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO();
        String s = "[ID_1] Client Bred has a cat Tom\n";
        myLinkedListFIFO.add(new Client("Bred", new Cat("Tom")));
        assertEquals(true,s.equals(myLinkedListFIFO.toString()));
    }
}