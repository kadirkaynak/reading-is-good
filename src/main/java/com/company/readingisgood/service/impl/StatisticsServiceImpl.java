package com.company.readingisgood.service.impl;

import com.company.readingisgood.dto.output.StatisticsOutputDto;
import com.company.readingisgood.entity.Order;
import com.company.readingisgood.repository.OrderRepository;
import com.company.readingisgood.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final OrderRepository orderRepository;

    @Override
    public List<StatisticsOutputDto> getStatistics() {
        List<Order> orders = orderRepository.findAll();

        Map<StatisticsOutputDto, List<Order>> collect = orders.stream().collect(Collectors.groupingBy(d -> d.getCreateDate().getMonth()))
                .entrySet().stream()
                .collect(Collectors.toMap(x -> {
                    int sumAmount = x.getValue().stream().mapToInt(Order::getAmount).sum();
                    Double sumPrice = x.getValue().stream().mapToDouble(Order::getPrice).sum();
                    return new StatisticsOutputDto(new DateFormatSymbols().getMonths()[x.getKey()], sumAmount, sumPrice);
                }, Map.Entry::getValue));
        return new ArrayList<>(collect.keySet());
    }
}
