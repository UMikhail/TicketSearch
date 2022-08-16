package ru.netology;
import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket product) {
        repo.save(product);
    }

    //Поиск билетов по отправлению и прибытию

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу продукты
        for (Ticket product : repo.findAll()) {
            if (matches(product, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1]; // "добавляем в конец" массива result продукт product
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;

                Arrays.sort(result);
            }
        }
        return result;
    }

    public boolean matches(Ticket product, String searchFrom, String searchTo) {
        if (product.getFrom().contains(searchFrom)) {
            return true;
        }
        if (product.getTo().contains(searchTo)) {
            return true;
        } else {
            return false;
        }
    }
}

