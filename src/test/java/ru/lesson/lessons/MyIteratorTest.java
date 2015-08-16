package ru.lesson.lessons;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;


public class MyIteratorTest {
    @Test
    public void testHasNextTrue() throws Exception {
        Client client1 = new Client("Name1",new Cat("Cat1"));
        MyLinkedListFIFO myLinkedListFIFO = new MyLinkedListFIFO(client1);
        Iterator<MyLinkedListFIFO.Node<Client>> iterator = myLinkedListFIFO.iterator();
        assertEquals(true,iterator.hasNext());
    }
    @Test
    public void testHasNextFalse() throws Exception {
        MyLinkedListFIFO myLinkedListLIFO = new MyLinkedListFIFO();
        Iterator<MyLinkedListFIFO.Node<Client>> iterator = myLinkedListLIFO.iterator();
        assertEquals(false,iterator.hasNext());
    }
    @Test
    public void testNext() throws Exception {
        Client client1 = new Client("Name3",new Cat("Cat3"));
        MyLinkedListFIFO myLinkedListLIFO = new MyLinkedListFIFO(client1);
        Iterator<MyLinkedListFIFO.Node<Client>> iterator = myLinkedListLIFO.iterator();
        assertEquals(client1,myLinkedListLIFO.getClient(iterator.next()));
    }
}