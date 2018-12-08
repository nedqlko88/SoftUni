package advancedquerying.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

public interface ShampooService {
    List<String> selectShampoosBySize(String sizeType);

    List<String> selectShampoosByPrice(String price);



}
