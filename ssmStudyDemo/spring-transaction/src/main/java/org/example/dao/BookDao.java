package org.example.dao;

import org.apache.ibatis.annotations.Param;

public interface BookDao {
    Integer getPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    void updateBalance(Integer userId,Integer price);
}
