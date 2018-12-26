package cn.stylefeng.guns.modular.products.controller;

import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.core.shiro.ShiroUser;
import cn.stylefeng.guns.core.util.AliyunOSSClientUtil;
import cn.stylefeng.guns.core.util.OssUtil;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Products;
import cn.stylefeng.guns.modular.products.service.IProductsService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.tags.form.ErrorsTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 产品列表控制器
 *
 * @author fengshuonan
 * @Date 2018-12-21 15:20:14
 */
@Controller
@RequestMapping("/products")
public class ProductsController extends BaseController {

    private String PREFIX = "/products/products/";

    @Autowired
    private IProductsService productsService;

    /**
     * 跳转到产品列表首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "products.html";
    }

    /**
     * 跳转到添加产品列表
     */
    @RequestMapping("/products_add")
    public String productsAdd() {
        return PREFIX + "products_add.html";
    }

    /**
     * 跳转到修改产品列表
     */
    @RequestMapping("/products_update/{id}")
    public String productsUpdate(@PathVariable Integer id, Model model) {
        Products products = productsService.selectById(id);
        model.addAttribute("item",products);
        LogObjectHolder.me().set(products);
        return PREFIX + "products_edit.html";
    }

    /**
     * 获取产品列表列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return productsService.selectList(null);
    }

    /**
     * 新增产品列表
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Products products) {
        productsService.insert(products);
        return SUCCESS_TIP;
    }

    /**
     * 上传图片至阿里云
     */
    @RequestMapping(value = "/upload")
    @ResponseBody
    public void upload(@RequestParam("file") final MultipartFile uploadFile, final Model model,
                         final HttpServletRequest request, final HttpServletResponse response ) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        Map<String, Object> result = new HashMap<String, Object>();
        InputStream io = uploadFile.getInputStream();//获取输入文件流
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int rc = 0;
        while ((rc = io.read(buff, 0, 1024)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in = swapStream.toByteArray();
        OSSClient ossClient = AliyunOSSClientUtil.getOSSClient();
        ShiroUser currentUser = ShiroKit.getUser();
        Integer userid = currentUser.getId();
        //文件路径
        String path = AliyunOSSClientUtil.uploadByteOSS(ossClient,in,AliyunOSSClientUtil.BACKET_NAME,userid.toString());
        System.out.println("path===="+path);
        //访问网址路径
        String url = AliyunOSSClientUtil.getUrl(ossClient, AliyunOSSClientUtil.BACKET_NAME, path);
        result.put("filePath", url);
        result.put("code", 200);
        System.out.println("url===="+url);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        // 设置响应数据的类型json
        response.setContentType("application/json; charset=utf-8");
        // 写回
        response.getWriter().write(jsonObject.toString());
    }

    /**
     * 删除产品列表
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer productsId) {
        productsService.deleteById(productsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改产品列表
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Products products) {
        productsService.updateById(products);
        return SUCCESS_TIP;
    }

    /**
     * 产品列表详情
     */
    @RequestMapping(value = "/detail/{productsId}")
    @ResponseBody
    public Object detail(@PathVariable("productsId") Integer productsId) {
        return productsService.selectById(productsId);
    }
}
