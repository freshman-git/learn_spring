package org.example.service.impl;

import org.apache.ibatis.annotations.Param;
import org.example.dao.BookDao;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    @Transactional
//    @Transactional(readOnly=true 默认是false
//                   timeout=3 超时时长
//                   noRollbackFor = ArithmeticException.class 不回滚的类型
//                   isolation = Isolation.DEFAULT 事务的隔离级别  mysql默认可重复读
//                   propagation = Propagation.REQUIRES_NEW 默认是REQUIRED)
    public void buyBook(Integer userId, Integer bookId) {
        //查询图书价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //减少图书库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId,price);
    }
}
