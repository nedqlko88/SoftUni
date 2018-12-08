package advancedquerying.service;

import advancedquerying.domain.entities.Shampoo;
import advancedquerying.domain.entities.Size;
import advancedquerying.repository.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }


    // Problem 1
    @Override
    public List<String> selectShampoosBySize(String sizeType) {
        Size size = Size.valueOf(sizeType.toUpperCase());

        List<Shampoo> shampoos = this.shampooRepository.findAllBySizeOrderById(size);

        return shampoos.
                stream().
                map(s -> s.getBrand() + " " + s.getSize().name() + " " + s.getPrice() + "lv.")
                .collect(Collectors.toList());
    }

    // Problem 3
    @Override
    public List<String> selectShampoosByPrice(String input) {
        BigDecimal price = new BigDecimal(input);
        List<Shampoo> shampoos = this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);

        return shampoos.stream().
                map(s -> String.format("%s %s %.2flv.",
                        s.getBrand(),
                        s.getSize().name(),
                        s.getPrice())).
                collect(Collectors.toList());

    }
}
