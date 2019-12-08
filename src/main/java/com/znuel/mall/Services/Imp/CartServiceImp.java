package com.znuel.mall.Services.Imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.znuel.mall.Dao.CartMapper;
import com.znuel.mall.Entities.Cart;
import com.znuel.mall.Services.CartService;
import com.znuel.mall.Vo.CartContent;
import com.znuel.mall.Vo.CheckOutContent;
import com.znuel.mall.Vo.CheckOutItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    private CartMapper cartMapper;

    @Override
    public boolean addProductToCart(Cart cart) {
        //由于商品ID不知什么原因无法传送,故通过商品属性拼接进行传送,通过'-'进行分割
        String[] str = cart.getProduct_attr().split("-");
        //设置商品ID
        cart.setPID(new Integer(str[0]));
        //设置商品属性
        if(str.length==2)
            cart.setProduct_attr(str[1]);
        else
            cart.setProduct_attr("");
        //1表示该商品存在于购物车,但未下单
        cart.setStatus(1);
        //设置创建时间
        Date date = new Date();
        cart.setCreate_time(date);
        if(cartMapper.insert(cart) > 0)
            return true;
        else
            return false;
    }

    @Override
    public List<CartContent> queryCart(Integer userId) {
        List<CartContent> cartList =  cartMapper.selectByUserId(userId);
        Map<Integer,Integer> map= new HashMap<>();
        int PID = -1;
        int quantity = -1;
        List<CartContent> list = new ArrayList<>();
        //将相同商品的数量相加.
        for(int i = 0 ; i < cartList.size();i++){
            PID = cartList.get(i).getpId();
            quantity = cartList.get(i).getQuantity();
            if(map.containsKey(PID)){
                //如果商品存在更改其数量
                map.put(PID,map.get(PID)+quantity);
            }else{
                map.put(PID,quantity);
                //将不同的商品添加到购物车.
                list.add(cartList.get(i));
            }
        }
        //更新不同商品的数量和价格.
        for (int i = 0 ; i < list.size();i++){
            list.get(i).setQuantity(map.get(list.get(i).getpId()));
            list.get(i).setTotalAmount(list.get(i).getQuantity()*list.get(i).getPromotion_price());
        }
        return list;
    }

    @Override
    public boolean removeProduct(Integer id) {
        Cart cart = new Cart();
        cart.setID(id);
        //将商品的状态设为0,表示从购物车中移除.
        cart.setStatus(0);
        if(cartMapper.updateByPrimaryKeySelective(cart) > 0)
            return true;
        else
            return false;
    }

    @Override
    public double computeAmount(List<CartContent> contents) {
        double amount = 0.0;
        for (int i = 0 ; i < contents.size();i++){
            amount += contents.get(i).getTotalAmount();
        }
        return amount;
    }

    @Override
    public int getCount(Integer userId) {
        return cartMapper.getCount(userId);
    }

    @Override
    public CheckOutContent toCheckOut(String jsonStr) {
        List<CheckOutItem> checkOutItems = new ArrayList<>();//存储商品项;
        JSONArray jsonArray = JSON.parseArray(jsonStr);
        double amount = 0.0;
        //解析json数据,将json数据转换为javaBean.
        for(Object obj:jsonArray){
            JSONObject jobj = (JSONObject) obj;
            CheckOutItem item = new CheckOutItem();
            item.setId(jobj.getInteger("id"));
            item.setpId(jobj.getInteger("pId"));
            item.setProductName(jobj.getString("productName"));
            item.setPrice(jobj.getDouble("price"));
            item.setQuantity(jobj.getInteger("quantity"));
            item.setTotalAmount(jobj.getDouble("totalAmount"));
            amount += item.getTotalAmount();
            checkOutItems.add(item);
        }
        CheckOutContent checkOutContent= new CheckOutContent();
        checkOutContent.setItems(checkOutItems);
        checkOutContent.setAmount(amount);
        return checkOutContent;
    }
}
