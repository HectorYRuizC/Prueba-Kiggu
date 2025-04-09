package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrdenarObjetosconRestricciones {
    static class Item {
        int id;
        int prioridad;

        public Item(int id, int prioridad) {
            this.id = id;
            this.prioridad = prioridad;
        }

        @Override
        public String toString() {
            return "{id: " + id + ", prioridad: " + prioridad + "}";
        }
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(1, 2),
                new Item(2, 5),
                new Item(3, 3),
                new Item(4, 4),
                new Item(5, 1)
        );

        System.out.println("Lista Original:");
        for (Item item : items) {
            System.out.println(item);
        }

        List<Item> resultado = ordenarPorPrioridad(items);

        System.out.println("\nLista Ordenada:");
        for (Item item : resultado) {
            System.out.println(item);
        }
    }

    public static List<Item> ordenarPorPrioridad(List<Item> items) {
        List<Item> impares = new ArrayList<>();
        List<Item> pares = new ArrayList<>();

        for (Item item : items) {
            if (item.prioridad % 2 != 0) {
                impares.add(item);
            } else {
                pares.add(item);
            }
        }

        List<Item> resultado = new ArrayList<>();
        resultado.addAll(impares);
        resultado.addAll(pares);

        return resultado;
    }
}
