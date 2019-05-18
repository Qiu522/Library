package org.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.dao.LendInfoDao;
import org.model.Book;
import org.model.LendInfo;
import org.model.Reader;
import org.service.BookService;
import org.service.LendInfoService;
import org.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("lendInfoService")
public class LendInfoServiceImpl implements LendInfoService{
	@Autowired LendInfoDao lendInfoDao;
	@Autowired ReaderService readerService;
	@Autowired BookService bookService;
	
	/*
	 * 首先确定用户可以借书否，bookcount - acount != 0
	 * 插入借书信息
	 * 用户acount++
	 * 图书remain--
	 * 
	 * result 1:借书成功  0：借书失败  2 该书还未还
	 * */
	@Override
	public int insertLendInfo(int readerId, int bookId) {
		LendInfo lendInfo = new LendInfo();
		
		Reader reader = readerService.queryReaderById(readerId);
		Book book = bookService.queryOneBook(bookId);
		int remain = reader.getTotalBookNum() - reader.getBookCount();
		
		//表示该用户还可以借书
		if(remain > 0){
			if(isBookAlready(readerId, bookId)){ //该书未处于已借
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				String s_date = df.format(new Date());
				Date lendDate = null;
				Date deadDate = null;
				try {
					lendDate = df.parse(s_date);
					deadDate = addDate(lendDate, lendInfo.getTimeLimite());
					System.out.println(lendDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				lendInfo.setReaderId(readerId);
				lendInfo.setBookId(bookId);
				lendInfo.setLendDate(lendDate);
				lendInfo.setDeadLine(deadDate);
				
				lendInfoDao.insertLendInfo(lendInfo);//插入借书信息
				int lendInfoId = lendInfo.getId();//这里java自动把新建的用户ID赋值给了user对象的主键，所以可以直接用user对象获取主键值
				System.out.println("插入借书ID为" + lendInfoId);
				
				reader.setBookCount(reader.getBookCount() + 1);//借书数加1
				readerService.updateReader(reader);
				System.out.println("用户信息更新成功");
		        book.setRemain(book.getRemain() - 1); //图书剩余减1
		        bookService.updateBook(book);
				System.out.println("图书信息更新成功");
		        
		        return 1;
			}else{
				return 2;
			}
		}
		
		
		return 0;
	}
	
	@Override
	public List<LendInfo> queryLendInfoByReaderId(int readerId) {
		return lendInfoDao.queryLendInfoByReaderId(readerId);
	}
	
	
	//追加日期
	public static Date addDate(Date date,long day) throws ParseException {
		long time = date.getTime(); // 得到指定日期的毫秒数
		day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
		time+=day; // 相加得到新的毫秒数
		return new Date(time); // 将毫秒数转换成日期
	}
	//查询该用户是否已经借过且未还
	public boolean isBookAlready(int readerId, int bookId){
		List<LendInfo> lendInfos =  queryLendInfoByReaderId(readerId);
		System.out.println(lendInfos.size());
		for(int i = 0; i < lendInfos.size(); i++){
			if(lendInfos.get(i).getBookId() == bookId){
				return false;
			}
		}
		
		return true;
	}
}
