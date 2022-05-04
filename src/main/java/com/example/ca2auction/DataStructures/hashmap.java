package com.example.ca2auction.DataStructures;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class hashmap<E> {

    List<E>[] hashTable;

    public hashmap(int size){
        hashTable=(List<E>[]) new List [size];
        for(int i=0;i<hashTable.length;i++) hashTable[i]=new LinkedList<>();
    }
    public void add(E item, int key) {
        hashTable[key%hashTable.length].add(item);
    }

    public void add(E item) {
        hashTable[hashFunction(Math.abs(item.hashCode()))].add(item);
    }

    public List<E> findList(E item) {
        return hashTable[hashFunction(Math.abs(item.hashCode()))];
    }

    public int hashFunction(int k) {
        return k%hashTable.length;
    }

    public void showHashTable() {
        System.out.println("Hash Table (Using Sep Chaining)\n=====================");
        for(int i=0;i<hashTable.length;i++) {
            System.out.println("Chain " + i + "\n=======");
            for(E x : hashTable[i]) System.out.println(x);
            System.out.println();
        }
        System.out.println();
    }
    //-------------------------------------
    public static void main(String[] args){
        hashmap<String> h=new hashmap<>(12);
//        h.add(72);
//        h.add(45);
//        h.add(82);
//        h.add(455);
//        h.add(999);
//        h.add(9373);
        Scanner k=new Scanner(System.in);
        String x;
        do {
            x=k.nextLine();
            if(x.length()!=0) h.add(x);
        }while(x.length()!=0);

//            System.out.println("Find? ");
//            x=k.nextInt();
//            System.out.println("Position: "+h.findPosition(x));

        h.showHashTable();

    }
}
