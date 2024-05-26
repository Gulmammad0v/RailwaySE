package az.railway.dao.interf;

import az.railway.model.Ticket;

import java.util.List;

public interface TicketDao {
    List<Ticket> getTicketList() throws Exception;

    void addTicket(Ticket ticket) throws Exception;

    Ticket getTicketById(long ticketId) throws Exception;
}
