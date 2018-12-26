package cn.stylefeng.guns.modular.products.service.impl;

import cn.stylefeng.guns.modular.system.model.Products;
import cn.stylefeng.guns.modular.system.dao.ProductsMapper;
import cn.stylefeng.guns.modular.products.service.IProductsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-21
 */
@Service
public class ProductsServiceImpl extends ServiceImpl<ProductsMapper, Products> implements IProductsService {

}
