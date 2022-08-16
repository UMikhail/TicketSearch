package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {
    Ticket ticket1 = new Ticket(2,8_000,"VKO", "IKT", 3000);
    Ticket ticket2 = new Ticket(1,9_500,"IKT", "VKO", 2800);
    Ticket ticket3 = new Ticket(44,11_000,"LED", "HTA", 3500);
    Ticket ticket4 = new Ticket(8,7_500,"HTA", "SVO", 3200);
    Ticket ticket5 = new Ticket(10,2_000,"VKO", "LED", 30);
    Ticket ticket6 = new Ticket(18,8_000,"LED","HTA",3500);

    @Test
    public void testRemoveBiId() {
        TicketRepository repo = new TicketRepository();

        repo.save(ticket2);
        repo.save(ticket4);
        repo.save(ticket6);
        repo.removeBiId(8);

        Ticket[] expected = {ticket2, ticket6};
        Ticket[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveBiIdNFE() {
        TicketRepository repo = new TicketRepository();

        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket5);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeBiId(100);
        });
    }

    @Test
    public void testAdd() {
        TicketRepository repo = new TicketRepository();

        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.save(ticket6);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }
}
