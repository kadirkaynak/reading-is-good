package com.company.readingisgood.service.impl;

import com.company.readingisgood.dto.input.OrderCreateDto;
import com.company.readingisgood.dto.output.OrderOutputDto;
import com.company.readingisgood.entity.Book;
import com.company.readingisgood.entity.Order;
import com.company.readingisgood.mapper.OrderMapper;
import com.company.readingisgood.repository.OrderRepository;
import com.company.readingisgood.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderMapper orderMapper;

    @Mock
    private SequenceGeneratorService sequenceGenerator;
    @Mock
    private BookService bookService;

    private Order order;
    private OrderOutputDto orderOutputDto;
    private OrderCreateDto orderCreateDto;
    private Book book;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    @BeforeEach
    public void setUp(){
        order = Order.builder().customerId(1L).bookId(1L).amount(10).price(10.0).build();
        orderOutputDto = OrderOutputDto.builder().orderId(1L).customerId(1L).bookId(1L).amount(10).price(10.0).build();
        orderCreateDto = OrderCreateDto.builder().customerId(1L).bookId(1L).amount(10).build();
        book = Book.builder().bookId(1L).amount(10).name("Animal Farm").author("George Orwell").price(10.0).build();

    }

    @Test
    public void Given_Order_When_SaveOrder_Then_ReturnOrder() {
        //
        // Given
        //
        when(orderRepository.save(order)).thenReturn(order);
        //
        // When
        //
        Order saveOrder = orderService.saveOrder(order);
        //
        // Then
        //
        Assertions.assertEquals(order, saveOrder);
    }

    @Test
    public void Given_Id_When_GetOrdersById_Then_ReturnOrderOutputDtoList() {
        //
        // Given
        //
        when(orderMapper.toOrderDtoList(anyList())).thenReturn(Arrays.asList(orderOutputDto));
        when(orderRepository.findAllByCustomerId(anyLong(), any(Pageable.class))).thenReturn(Arrays.asList(order));
        //
        // When
        //
        List<OrderOutputDto> orderOutputDtoList = orderService.getOrdersById(1L, 1, 1);
        //
        // Then
        //
        Assertions.assertNotEquals(0, orderOutputDtoList.size());
    }

    @Test
    public void Given_Request_When_CreateOrder_Then_ReturnOrderOutputDto() {
        //
        // Given
        //
        when(orderRepository.save(order)).thenReturn(order);
        when(bookService.findBookById(anyLong())).thenReturn(book);
        when(bookService.saveBook(any(Book.class))).thenReturn(book);
        when(sequenceGenerator.generateSequence(Order.SEQUENCE_NAME)).thenReturn(1L);
        when(orderMapper.toOrderOutputDto(any(Order.class))).thenReturn(orderOutputDto);
        when(orderMapper.toOrder(any(OrderCreateDto.class))).thenReturn(order);
        //
        // When
        //
        OrderOutputDto saveOrder = orderService.createOrder(orderCreateDto);
        //
        // Then
        //
        Assertions.assertEquals(orderOutputDto.getOrderId(), saveOrder.getOrderId());
    }

    @Test
    public void Given_Id_When_GetOrderById_Then_ReturnOrderOutputDto() {
        //
        // Given
        //
        when(orderRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(order));
        when(orderMapper.toOrderOutputDto(any(Order.class))).thenReturn(orderOutputDto);
        //
        // When
        //
        OrderOutputDto saveOrder = orderService.getOrderById(1L);
        //
        // Then
        //
        Assertions.assertEquals(orderOutputDto.getOrderId(), saveOrder.getOrderId());
    }

    @Test
    public void Given_Dates_When_GetOrders_Then_ReturnOrderOutputDtoList() throws ParseException {
        //
        // Given
        //
        String startDate = "01-01-2021";
        String endDate = "01-01-2021";
        when(orderRepository.findByCreateDateBetween(formatter.parse(startDate),
                formatter.parse(endDate))).thenReturn(Arrays.asList(order));
        when(orderMapper.toOrderDtoList(anyList())).thenReturn(Arrays.asList(orderOutputDto));
        //
        // When
        //
        List<OrderOutputDto> saveOrder = orderService.getOrders(startDate, endDate);
        //
        // Then
        //
        Assertions.assertNotEquals(0, saveOrder.size());
    }

}