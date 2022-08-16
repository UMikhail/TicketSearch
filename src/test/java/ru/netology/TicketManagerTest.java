package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(2,8_000,"AER", "IKT", 3000);
    Ticket ticket2 = new Ticket(1,9_500,"IKT", "VKO", 2800);
    Ticket ticket3 = new Ticket(44,11_000,"LED", "HTA", 3500);
    Ticket ticket4 = new Ticket(8,7_500,"HTA", "SVO", 3200);
    Ticket ticket5 = new Ticket(10,2_000,"VKO", "LED", 30);
    Ticket ticket6 = new Ticket(18,8_000,"LED","HTA",3500);
    Ticket ticket7 = new Ticket(35,4_000, "VKO", "LED", 30);
    Ticket ticket8 = new Ticket(28,8_000,"AER", "IKT", 3000);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
    }

    @Test
    public void testSearchByFromTo() {
        Ticket[] expected = {ticket6, ticket3};
        Ticket[] actual = manager.searchBy("LED", "HTA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByFromToTwo() {
        Ticket[] expected = {ticket5, ticket7};
        Ticket[] actual = manager.searchBy("VKO", "LED");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByFromToEqual() {
        Ticket[] expected = {ticket1, ticket8};
        Ticket[] actual = manager.searchBy("AER", "IKT");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByFromToUnkown() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("OOO", "AAA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchByTo() {
        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.searchBy("AAA", "SVO");

        Assertions.assertArrayEquals(expected, actual);
    }
}
