package com.company.readingisgood.service.impl;

import com.company.readingisgood.dto.input.OrderCreateDto;
import com.company.readingisgood.dto.output.OrderOutputDto;
import com.company.readingisgood.entity.Book;
import com.company.readingisgood.entity.Order;
import com.company.readingisgood.exception.BookAmountNotEnoughException;
import com.company.readingisgood.exception.OrderNotFoundException;
import com.company.readingisgood.mapper.OrderMapper;
import com.company.readingisgood.repository.OrderRepository;
import com.company.readingisgood.service.BookService;
import com.company.readingisgood.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BookService bookService;
    private final OrderMapper orderMapper;
    private final SequenceGeneratorService sequenceGenerator;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public Order saveOrder(Order order) {
        log.info(String.format("Date=%s|Request=%s",new Date(), order.toString()));
        return orderRepository.save(order);
    }

    @Override
    public List<OrderOutputDto> getOrdersById(Long customerId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        List<Order> orders = orderRepository.findAllByCustomerId(customerId, pageable);
        return orderMapper.toOrderDtoList(orders);
    }

    @Override
    public OrderOutputDto createOrder(OrderCreateDto request) {
        try {
            Book book = bookService.findBookById(request.getBookId());

            if (book.getAmount() < request.getAmount())
                throw new BookAmountNotEnoughException("Book amount not sufficient for requested amount: " + request.getAmount() + ", only exist: " + book.getAmount());

            Order order = orderMapper.toOrder(request);
            order.setOrderId(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME));
            order.setPrice(book.getPrice() * request.getAmount());
            order.setCreateDate(new Date());
            book.setAmount(book.getAmount() - request.getAmount());
            bookService.saveBook(book);

            return orderMapper.toOrderOutputDto(saveOrder(order));
        } catch (Exception ex) {
            throw new OptimisticLockingFailureException(String.format(
                    "There is another process related to this bookid (%s). Please try again later.", request.getBookId()));
        }
    }

    @Override
    public OrderOutputDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new OrderNotFoundException("Order could not find by id: " + orderId));
        return orderMapper.toOrderOutputDto(order);
    }

    @Override
    public List<OrderOutputDto> getOrders(String startDate, String endDate) throws ParseException {
        List<Order> orders = orderRepository.findByCreateDateBetween(
                formatter.parse(startDate),
                formatter.parse(endDate)
        );
        return orderMapper.toOrderDtoList(orders);
    }

}
