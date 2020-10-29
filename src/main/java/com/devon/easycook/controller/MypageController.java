package com.devon.easycook.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.devon.easycook.domain.CouponDTO;
import com.devon.easycook.domain.OrdersDTO;
import com.devon.easycook.domain.OrdersDetailDTO;
import com.devon.easycook.domain.ProductDTO;
import com.devon.easycook.service.MemberService;
import com.devon.easycook.service.MypageService;
import com.devon.easycook.service.OrderService;

@Controller
@RequestMapping("/mypage")
public class MypageController {
   
   @Autowired
   MypageService mypageService;
   
   @GetMapping("/orders")
   public String orders(Model model) {   
	   
      // 나중에 session으로 id 받을것
      String id = "haram511";            
      
      List<OrdersDTO> orderList = mypageService.orders(id);
      
      model.addAttribute("orderList", orderList);
   
      return "mypage/orders";
      
   }
   
	@GetMapping("ordersProduct/{ordersNo}")
	public String ordersDetail(@PathVariable("ordersNo") int ordersNo, Model model) {
		List<OrdersDTO> detail = mypageService.ordersDetail(ordersNo);

		int totalpay = detail.get(0).getOrdersTotal();
		model.addAttribute("detail", detail);
		model.addAttribute("totalpay", totalpay);
		
		System.out.println(detail);
		return "mypage/ordersDetail";
	}
   
   
   @RequestMapping(value = "/ordersTest.action", method = RequestMethod.POST)
   public ModelAndView ordersListTest(String fromDate, String toDate, ModelAndView mv) {
	   
	   // ModelAndView 초기화 ㄱㄱ
	   mv.clear();
	   System.out.println("ordersListTest 실행");
	   System.out.println(fromDate);
	   System.out.println(toDate);
	   
	   // 나중에 session으로 id 받을것
	   String id = "haram511";
	   
	   Map<String, String> dateMap = new HashMap<String, String>();
	   dateMap.put("id", id);
	   dateMap.put("fromDate", fromDate);
	   dateMap.put("toDate", toDate);
	   SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
//	   String fromDatetoString = transFormat.format(fromDate);
//	   String toDatetoString= transFormat.format(fromDate);
	   

	   List<OrdersDTO> orderListDate = mypageService.ordersDate(dateMap);

	   
		/*
		 * int count = 0; List<String> oDate = new ArrayList<String>(); List<Integer>
		 * oNo = new ArrayList<Integer>(); List<String> oStatus = new
		 * ArrayList<String>(); List<Integer> oTotal = new ArrayList<Integer>(); for
		 * (OrdersDTO dto : orderListDate) {
		 * 
		 * String ordersDatetoString = transFormat.format(dto.getOrdersDate());
		 * oDate.add(ordersDatetoString); oNo.add(dto.getOrdersNo());
		 * oStatus.add(dto.getOrdersStatus()); oTotal.add(dto.getOrdersTotal());
		 * count++; }		   
	   System.out.println(oDate + "," + oNo + "," + oStatus);	   
	   mv.addObject("ordersDate", oDate);	 mv.addObject("ordersNo", oNo);
	   mv.addObject("ordersStatus", oStatus); mv.addObject("ordersTotal", oTotal);
	   mv.addObject("count", count); */	
	   System.out.println(orderListDate);
	   mv.addObject("fromDate", fromDate);  mv.addObject("toDate", toDate);
	   mv.addObject("orderListDate", orderListDate);
	   mv.setViewName("common/ajaxtest");
	   return mv;
	   
   }
   
   @GetMapping("/orders2")
   public String orders2(ModelAndView mv) {   
      System.out.println("orders2컨트롤러");
      // 나중에 session으로 id 받을것
      String id = "haram511";            
      
      List<OrdersDTO> orderList = mypageService.orders(id);
      
      mv.addObject("orderList", orderList);
      System.out.println("orders2 orderList" + orderList);
      mv.setViewName("mypage/orders2");
      return "mypage/orders2";
   }
   
   
   @RequestMapping("/cancelRequire")
   public String cancelRequire(@RequestParam("ordersNo") int ordersNo, Model model) {
      
	  // 나중에 session으로 id 받을것
      String id = "haram511";   

      List<OrdersDTO> cancelRequireList = mypageService.cancelRequire(ordersNo);
      
      
      // 주문번호는 어차피 하나이니, 처음 list만 가져와도 ok
      OrdersDTO orders = cancelRequireList.get(0);
      Date orderDate = orders.getOrdersDate();
      int orderNum = orders.getOrdersNo();
      
      
      List<Integer> qtyList = new ArrayList();
      
      for (int i = 0; i < cancelRequireList.size(); i++) {
    	int qty = cancelRequireList.get(i).getOrdersDetail().getDetailQty();
    	qtyList.add(i, qty);
	  }
      
      System.out.println(qtyList);
      model.addAttribute("ordersDate", orderDate);
      model.addAttribute("orderNum", orderNum);
      model.addAttribute("qtyList", qtyList);
      model.addAttribute("cancelRequire", cancelRequireList);
      return "mypage/cancelRequire";
   }  
   
   
   @GetMapping("/wishlist")
   public String wishlist() {
      return "mypage/wishlist";
   }
   @GetMapping("/cancel")
   public String cancle() {
      return "mypage/cancel";
   }
   
   
   @GetMapping("/coupon")
   public String coupon(Model model) {
      System.out.println("쿠폰내역확인 ㄱㄱ");
      
      // 나중에 @RequestParam등으로 id 받을것
      String id = "haram511";      
      
      List<CouponDTO> couponList = mypageService.coupon(id);
      int couponCount = mypageService.couponCount(id);
      int myPoint = mypageService.myPoint(id);
      
      System.out.println(couponList);
      
    
      model.addAttribute("couponList", couponList);   
      model.addAttribute("couponCount", couponCount);
      model.addAttribute("myPoint", myPoint);
      return "mypage/coupon";
   }
   
   
}