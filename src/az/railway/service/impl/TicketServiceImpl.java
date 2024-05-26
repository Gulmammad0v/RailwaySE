package az.railway.service.impl;

import az.railway.dao.interf.TicketDao;
import az.railway.model.Ticket;
import az.railway.service.interf.TicketService;

import java.util.List;

public class TicketServiceImpl implements TicketService {
    TicketDao ticketDao;

    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public List<Ticket> getTicketList() throws Exception {
        return ticketDao.getTicketList();
    }

    @Override
    public void addTicket(Ticket ticket) throws Exception {
        ticketDao.addTicket(ticket);
    }

    @Override
    public Ticket getTicketById(long ticketId) throws Exception {
        return ticketDao.getTicketById(ticketId);
    }
}
