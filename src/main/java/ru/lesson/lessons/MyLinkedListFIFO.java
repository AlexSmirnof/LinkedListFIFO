package ru.lesson.lessons;

import java.util.Iterator;

/**
 * MyArrayListFIFO(one-directed list) for the PetClinic.
 * Has inner class MyIterator.
 * Has nested class Node<Client>
 */
public class MyLinkedListFIFO implements Iterable{
    private Node<Client> header;
    private int size;
    /**
     * Constructor without parameter
     */
    public MyLinkedListFIFO(){
        header = new Node<>(null,null);
        size = 0;
    }
    /**
     * Constructor with parameter
     */
    public MyLinkedListFIFO(final Client client){
        this();
        addFirst(client);
    }
    /**
     * Check index for MyLinkedListFIFO
     * @param index
     * @throws LinkedListException
     */
    private void checkIndex(final int index)throws LinkedListException {
        if(index <= 0 || index > size())
            throw new LinkedListException("You should input correct index : 0 < index <= "+size()+" !!!");
    }
    /**
     * Return size for MyLinkedListFIFO
     * @return Size
     */
    public int size(){
        return size;
    }
    /**
     * Clear MyLinkedListFIFO to null
     */
    public void clear(){
        this.header = new Node<>(null,null);
        size = 0;
    }
    /**
     * Check if client exist in MyLinkedListFIFO
     * @param client Checking client
     * @return True or false
     */
    public boolean contains(final Client client){
        boolean has = false;
        Iterator<Node<Client>> iterator = this.iterator();
        while (iterator.hasNext()){
            if(iterator.next().element.compareClient(client)){
                has = true;
                break;
            }
        }
        return has;
    }
    /**
     * Checking MyArrayListLIFO for the emptiness.
     * @return
     */
    public boolean isEmpty(){
        return size() == 0;
    }
    /**
     * Add first client to MyArrayListFIFO
     * @param client
     */
    public void addFirst(final Client client){
        Node<Client> newNode = new Node<>(client,header);
        header.next = newNode;
        header.prev = newNode;
        size++;
    }
    /**
     * Add client to MyArrayListFIFO
     * @param client
     */
    public void add(final Client client){
        if(size == 0){
            addFirst(client);
        }else{
            Node<Client> nextNode = header.prev;
            Node<Client> newNode = new Node<>(client, header);
            nextNode.next =newNode;
            header.prev = newNode;
            size++;
        }
    }
    /**
     * Return first element from MyArrayListFIFO
     * @return first element
     */
    public Node<Client> getFirst(){
        return header.next;
    }
    /**
     * Return last element from MyArrayListFIFO
     * @return last element
     */
    public Node<Client> getLast(){
        return header.prev;
    }
    /**
     * Return element by index
     * @param index
     * @return element
     */
    public Node<Client> getNode(int index){
        try{
            checkIndex(index);
        } catch (LinkedListException e){
            System.out.println(e.getMessage());
        }
        if (index == size())
            return getLast();
        if(index == 1)
            return getFirst();
        Node<Client> requiredNode = header.next;
        for( int i = 1 ; i < index ; i++){
            requiredNode = requiredNode.next;
        }
        return requiredNode;
    }
    /**
     * Return client by node
     * @param node
     * @return client
     */
    public Client getClient(final Node<Client> node){
        return node.element;
    }
    /**
     * Return index of client
     * @param client
     * @return index
     */
    public int indexOf(final Client client){
        if(!contains(client))
            return -1;
        if(getLast().element.compareClient(client))
            return size();
        Iterator<Node<Client>> iter = this.iterator();
        int index = 1;
        for( ; index < size(); index++){
            if(getNode(index).element.compareClient(client))
                break;
        }
        return index;
    }
    /**
     * Change existing client on the new customer client.
     * @param client
     * @param newClient
     * @throws LinkedListException
     */
    public void setClient(final Client client, final Client newClient) throws LinkedListException{
        if(!contains(client))
            throw new LinkedListException("This client "+client.toString()+" is does`t exist !!!");
        getNode(indexOf(client)).element = newClient;
    }
    /**
     * Change existing client on the new customer client by index.
     * @param index
     * @param client New client
     * @return existing client
     */
    public Node<Client> setClientByIndex(final int index, final Client client)throws LinkedListException{
        checkIndex(index);
        Node settedClient = getNode(index);
        getNode(index).element = client;
        return settedClient;
    }
    /**
     * Remove first element from MyArrayListFIFO
     * @return first element
     */
    public Node<Client> removeFirst(){
        if (size()==0)
            return null;
        Node first = getFirst();
        if(size()==1)
            clear();
        else{
            header.next = getFirst().next;
            size--;
        }
        return first;
    }
    /**
     * Remove last element from MyArrayListFIFO
     * @return last element
     */
    public Node<Client> removeLast(){
        if(size() == 0)
            return null;
        Node last = getLast();
        if(size() == 1)
            return removeFirst();
        else if(size() == 2){
            getFirst().next = header;
            header.prev =  getFirst();
        } else{
            getNode(size() - 1).next = header;
            header.prev = getNode(size() - 1);
        }
        size--;
        return last;
    }
    /**
     * Remove element by index
     * @param index
     * @return removing element
     * @throws LinkedListException
     */
    public Node<Client> removeByIndex(final int index) throws LinkedListException {
        checkIndex(index);
        if(index==1)
            return removeFirst();
        if(index==size())
            return removeLast();
        Node removedClient = getNode(index);
        getNode(index-1).next = getNode(index+1);
        size--;
        return removedClient;
    }
    /**
     * Remove element by client
     * @param client
     * @throws LinkedListException
     */
    public void removeClient(final Client client) throws LinkedListException{
        if(!contains(client))
            throw new LinkedListException("This client "+client.toString()+" is does`t exist !!!");
        int index = indexOf(client);
        if(index == 1)
            removeFirst();
        else if(index == size())
            removeLast();
        else {
            getNode(index-1).next = getNode(index+1);
            size--;
        }
    }
    /**
     * Return array of elements from existing MyArrayListFIFO
     * @return array
     */
    public Node[] toArray(){
        final Node[] arrNode = new Node[size()];
        for (int  i = 0 ; i < size() ; i ++){
            arrNode[i]= getNode(i+1);
        }
        return arrNode;
    }
    /**
     * toString for MyArrayListFIFO with parameter
     * @param index of the client
     * @return Client content.
     */
    public String toString(final int index) throws LinkedListException{
        checkIndex(index);
        return String.format("[ID_%d] %s\n",index,getNode(index).element.toString());
    }
    /**
     * toString for MyArrayListFIFO
     * @return MyArrayList content
     */
    public String toString() {
        String s = "";
        for(int i = 1 ; i <= size ; i++)
            try {
                s+=toString(i);
            } catch (LinkedListException e) {
                e.printStackTrace();
            }
        return s;
    }
    /**
     * Implements iterator for MyArrayListFIFO.
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {
        return new MyIterator(header);
    }
    /**
     * Nested class Node for MyArrayListFIFO
     * @param <E> type of elements
     */
    public static class Node<E>{
        private E element;
        private Node<E> next,prev;
        /**
         * Constructor for one-directed list
         * @param element
         * @param next
         */
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
            prev = null;
        }
    }
    /**
     * Inner class MyIterator
     */
    public class MyIterator implements Iterator{

        private Node<Client> node;

        public MyIterator(final Node<Client> node) {
            this.node = node;
        }
        /**
         * Checks if list has next element.
         * @return True if it has or false if not.
         */
        @Override
        public boolean hasNext() {
            return node.next != null && node.next != header;
        }
        /**
         * Get next client of list.
         * @return Next element.
         */
        @Override
        public Node<Client> next(){
            return  node = node.next;
        }
    }
}